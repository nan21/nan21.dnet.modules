package net.nan21.dnet.module.sd._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs;

public class SalesInvoicePD extends AbstractDsDelegate {

	public void confirmInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		e.setConfirmed(true);
		srv.update(e);
	}

	public void unConfirmInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		e.setConfirmed(false);
		srv.update(e);
	}

	public void postInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	public void unPostInvoice(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}

}
