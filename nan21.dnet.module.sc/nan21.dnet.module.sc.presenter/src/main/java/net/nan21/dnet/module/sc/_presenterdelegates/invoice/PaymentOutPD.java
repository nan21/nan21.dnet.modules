package net.nan21.dnet.module.sc._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDs;

public class PaymentOutPD extends AbstractDsDelegate {

	public void confirm(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		e.setConfirmed(true);
		srv.update(e);
	}

	public void unConfirm(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		e.setConfirmed(false);
		srv.update(e);
	}

	public void post(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	public void unPost(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}
}
