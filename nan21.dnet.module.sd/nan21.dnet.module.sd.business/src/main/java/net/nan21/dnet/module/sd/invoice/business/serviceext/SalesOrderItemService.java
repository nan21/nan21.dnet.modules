package net.nan21.dnet.module.sd.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderItemService
		extends
		net.nan21.dnet.module.sd.order.business.serviceimpl.SalesOrderItemService 
		implements ISalesOrderItemService {

	private List<Long> orderIds;

	@Override
	protected void postInsert(List<SalesOrderItem> list) {
		orderIds = new ArrayList<Long>();
		for (SalesOrderItem item : list) {
			if (!orderIds.contains(item.getSalesOrder().getId())) {
				this.updateAmount(item.getSalesOrder().getId());
				orderIds.add(item.getSalesOrder().getId());
			}
		}
		orderIds = null;
	}

	@Override
	protected void postUpdate(List<SalesOrderItem> list) {
		orderIds = new ArrayList<Long>();
		for (SalesOrderItem item : list) {
			if (!orderIds.contains(item.getSalesOrder())) {
				this.updateAmount(item.getSalesOrder().getId());
				orderIds.add(item.getSalesOrder().getId());
			}
		}
		orderIds = null;
	}

	@Override
	protected void preDeleteByIds(List<Object> ids) throws Exception {
		this.orderIds = new ArrayList<Long>();
		List<SalesOrderItem> items = this.findByIds(ids);
		for (SalesOrderItem item : items) {
			this.orderIds.add(item.getSalesOrder().getId());
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
		orderIds.add(this.em.getReference(SalesOrderItem.class, id).getSalesOrder().getId());
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
						"select sum(i.netAmount) from SalesOrderItem i where i.salesOrder.id = :orderId")
				.setParameter("orderId", orderId).getSingleResult();
		SalesOrder order = this.em.find(SalesOrder.class, orderId);
		order.setTotalNetAmount(x.floatValue());
		this.em.merge(order);
	}

}
