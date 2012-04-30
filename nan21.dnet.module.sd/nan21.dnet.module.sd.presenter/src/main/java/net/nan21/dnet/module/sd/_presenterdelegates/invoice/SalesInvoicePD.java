package net.nan21.dnet.module.sd._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs;

public class SalesInvoicePD extends AbstractDsDelegate {

	public void confirmInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice invoice = srv.findById(ds.getId());
		invoice.setConfirmed(true);
		srv.update(invoice);
		ds.setConfirmed(true);
	}

	public void unConfirmInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice invoice = srv.findById(ds.getId());
		invoice.setConfirmed(false);
		srv.update(invoice);
		ds.setConfirmed(false);
	}

	public void postInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice invoice = srv.findById(ds.getId());
		srv.doPost(invoice);
		ds.setPosted(true);
	}

	public void unPostInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice invoice = srv.findById(ds.getId());
		invoice.setPosted(false);
		srv.update(invoice);
		ds.setPosted(false);
	}

}
