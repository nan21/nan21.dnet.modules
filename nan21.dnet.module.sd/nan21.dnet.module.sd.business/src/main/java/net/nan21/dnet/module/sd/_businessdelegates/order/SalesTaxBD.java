package net.nan21.dnet.module.sd._businessdelegates.order;

import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public class SalesTaxBD extends AbstractBusinessDelegate {

	public void createSalesItemTax(SalesOrderItem item, Tax taxDefinition,
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
				this.createSalesItemTax(item, childtdef, itemTaxes);
			}
		} else {
			SalesOrderItemTax tax = new SalesOrderItemTax();
			tax.setBaseAmount(item.getNetUnitPrice() * item.getQtyOrdered());
			tax.setTax(tdef);
			tax.setTaxAmount(item.getNetUnitPrice() * item.getQtyOrdered()
					* tdef.getRate());
			tax.setSalesOrderItem(item);

			itemTaxes.add(tax);
		}
	}

	public void createSalesItemTax(SalesOrderItem item, Tax taxDefinition) {

	}

}
