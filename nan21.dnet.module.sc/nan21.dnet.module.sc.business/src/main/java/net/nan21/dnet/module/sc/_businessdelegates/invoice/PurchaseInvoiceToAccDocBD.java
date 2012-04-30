package net.nan21.dnet.module.sc._businessdelegates.invoice;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

public class PurchaseInvoiceToAccDocBD extends AbstractBusinessDelegate {
	public AccDoc generateAccDoc(PurchaseInvoice invoice) throws Exception {
		return null;
	}
}