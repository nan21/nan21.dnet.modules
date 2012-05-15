package net.nan21.dnet.module.sc._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs;

public class PurchaseInvoicePD extends AbstractDsDelegate {

	public void confirm(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		e.setConfirmed(true);
		srv.update(e);
	}

	public void unConfirm(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		e.setConfirmed(false);
		srv.update(e);
	}

	public void post(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	public void unPost(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}

}
