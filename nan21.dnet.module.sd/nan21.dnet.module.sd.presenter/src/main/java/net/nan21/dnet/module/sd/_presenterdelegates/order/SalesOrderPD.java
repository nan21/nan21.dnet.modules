package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;

public class SalesOrderPD extends AbstractDsDelegate {

	public void confirmOrder(SalesOrderDs ds) throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder entity = service.findById(ds.getId());
		entity.setConfirmed(true);
		service.update(entity);
		ds.setConfirmed(true);
	}

	public void unConfirmOrder(SalesOrderDs ds) throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder entity = service.findById(ds.getId());
		entity.setConfirmed(false);
		service.update(entity);
		ds.setConfirmed(false);
	}

	public void generateInvoice(SalesOrderDs ds) throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder entity = service.findById(ds.getId());
		service.doGenerateInvoice(entity);
		ds.setInvoiced(true);
	}

	public void generateDelivery(SalesOrderDs ds) throws Exception {
		throw new Exception("This feature is not implemented yet. ");
	}

}
