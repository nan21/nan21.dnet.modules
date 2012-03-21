/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceItemService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public class PurchaseInvoiceItemService
        extends
        net.nan21.dnet.module.sc.invoice.business.serviceimpl.PurchaseInvoiceItemService
        implements IPurchaseInvoiceItemService {

	private List<Long> invoiceIds;

	@Override
	protected void postInsert(List<PurchaseInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (PurchaseInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getInvoice().getId())) {
				this.updateAmount(item.getInvoice().getId());
				invoiceIds.add(item.getInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void postUpdate(List<PurchaseInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (PurchaseInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getInvoice())) {
				this.updateAmount(item.getInvoice().getId());
				invoiceIds.add(item.getInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void preDeleteByIds(List<Object> ids) throws Exception {
		this.invoiceIds = new ArrayList<Long>();
		List<PurchaseInvoiceItem> items = this.findByIds(ids);
		for (PurchaseInvoiceItem item : items) {
			this.invoiceIds.add(item.getInvoice().getId());
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
				.getInvoice().getId());
	}

	@Override
	protected void postDeleteById(Object id) {
		this.updateAmount(invoiceIds.get(0));
		invoiceIds = null;
	}

	private void updateAmount(Long invoiceId) {
		this.em.flush();
		Double x = (Double) this.em
				.createQuery(
						"select sum(i.netAmount) from PurchaseInvoiceItem i where i.invoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).getSingleResult();
		PurchaseInvoice invoice = this.em.find(PurchaseInvoice.class, invoiceId);
		if (x==null) {
			x = 0D;
		}
		invoice.setTotalNetAmount(x.floatValue());
		this.em.merge(invoice);
	}
	
}
