package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam;

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

	public void generateInvoice(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		TxDocType docType = service.getEntityManager().find(TxDocType.class,
				params.getInvDocTypeId());
		SalesOrder entity = service.findById(ds.getId());
		service.doGenerateInvoice(entity, docType);
		ds.setInvoiced(true);
	}

	public void generateDelivery(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		TxDocType docType = service.getEntityManager().find(TxDocType.class,
				params.getDelivDocTypeId());
		InvTransactionType txType = service.getEntityManager().find(
				InvTransactionType.class, params.getDelivTxTypeId());

		SalesOrder entity = service.findById(ds.getId());
		service.doGenerateDelivery(entity, docType, txType, params
				.getDelivEventData());
		ds.setDelivered(true);
	}

}
