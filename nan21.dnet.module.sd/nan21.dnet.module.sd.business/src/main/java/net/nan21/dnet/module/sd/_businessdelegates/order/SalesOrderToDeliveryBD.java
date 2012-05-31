package net.nan21.dnet.module.sd._businessdelegates.order;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd.order.business.service.ISalesInventoryTransactionService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderToDeliveryBD extends AbstractBusinessDelegate {

	public SalesInventoryTransaction generateDelivery(SalesOrder order,
			TxDocType deliveryDocType, InvTransactionType delivTxType,
			Date delivEventDate) throws Exception {

		List<SalesInventoryTransaction> deliveries = ((ISalesInventoryTransactionService) this
				.findEntityService(SalesInventoryTransaction.class))
				.findBySalesOrderId(order.getId());
		if (deliveries.size() > 0) {
			// String invCode = deliveries.get(0).getCode();
			throw new Exception(
					"Delivery note already createad for this sales order. ");
		}

		SalesInventoryTransaction deliv = new SalesInventoryTransaction();
		deliv.setCustomer(order.getCustomer());
		deliv.setSalesOrder(order);
		deliv.setDeliveryLocation(order.getShipToLocation());
		deliv.setDeliveryNotes(order.getDeliveryNotes());
		deliv.setDeliveryContact(order.getShipToContact());
		// deliv.setDocType(deliveryDocType);
		deliv.setTransactionType(delivTxType);

		deliv.setFromInventory(order.getInventory());
		deliv.setToInventory(order.getCarrier());
		deliv.setDocDate(delivEventDate);

		List<SalesOrderItem> items = ((ISalesOrderItemService) this
				.findEntityService(SalesOrderItem.class))
				.findBySalesOrderId(order.getId());
		for (SalesOrderItem orderItem : items) {
			InvTransactionLine line = new InvTransactionLine();
			line.setInvTransaction(deliv);
			line.setItem(orderItem.getProduct());
			line.setUom(orderItem.getUom());
			line.setQuantity(orderItem.getQuantity());
			deliv.addToLines(line);
		}

		ISalesInventoryTransactionService srv = (ISalesInventoryTransactionService) this
				.findEntityService(SalesInventoryTransaction.class);
		srv.insert(deliv);

		order.setDelivered(true);
		srv.getEntityManager().merge(order);

		return deliv;

	}
}
