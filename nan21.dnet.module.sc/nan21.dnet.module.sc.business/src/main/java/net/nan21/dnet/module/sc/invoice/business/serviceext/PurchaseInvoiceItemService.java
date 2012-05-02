/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sc._businessdelegates.order.PurchaseTaxBD;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceItemService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

public class PurchaseInvoiceItemService
		extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PurchaseInvoiceItemService
		implements IPurchaseInvoiceItemService {

	private List<Long> invoiceIds;

	@Override
	protected void postUpdate(PurchaseInvoiceItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(PurchaseInvoiceItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<PurchaseInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (PurchaseInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getPurchaseInvoice().getId())) {
				this.updateAmount(item.getPurchaseInvoice().getId());
				invoiceIds.add(item.getPurchaseInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void postUpdate(List<PurchaseInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (PurchaseInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getPurchaseInvoice())) {
				this.updateAmount(item.getPurchaseInvoice().getId());
				invoiceIds.add(item.getPurchaseInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void preDeleteByIds(List<Object> ids) throws Exception {
		this.invoiceIds = new ArrayList<Long>();
		List<PurchaseInvoiceItem> items = this.findByIds(ids);
		for (PurchaseInvoiceItem item : items) {
			this.invoiceIds.add(item.getPurchaseInvoice().getId());
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
		invoiceIds.add(this.em.getReference(PurchaseInvoiceItem.class, id)
				.getPurchaseInvoice().getId());
	}

	@Override
	protected void postDeleteById(Object id) {
		this.updateAmount(invoiceIds.get(0));
		invoiceIds = null;
	}

	private void updateAmount(Long invoiceId) {
		this.em.flush();
		Object[] x = (Object[]) this.em.createQuery(
				"select sum(i.netAmount), sum(i.taxAmount) from PurchaseInvoiceItem i "
						+ "where i.purchaseInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).getSingleResult();
		PurchaseInvoice invoice = this.em
				.find(PurchaseInvoice.class, invoiceId);

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
				"delete from PurchaseInvoiceTax t "
						+ " where t.purchaseInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).executeUpdate();

		// create new

		List<Object[]> taxes = (List<Object[]>) this.em
				.createQuery(
						"select i.tax,  sum(i.baseAmount), sum(i.taxAmount) from PurchaseInvoiceItemTax i "
								+ " where i.purchaseInvoiceItem.purchaseInvoice.id = :invoiceId "
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

			PurchaseInvoiceTax invTax = new PurchaseInvoiceTax();
			invTax.setPurchaseInvoice(invoice);
			invTax.setTax(t);
			invTax.setBaseAmount(baseval.floatValue());
			invTax.setTaxAmount(taxval.floatValue());
			invoice.addToTaxes(invTax);
		}

		this.em.merge(invoice);
	}

	protected void calculateTaxes(PurchaseInvoiceItem item) throws Exception {

		if (item.getTax() != null) {
			PurchaseTaxBD delegate = this
					.getBusinessDelegate(PurchaseTaxBD.class);
			List<PurchaseInvoiceItemTax> itemTaxes = new ArrayList<PurchaseInvoiceItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (PurchaseInvoiceItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.em.merge(item);
			// this.getEntityManager().flush();
			this.em.createQuery(
					"delete from "
							+ PurchaseInvoiceItemTax.class.getSimpleName()
							+ " e where e.purchaseInvoiceItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (PurchaseInvoiceItemTax itemTax : itemTaxes) {
				this.em.persist(itemTax);
			}
		}
	}

}
