package net.nan21.dnet.module.mm._presenterdelegates.inventory;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs;

public class InvTransactionPD extends BaseDsDelegate<InvTransactionDs, EmptyParam>{

	public void postTransaction(InvTransactionDs ds) throws Exception {
		((IInvTransactionService)this.findEntityService(InvTransaction.class))
		.doPostTransaction(ds.getId());
	}
} 
