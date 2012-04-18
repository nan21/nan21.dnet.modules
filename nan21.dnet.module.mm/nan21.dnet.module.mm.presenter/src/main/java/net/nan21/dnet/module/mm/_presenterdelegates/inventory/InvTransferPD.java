package net.nan21.dnet.module.mm._presenterdelegates.inventory;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransferDs;

public class InvTransferPD extends AbstractDsDelegate {

	public void confirm(InvTransferDs ds) throws Exception {
		IInvTransactionService service = ((IInvTransactionService) this
				.findEntityService(InvTransaction.class));
		service.doConfirm(ds.getId());
		ds.setConfirmed(true);
	}

	public void unConfirm(InvTransferDs ds) throws Exception {
		IInvTransactionService service = ((IInvTransactionService) this
				.findEntityService(InvTransaction.class));
		service.doUnConfirm(ds.getId());
		ds.setConfirmed(false);
	}

	public void post(InvTransferDs ds) throws Exception {

	}

	public void unPost(InvTransferDs ds) throws Exception {

	}

}
