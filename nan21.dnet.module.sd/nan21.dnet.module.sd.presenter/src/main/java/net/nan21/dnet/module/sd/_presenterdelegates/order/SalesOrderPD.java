package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;

public class SalesOrderPD extends AbstractDsDelegate {

	
	public void confirmOrder(SalesOrderDs ds) throws Exception {
		ISalesOrderService soService = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder order = soService.findById(ds.getId());
		order.setConfirmed(true);
		soService.update(order);
		ds.setConfirmed(true);
	}
	
	public void unConfirmOrder(SalesOrderDs ds) throws Exception {
		ISalesOrderService soService = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder order = soService.findById(ds.getId());
		order.setConfirmed(false);
		soService.update(order);
		ds.setConfirmed(false);
	}
	
	public void generateInvoice(SalesOrderDs ds) throws Exception {
		ISalesOrderService soService = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder order = soService.findById(ds.getId());
		soService.doGenerateInvoice(order);

	}
	public void generateDelivery(SalesOrderDs ds) throws Exception {
		throw new Exception("This feature is not implemented yet. ");
	}
	
	
	
	
	
	
	
	
	
	
}
