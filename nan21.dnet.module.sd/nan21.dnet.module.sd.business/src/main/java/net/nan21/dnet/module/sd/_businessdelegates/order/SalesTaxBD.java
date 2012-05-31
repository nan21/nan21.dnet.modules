package net.nan21.dnet.module.sd._businessdelegates.order;

import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public class SalesTaxBD extends AbstractBusinessDelegate {

	public void createItemTax(SalesOrderItem item, Tax taxDefinition,
			List<SalesOrderItemTax> itemTaxes) {
		Tax tdef = null;
		if (taxDefinition == null) {
			tdef = item.getTax();
		} else {
			tdef = taxDefinition;
		}

		if (tdef.getSummary()) {
			Collection<Tax> childtdefs = tdef.getChildren();
			for (Tax childtdef : childtdefs) {
				this.createItemTax(item, childtdef, itemTaxes);
			}
		} else {
			SalesOrderItemTax tax = new SalesOrderItemTax();
			tax.setBaseAmount(item.getUnitPrice() * item.getQuantity());
			tax.setTax(tdef);
			tax.setTaxAmount(item.getUnitPrice() * item.getQuantity()
					* tdef.getRate());
			tax.setSalesOrderItem(item);

			itemTaxes.add(tax);
		}
	}

	public void createItemTax(SalesInvoiceItem item, Tax taxDefinition,
			List<SalesInvoiceItemTax> itemTaxes) {
		Tax tdef = null;
		if (taxDefinition == null) {
			tdef = item.getTax();
		} else {
			tdef = taxDefinition;
		}

		if (tdef.getSummary()) {
			Collection<Tax> childtdefs = tdef.getChildren();
			for (Tax childtdef : childtdefs) {
				this.createItemTax(item, childtdef, itemTaxes);
			}
		} else {
			SalesInvoiceItemTax tax = new SalesInvoiceItemTax();
			tax.setBaseAmount(item.getUnitPrice() * item.getQuantity());
			tax.setTax(tdef);
			tax.setTaxAmount(item.getUnitPrice() * item.getQuantity()
					* tdef.getRate());
			tax.setSalesInvoiceItem(item);

			itemTaxes.add(tax);
		}
	}

}
