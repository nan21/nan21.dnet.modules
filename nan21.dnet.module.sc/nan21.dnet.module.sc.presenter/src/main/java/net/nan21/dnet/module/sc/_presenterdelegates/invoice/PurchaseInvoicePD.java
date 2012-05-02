package net.nan21.dnet.module.sc._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs;

 

public class PurchaseInvoicePD  extends AbstractDsDelegate  {
 
	public void confirmInvoice(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice invoice = srv.findById(ds.getId());
		invoice.setConfirmed(true);
		srv.update(invoice);
		ds.setConfirmed(true);
	}

	public void unConfirmInvoice(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice invoice = srv.findById(ds.getId());
		invoice.setConfirmed(false);
		srv.update(invoice);
		ds.setConfirmed(false);
	}

	public void postInvoice(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice invoice = srv.findById(ds.getId());
		srv.doPost(invoice);
		ds.setPosted(true);
	}

	public void unPostInvoice(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice invoice = srv.findById(ds.getId());
		srv.doUnPost(invoice);
		ds.setPosted(false);
	}

}
