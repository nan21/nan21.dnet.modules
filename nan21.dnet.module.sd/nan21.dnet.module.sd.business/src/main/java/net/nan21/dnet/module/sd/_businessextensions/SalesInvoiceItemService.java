/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd._businessextensions;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public class SalesInvoiceItemService
		extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.SalesInvoiceItemService {

	private List<Long> invoiceIds;

	@Override
	protected void postInsert(List<SalesInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (SalesInvoiceItem item : list) {
			if (!invoiceIds.contains(item.getInvoice().getId())) {
				this.updateAmount(item.getInvoice().getId());
				invoiceIds.add(item.getInvoice().getId());
			}
		}
		invoiceIds = null;
	}

	@Override
	protected void postUpdate(List<SalesInvoiceItem> list) {
		invoiceIds = new ArrayList<Long>();
		for (SalesInvoiceItem item : list) {
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
		List<SalesInvoiceItem> items = this.findByIds(ids);
		for (SalesInvoiceItem item : items) {
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
		invoiceIds.add(this.em.getReference(SalesInvoiceItem.class, id)
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
						"select sum(i.netAmount) from SalesInvoiceItem i where i.invoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).getSingleResult();
		SalesInvoice invoice = this.em.find(SalesInvoice.class, invoiceId);
		invoice.setTotalNetAmount(x.floatValue());
		this.em.merge(invoice);
	}

}
