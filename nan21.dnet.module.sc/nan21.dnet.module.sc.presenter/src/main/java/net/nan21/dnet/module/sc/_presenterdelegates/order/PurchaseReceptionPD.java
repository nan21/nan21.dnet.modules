package net.nan21.dnet.module.sc._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionService;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDs;

public class PurchaseReceptionPD extends AbstractDsDelegate {

	public void confirm(PurchaseReceptionDs ds) throws Exception {
		IInvTransactionService service = ((IInvTransactionService) this
				.findEntityService(InvTransaction.class));
		service.doConfirm(ds.getId());
		ds.setConfirmed(true);
	}

	public void unConfirm(PurchaseReceptionDs ds) throws Exception {
		IInvTransactionService service = ((IInvTransactionService) this
				.findEntityService(InvTransaction.class));
		service.doUnConfirm(ds.getId());
		ds.setConfirmed(false);
	}

	public void post(PurchaseReceptionDs ds) throws Exception {

	}

	public void unPost(PurchaseReceptionDs ds) throws Exception {

	}

}
