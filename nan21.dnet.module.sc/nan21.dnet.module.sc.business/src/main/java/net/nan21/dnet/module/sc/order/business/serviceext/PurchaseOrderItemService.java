/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.sc._businessdelegates.order.PurchaseTaxBD;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderItemService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

public class PurchaseOrderItemService
		extends
		net.nan21.dnet.module.sc.order.business.serviceimpl.PurchaseOrderItemService
		implements IPurchaseOrderItemService {

	private List<Long> orderIds;

	@Override
	protected void postUpdate(PurchaseOrderItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(PurchaseOrderItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<PurchaseOrderItem> list) {
		orderIds = new ArrayList<Long>();
		for (PurchaseOrderItem item : list) {
			if (!orderIds.contains(item.getPurchaseOrder().getId())) {
				this.updateAmount(item.getPurchaseOrder().getId());
				orderIds.add(item.getPurchaseOrder().getId());
			}
		}
		orderIds = null;
	}

	@Override
	protected void postUpdate(List<PurchaseOrderItem> list) {
		orderIds = new ArrayList<Long>();
		for (PurchaseOrderItem item : list) {
			if (!orderIds.contains(item.getPurchaseOrder())) {
				this.updateAmount(item.getPurchaseOrder().getId());
				orderIds.add(item.getPurchaseOrder().getId());
			}
		}
		orderIds = null;
	}

	@Override
	protected void preDeleteByIds(List<Object> ids) throws Exception {
		this.orderIds = new ArrayList<Long>();
		List<PurchaseOrderItem> items = this.findByIds(ids);
		for (PurchaseOrderItem item : items) {
			this.orderIds.add(item.getPurchaseOrder().getId());
		}
	}

	@Override
	protected void postDeleteByIds(List<Object> ids) {
		for (Long orderId : this.orderIds) {
			this.updateAmount(orderId);
		}
		orderIds = null;
	}

	@Override
	protected void preDeleteById(Object id) {
		orderIds = new ArrayList<Long>();
		orderIds.add(this.em.getReference(PurchaseOrderItem.class, id)
				.getPurchaseOrder().getId());
	}

	@Override
	protected void postDeleteById(Object id) {
		this.updateAmount(orderIds.get(0));
		orderIds = null;
	}

	private void updateAmount(Long orderId) {
		this.em.flush();
		Object[] x = (Object[]) this.em
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from PurchaseOrderItem i where i.purchaseOrder.id = :orderId")
				.setParameter("orderId", orderId).getSingleResult();

		PurchaseOrder order = this.em.find(PurchaseOrder.class, orderId);

		Double totalNet = (Double) x[0];
		Double totalTax = (Double) x[1];
		if (totalNet == null) {
			totalNet = 0D;
		}
		if (totalTax == null) {
			totalTax = 0D;
		}
		order.setTotalNetAmount(totalNet.floatValue());
		order.setTotalTaxAmount(totalTax.floatValue());

		this.em.merge(order);
	}

	protected void calculateTaxes(PurchaseOrderItem item) throws Exception {

		if (item.getTax() != null) {
			PurchaseTaxBD delegate = this
					.getBusinessDelegate(PurchaseTaxBD.class);
			List<PurchaseOrderItemTax> itemTaxes = new ArrayList<PurchaseOrderItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (PurchaseOrderItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.em.merge(item);
			// this.getEntityManager().flush();
			this.em.createQuery(
					"delete from " + PurchaseOrderItemTax.class.getSimpleName()
							+ " e where e.purchaseOrderItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (PurchaseOrderItemTax itemTax : itemTaxes) {
				this.em.persist(itemTax);
			}
		}
	}

}
