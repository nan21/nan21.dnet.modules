package net.nan21.dnet.module.sc._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs;

public class PurchaseOrderPD extends AbstractDsDelegate {
	
	 
	public void confirmOrder(PurchaseOrderDs ds) throws Exception {
		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder entity = srv.findById(ds.getId());
		entity.setConfirmed(true);
		srv.update(entity);
		ds.setConfirmed(true);
	}

	public void unConfirmOrder(PurchaseOrderDs ds) throws Exception {
		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder entity = srv.findById(ds.getId());
		entity.setConfirmed(false);
		srv.update(entity);
		ds.setConfirmed(false);
	}
}
