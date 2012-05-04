package net.nan21.dnet.module.sd._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;
import net.nan21.dnet.module.sd.invoice.ds.model.PaymentInDs;

public class PaymentInPD extends AbstractDsDelegate {

	public void confirm(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		e.setConfirmed(true);
		srv.update(e);
	}

	public void unConfirm(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		e.setConfirmed(false);
		srv.update(e);
	}

	public void post(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	public void unPost(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}
}
