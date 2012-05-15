package net.nan21.dnet.module.sc._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs;

public class PurchaseOrderPD extends AbstractDsDelegate {

	public void confirm(PurchaseOrderDs ds) throws Exception {
		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder e = srv.findById(ds.getId());
		e.setConfirmed(true);
		srv.update(e);
	}

	public void unConfirm(PurchaseOrderDs ds) throws Exception {
		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder e = srv.findById(ds.getId());
		e.setConfirmed(false);
		srv.update(e);
	}
}