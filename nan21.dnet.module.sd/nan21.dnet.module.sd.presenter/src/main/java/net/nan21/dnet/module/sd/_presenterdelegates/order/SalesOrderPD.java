package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam;

public class SalesOrderPD extends AbstractDsDelegate {

	public void confirm(SalesOrderDs ds) throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder e = service.findById(ds.getId());
		e.setConfirmed(true);
		service.update(e);
	}

	public void unConfirm(SalesOrderDs ds) throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder e = service.findById(ds.getId());
		e.setConfirmed(false);
		service.update(e);
	}

	public void generateInvoice(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		TxDocType docType = service.getEntityManager().find(TxDocType.class,
				params.getInvDocTypeId());
		SalesOrder e = service.findById(ds.getId());
		service.doGenerateInvoice(e, docType);
	}

	public void generateDelivery(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		TxDocType docType = service.getEntityManager().find(TxDocType.class,
				params.getDelivDocTypeId());
		InvTransactionType txType = service.getEntityManager().find(
				InvTransactionType.class, params.getDelivTxTypeId());

		SalesOrder e = service.findById(ds.getId());
		service.doGenerateDelivery(e, docType, txType, params
				.getDelivEventData());
	}

}
