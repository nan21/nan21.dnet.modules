/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.module.bd.fin.business.service.ITaxService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesTaxBD;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemTaxService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public class SalesOrderItemService
		extends
		net.nan21.dnet.module.sd.order.business.serviceimpl.SalesOrderItemService
		implements ISalesOrderItemService {

	private List<Long> orderIds;

	// private ISalesOrderItemTaxService itemTaxService;

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
		 
		Double totalNet = (Double)x[0];
		Double totalTax = (Double)x[1];
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

	protected void calculateTaxes(SalesOrderItem item) throws Exception {

		if (item.getTax() != null) {
			SalesTaxBD delegate = this.getBusinessDelegate(SalesTaxBD.class);
			List<SalesOrderItemTax> itemTaxes = new ArrayList<SalesOrderItemTax>();

			delegate.createSalesItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (SalesOrderItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.getEntityManager().merge(item);
			this.em.createQuery(
					"delete from " + SalesOrderItemTax.class.getSimpleName()
							+ " e where e.salesOrderItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (SalesOrderItemTax itemTax : itemTaxes) {
				this.getEntityManager().persist(itemTax);
			}
		}
	}

	// protected ISalesOrderItemTaxService getItemTaxService() throws Exception
	// {
	// if (this.itemTaxService == null) {
	// this.itemTaxService =
	// (ISalesOrderItemTaxService)this.findEntityService(SalesOrderItemTax.class);
	// }
	// return this.itemTaxService;
	// }

}
