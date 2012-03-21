package net.nan21.dnet.module.sd._businessdelegates.order;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderToInvoiceBD extends AbstractBusinessDelegate {

	public SalesInvoice generateInvoice(SalesOrder order) throws Exception {

		SalesInvoice invoice = new SalesInvoice();

		if (order.getBillTo() != null) {
			invoice.setCustomer(order.getBillTo());
		} else {
			invoice.setCustomer(order.getCustomer());
		}
		
		invoice.setCurrency(order.getCurrency());
		invoice.setDocDate(new Date());
		invoice.setBillToLocation(order.getBillToLocation());
		// invoice.setBillToContact(order.getb)
		invoice.setSalesOrder(order);
		invoice.setSupplier(order.getSupplier());
		invoice.setTotalAmount(order.getTotalAmount());
		invoice.setTotalNetAmount(order.getTotalNetAmount());
		invoice.setTotalTaxAmount(order.getTotalTaxAmount());
		
		List<SalesOrderItem> items = ((ISalesOrderItemService) this
				.findEntityService(SalesOrderItem.class))
				.findBySalesOrderId(order.getId());
		for (SalesOrderItem orderItem : items) {
			SalesInvoiceItem invItem = new SalesInvoiceItem();

			invItem.setInvoice(invoice);
			invItem.setItem(orderItem.getProduct());
			invItem.setQuantity(orderItem.getQtyOrdered());
			invItem.setUnitPrice(orderItem.getNetUnitPrice());
			invItem.setNetAmount(orderItem.getNetAmount());
			invItem.setUom(orderItem.getUom());

			invoice.addToLines(invItem);
		}

		ISalesInvoiceService srv = (ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class);
		srv.insert(invoice);
		return invoice;

	}
}
