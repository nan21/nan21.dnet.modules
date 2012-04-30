package net.nan21.dnet.module.sc._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDs;

public class PurchaseOrderItemPD extends AbstractDsDelegate {

	public void onProductChange(PurchaseOrderItemDs ds) throws Exception {
		IPurchaseOrderService soSrv = (IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class);
		PurchaseOrder so = soSrv.findById(ds.getPurchaseOrderId());

		IProductPriceService srv = (IProductPriceService) this
				.findEntityService(ProductPrice.class);
		ProductPrice pr = srv.getProductPrice(ds.getProductId(), so
				.getPriceList().getId(), so.getDocDate());

		ds.setUnitPrice(pr.getPrice());
		ds.setUomId(pr.getUom().getId());
		ds.setUomCode(pr.getUom().getCode());

		// reset other
		ds.setNetAmount(1F * pr.getPrice());
		ds.setTaxAmount(0F);
		ds.setQuantity(1F);
	}
}
