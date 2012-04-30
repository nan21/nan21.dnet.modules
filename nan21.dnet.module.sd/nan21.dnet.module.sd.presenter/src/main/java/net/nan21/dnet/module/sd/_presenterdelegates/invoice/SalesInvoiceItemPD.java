package net.nan21.dnet.module.sd._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs;

public class SalesInvoiceItemPD extends AbstractDsDelegate  {
	
	public void onProductChange(SalesInvoiceItemDs ds) throws Exception {
		ISalesInvoiceService siSrv = (ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class);
		SalesInvoice si = siSrv.findById(ds.getSalesInvoiceId());
		
		IProductPriceService srv = (IProductPriceService) this
				.findEntityService(ProductPrice.class);
		ProductPrice pr = srv.getProductPrice(ds.getProductId(), si.getPriceList().getId(), si.getDocDate());
		
		ds.setUnitPrice(pr.getPrice());
		ds.setUomId(pr.getUom().getId());
		ds.setUomCode(pr.getUom().getCode());
		
		// reset other 
		ds.setNetAmount(1F * pr.getPrice() );
		ds.setTaxAmount(0F);
		ds.setQuantity(1F);
	}
}
