package net.nan21.dnet.module.sc._businessdelegates.order;

import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

public class PurchaseTaxBD extends AbstractBusinessDelegate {

	public void createItemTax(PurchaseOrderItem item, Tax taxDefinition,
			List<PurchaseOrderItemTax> itemTaxes) {
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
			PurchaseOrderItemTax tax = new PurchaseOrderItemTax();
			tax.setBaseAmount(item.getUnitPrice() * item.getQuantity());
			tax.setTax(tdef);
			tax.setTaxAmount(item.getUnitPrice() * item.getQuantity()
					* tdef.getRate());
			tax.setPurchaseOrderItem(item);

			itemTaxes.add(tax);
		}
	}

	public void createItemTax(PurchaseInvoiceItem item, Tax taxDefinition,
			List<PurchaseInvoiceItemTax> itemTaxes) {
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
			PurchaseInvoiceItemTax tax = new PurchaseInvoiceItemTax();
			tax.setBaseAmount(item.getNetAmount());
			tax.setTax(tdef);
			tax.setTaxAmount(tax.getBaseAmount() * tdef.getRate());
			tax.setPurchaseInvoiceItem(item);

			itemTaxes.add(tax);
		}
	}

}
