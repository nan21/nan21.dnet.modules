package net.nan21.dnet.module.mm._presenterdelegates.inventory;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs;

public class InvTransactionPD extends AbstractDsDelegate {

	public void postTransaction(InvTransactionDs ds) throws Exception {
		((IInvTransactionService)this.findEntityService(InvTransaction.class))
		.doPostTransaction(ds.getId());
	}
} 
