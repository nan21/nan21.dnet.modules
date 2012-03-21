/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderItemService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;


public class PurchaseOrderItemService
        extends
        net.nan21.dnet.module.sc.order.business.serviceimpl.PurchaseOrderItemService
        implements IPurchaseOrderItemService {


	private List<Long> orderIds;

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
		orderIds.add(this.em.getReference(PurchaseOrderItem.class, id).getPurchaseOrder().getId());
	}
	
	@Override
	protected void postDeleteById(Object id) {
		this.updateAmount(orderIds.get(0));
		orderIds = null;
	}

	private void updateAmount(Long orderId) {
		this.em.flush();
		Double x = (Double) this.em
				.createQuery(
						"select sum(i.netAmount) from PurchaseOrderItem i where i.purchaseOrder.id = :orderId")
				.setParameter("orderId", orderId).getSingleResult();
		if (x==null) {
			x = 0D;
		}
		PurchaseOrder order = this.em.find(PurchaseOrder.class, orderId);
		order.setTotalNetAmount(x.floatValue());
		this.em.merge(order);
	}
	
}
