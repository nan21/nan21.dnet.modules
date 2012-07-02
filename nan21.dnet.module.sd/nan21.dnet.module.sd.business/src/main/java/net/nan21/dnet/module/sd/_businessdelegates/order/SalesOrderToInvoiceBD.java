package net.nan21.dnet.module.sd._businessdelegates.order;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

public class SalesOrderToInvoiceBD extends AbstractBusinessDelegate {

	public SalesInvoice generateInvoice(SalesOrder order, TxDocType invDocType)
			throws Exception {

		List<SalesInvoice> invs = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class))
				.findBySalesOrderId(order.getId());
		if (invs.size() > 0) {
			String invCode = invs.get(0).getCode();
			throw new Exception(
					"Sales order is already invoiced ! Check invoice "
							+ invCode);
		}

		SalesInvoice invoice = new SalesInvoice();

		if (order.getBillTo() != null) {
			invoice.setCustomer(order.getBillTo());
		} else {
			invoice.setCustomer(order.getCustomer());
		}

		invoice.setCurrency(order.getCurrency());
		invoice.setPriceList(order.getPriceList());
		invoice.setDocType(invDocType);
		invoice.setDocDate(new Date());
		invoice.setBillToLocation(order.getBillToLocation());
		invoice.setBillToContact(order.getBillToContact());
		invoice.setSalesOrder(order);
		invoice.setSupplier(order.getSupplier());
		invoice.setTotalAmount(order.getTotalAmount());
		invoice.setTotalNetAmount(order.getTotalNetAmount());
		invoice.setTotalTaxAmount(order.getTotalTaxAmount());

		invoice.setPaymentMethod(order.getPaymentMethod());
		invoice.setPaymentTerm(order.getPaymentTerm());

		for(SalesOrderTax ordTax : order.getTaxes()) {
			SalesInvoiceTax invTax = new SalesInvoiceTax();
			invTax.setSalesInvoice(invoice);
			invTax.setBaseAmount(ordTax.getBaseAmount());
			invTax.setTax(ordTax.getTax());
			invTax.setTaxAmount(ordTax.getTaxAmount());
			invoice.addToTaxes(invTax);
		}
		
		List<SalesOrderItem> items = ((ISalesOrderItemService) this
				.findEntityService(SalesOrderItem.class))
				.findBySalesOrderId(order.getId());
		for (SalesOrderItem orderItem : items) {
			SalesInvoiceItem invItem = new SalesInvoiceItem();

			invItem.setSalesInvoice(invoice);
			invItem.setProduct(orderItem.getProduct());
			invItem.setQuantity(orderItem.getQuantity());
			invItem.setUnitPrice(orderItem.getUnitPrice());
			invItem.setNetAmount(orderItem.getNetAmount());
			invItem.setTaxAmount(orderItem.getTaxAmount());
			invItem.setTax(orderItem.getTax());
			invItem.setUom(orderItem.getUom());

			invoice.addToLines(invItem);
			for (SalesOrderItemTax soTax : orderItem.getItemTaxes()) {
				SalesInvoiceItemTax siTax = new SalesInvoiceItemTax();
				siTax.setBaseAmount(soTax.getBaseAmount());
				siTax.setTax(soTax.getTax());
				siTax.setTaxAmount(soTax.getTaxAmount());
				siTax.setSalesInvoiceItem(invItem);
				invItem.addToItemTaxes(siTax);
			}
		}

		ISalesInvoiceService srv = (ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class);
		srv.insert(invoice);

		order.setInvoiced(true);
		srv.getEntityManager().merge(order);
		return invoice;

	}
}
