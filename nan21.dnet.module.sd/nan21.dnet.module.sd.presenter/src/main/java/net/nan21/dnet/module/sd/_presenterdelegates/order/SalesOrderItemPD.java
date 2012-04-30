package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDs;

public class SalesOrderItemPD extends AbstractDsDelegate {

	public void onProductChange(SalesOrderItemDs ds) throws Exception {
		ISalesOrderService soSrv = (ISalesOrderService) this
				.findEntityService(SalesOrder.class);
		SalesOrder so = soSrv.findById(ds.getSalesOrderId());
		
		IProductPriceService srv = (IProductPriceService) this
				.findEntityService(ProductPrice.class);
		ProductPrice pr = srv.getProductPrice(ds.getProductId(), so.getPriceList().getId(), so.getDocDate());
		
		ds.setUnitPrice(pr.getPrice());
		ds.setUomId(pr.getUom().getId());
		ds.setUomCode(pr.getUom().getCode());
		
		// reset other 
		ds.setNetAmount(1F *pr.getPrice() );
		ds.setTaxAmount(0F);
		ds.setQuantity(1F);
	}
}
