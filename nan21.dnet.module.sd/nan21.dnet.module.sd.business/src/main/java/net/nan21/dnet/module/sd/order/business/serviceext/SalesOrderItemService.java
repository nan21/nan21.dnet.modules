/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesTaxBD;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

public class SalesOrderItemService
		extends
		net.nan21.dnet.module.sd.order.business.serviceimpl.SalesOrderItemService
		implements ISalesOrderItemService {

	private List<Long> orderIds;

	@Override
	protected void postUpdate(SalesOrderItem e) throws Exception {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(SalesOrderItem e) throws Exception {
		this.calculateTaxes(e);
	}

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
		orderIds.add(this.em.getReference(SalesOrderItem.class, id)
				.getSalesOrder().getId());
	}

	@Override
	protected void postDeleteById(Object id) {
		this.updateAmount(orderIds.get(0));
		orderIds = null;
	}

	protected void updateAmount(Long orderId) {
		this.em.flush();
		Object[] x = (Object[]) this.em
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from SalesOrderItem i where i.salesOrder.id = :orderId")
				.setParameter("orderId", orderId).getSingleResult();
		SalesOrder order = this.em.find(SalesOrder.class, orderId);

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

		// re-create taxes
		// delete existing
		this.em.createQuery(
				"delete from " + SalesOrderTax.class.getSimpleName() + " t "
						+ " where t.salesOrder.id = :orderId").setParameter(
				"orderId", orderId).executeUpdate();

		// create new

		List<Object[]> taxes = (List<Object[]>) this.em.createQuery(
				"select i.tax,  sum(i.baseAmount), sum(i.taxAmount) from "
						+ SalesOrderItemTax.class.getSimpleName() + " i "
						+ " where i.salesOrderItem.salesOrder.id = :orderId "
						+ " group by i.tax ").setParameter("orderId", orderId)
				.getResultList();
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

			SalesOrderTax ordTax = new SalesOrderTax();
			ordTax.setSalesOrder(order);
			ordTax.setTax(t);
			ordTax.setBaseAmount(baseval.floatValue());
			ordTax.setTaxAmount(taxval.floatValue());
			order.addToTaxes(ordTax);
		}

		this.em.merge(order);
	}

	protected void calculateTaxes(SalesOrderItem item) throws Exception {

		if (item.getTax() != null) {
			SalesTaxBD delegate = this.getBusinessDelegate(SalesTaxBD.class);
			List<SalesOrderItemTax> itemTaxes = new ArrayList<SalesOrderItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (SalesOrderItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.em.merge(item);
			this.em.createQuery(
					"delete from " + SalesOrderItemTax.class.getSimpleName()
							+ " e where e.salesOrderItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (SalesOrderItemTax itemTax : itemTaxes) {
				this.em.persist(itemTax);
			}
		}
	}

}
