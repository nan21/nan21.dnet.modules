package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;

public class SalesOrderPD extends AbstractDsDelegate {

	public void generateInvoice(SalesOrderDs ds) throws Exception {
		ISalesOrderService soService = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder order = soService.findById(ds.getId());
		soService.doGenerateInvoice(order);

	}
}
