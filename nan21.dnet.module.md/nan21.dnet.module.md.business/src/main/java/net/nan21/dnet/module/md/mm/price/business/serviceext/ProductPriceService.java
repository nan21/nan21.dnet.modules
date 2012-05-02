/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.business.serviceext;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.md.mm.price.business.service.IPriceListService;
import net.nan21.dnet.module.md.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
 

import org.springframework.util.Assert;

public class ProductPriceService
        extends
        net.nan21.dnet.module.md.mm.price.business.serviceimpl.ProductPriceService
        implements IProductPriceService {

	
	public ProductPrice getDefaultSalesProductPrice( Long productId, Date eventDate ) throws Exception {
		PriceList pl = ((IPriceListService) this.findEntityService(PriceList.class)).findDefaultPriceList(true); 		  
		return getProductPrice(productId, pl.getId(), eventDate);
	}
	public ProductPrice getDefaultPurchaseProductPrice( Long productId, Date eventDate ) throws Exception {
		PriceList pl = ((IPriceListService) this.findEntityService(PriceList.class)).findDefaultPriceList(false); 		  
		return getProductPrice(productId, pl.getId(), eventDate);
	}
	
	public ProductPrice getProductPrice (Long productId, Long priceListId, Date eventDate) throws Exception {
		
		Assert.notNull(productId, "No product specified to lookup the price for.");
		
		Date validAt = eventDate;
		if (validAt == null) {
			validAt = new Date();
		}
		String eql = "select pp from " +
			""+ProductPrice.class.getSimpleName() + " pp join fetch pp.priceListVersion  " +
			//""+PriceListVersion.class.getSimpleName()+" v on pp.priceListVersion.id = v.id  " +
			" where pp.clientId = :pClientId " +
			" and pp.product.id = :pProductId " +
			" and pp.priceListVersion.priceList.id = :pPriceListId " +
			" and pp.priceListVersion.validFrom <= :pValidAt " +
			" order by pp.priceListVersion.validFrom desc ";
		
		List<ProductPrice> results = (List<ProductPrice>)this.em
        .createQuery(eql, ProductPrice.class)
        .setParameter("pClientId", Session.user.get().getClientId())
        .setParameter("pProductId", productId)
        .setParameter("pPriceListId", priceListId)
        .setParameter("pValidAt", validAt)
        .getResultList();
		
		if (results.size() == 0) {
			throw new Exception("No price defined for this product! ");
		} else 
		return results.get(0);
	}
	
	
	
}
