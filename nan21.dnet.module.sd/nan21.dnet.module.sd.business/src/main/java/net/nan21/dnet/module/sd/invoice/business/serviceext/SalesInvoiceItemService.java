/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesTaxBD;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceItemService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

public class SalesInvoiceItemService
		extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.SalesInvoiceItemService
		implements ISalesInvoiceItemService {

	private List<Long> invoiceIds;

	@Override
	protected void postUpdate(SalesInvoiceItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(SalesInvoiceItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<SalesInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (SalesInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getSalesInvoice().getId())) {
				this.updateAmount(item.getSalesInvoice().getId());
				invoiceIds.add(item.getSalesInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void postUpdate(List<SalesInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (SalesInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getSalesInvoice())) {
				this.updateAmount(item.getSalesInvoice().getId());
				invoiceIds.add(item.getSalesInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void preDeleteByIds(List<Object> ids) throws Exception {
		this.invoiceIds = new ArrayList<Long>();
		List<SalesInvoiceItem> items = this.findByIds(ids);
		for (SalesInvoiceItem item : items) {
			this.invoiceIds.add(item.getSalesInvoice().getId());
		}
	}

	@Override
	protected void postDeleteByIds(List<Object> ids) {
		for (Long invoiceId : this.invoiceIds) {
			this.updateAmount(invoiceId);
		}
		invoiceIds = null;
	}

	@Override
	protected void preDeleteById(Object id) {
		invoiceIds = new ArrayList<Long>();
		invoiceIds.add(this.em.getReference(SalesInvoiceItem.class, id)
				.getSalesInvoice().getId());
	}

	@Override
	protected void postDeleteById(Object id) {
		this.updateAmount(invoiceIds.get(0));
		invoiceIds = null;
	}

	private void updateAmount(Long invoiceId) {
		this.em.flush();
		Object[] x = (Object[]) this.em
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from SalesInvoiceItem i where i.salesInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).getSingleResult();
		SalesInvoice invoice = this.em.find(SalesInvoice.class, invoiceId);

		Double totalNet = (Double) x[0];
		Double totalTax = (Double) x[1];
		if (totalNet == null) {
			totalNet = 0D;
		}
		if (totalTax == null) {
			totalTax = 0D;
		}
		invoice.setTotalNetAmount(totalNet.floatValue());
		invoice.setTotalTaxAmount(totalTax.floatValue());

		// re-create taxes
		// delete existing
		this.em.createQuery(
				"delete from " +SalesInvoiceTax.class.getSimpleName()+ " t "
						+ " where t.salesInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).executeUpdate();

		// create new

		List<Object[]> taxes = (List<Object[]>) this.em
				.createQuery(
						"select i.tax,  sum(i.baseAmount), sum(i.taxAmount) from "+SalesInvoiceItemTax.class.getSimpleName()+" i "
								+ " where i.salesInvoiceItem.salesInvoice.id = :invoiceId "
								+ " group by i.tax ").setParameter("invoiceId",
						invoiceId).getResultList();
		for (Object[] tax : taxes) {
			Tax t = (Tax) tax[0];
			Double baseval = (Double) tax[1];
			Double taxval = (Double) tax[2];
			if (baseval == null) {
				baseval = 0D;
			}
			if (taxval == null) {
				taxval = 0D;
			}

			SalesInvoiceTax invTax = new SalesInvoiceTax();
			invTax.setSalesInvoice(invoice);
			invTax.setTax(t);
			invTax.setBaseAmount(baseval.floatValue());
			invTax.setTaxAmount(taxval.floatValue());
			invoice.addToTaxes(invTax);
		}

		this.em.merge(invoice);
	}

	protected void calculateTaxes(SalesInvoiceItem item) throws Exception {

		if (item.getTax() != null) {
			SalesTaxBD delegate = this.getBusinessDelegate(SalesTaxBD.class);
			List<SalesInvoiceItemTax> itemTaxes = new ArrayList<SalesInvoiceItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (SalesInvoiceItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.em.merge(item);
			// this.getEntityManager().flush();
			this.em.createQuery(
					"delete from " + SalesInvoiceItemTax.class.getSimpleName()
							+ " e where e.salesInvoiceItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (SalesInvoiceItemTax itemTax : itemTaxes) {
				this.em.persist(itemTax);
			}
		}
	}

}
