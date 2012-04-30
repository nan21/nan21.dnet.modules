package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionService;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs;

public class SalesDeliveryPD extends AbstractDsDelegate {

	public void confirm(SalesDeliveryDs ds) throws Exception {
		IInvTransactionService service = ((IInvTransactionService) this
				.findEntityService(InvTransaction.class));
		service.doConfirm(ds.getId());		
		ds.setConfirmed(true);		 
	}

	public void unConfirm(SalesDeliveryDs ds) throws Exception {
		IInvTransactionService service = ((IInvTransactionService) this
				.findEntityService(InvTransaction.class));
		service.doUnConfirm(ds.getId());		
		ds.setConfirmed(false);
	}
	
	public void post(SalesDeliveryDs ds) throws Exception {
		 
	}

	public void unPost(SalesDeliveryDs ds) throws Exception {

	}
}
