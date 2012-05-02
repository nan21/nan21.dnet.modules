package net.nan21.dnet.module.md._presenterdelegates.mm.price;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.mm.price.business.service.IProductPriceService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDs;
import net.nan21.dnet.module.md.mm.price.ds.param.PriceListVersionDsParam;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
 

public class PriceListVersionPD extends AbstractDsDelegate {

	
	public void addProductsFromCategory(PriceListVersionDs ds, PriceListVersionDsParam params) throws Exception {
		if (params.getProductCategoryId() == null ) {
			throw new Exception("No product category given to copy products from!");
		}
		IProductService productService = (IProductService)this.findEntityService(Product.class);
		List<Product> products = productService.findByCategoriesId(params.getProductCategoryId() );
		
		PriceListVersion priceListVersion = productService.getEntityManager().find(PriceListVersion.class, ds.getId());
		List<ProductPrice> result = new ArrayList<ProductPrice>();
		
		for (Product product: products) {
			ProductPrice pp = new ProductPrice();
			pp.setProduct(product);
			pp.setPriceListVersion(priceListVersion);
			pp.setUom(product.getDefaultUom());
			pp.setPrice(0F);
			result.add(pp); 
		}
		
		IProductPriceService service = (IProductPriceService)this.findEntityService(ProductPrice.class);
		service.insert(result);
		 
	}
	
	
	public void addProductsFromPriceListVersion(PriceListVersionDs ds, PriceListVersionDsParam params) throws Exception {
		if (params.getCopyFromVersionId() == null ) {
			throw new Exception("No source pricelist version given to copy products from!");
		}
		
		IProductService productService = (IProductService)this.findEntityService(Product.class);
		List<Product> products = productService.getEntityManager().createQuery("select e from " + Product.class.getSimpleName() + " e " +
				" where e.id in (select pp.product.id from " +ProductPrice.class.getSimpleName()+ " pp where pp.priceListVersion.id = :sourcePLVersion) ", Product.class)
				.setParameter("sourcePLVersion", params.getCopyFromVersionId())
				.getResultList();
		PriceListVersion priceListVersion = productService.getEntityManager().find(PriceListVersion.class, ds.getId());
		List<ProductPrice> result = new ArrayList<ProductPrice>();
		
		for (Product product: products) {
			ProductPrice pp = new ProductPrice();
			pp.setProduct(product);
			pp.setPriceListVersion(priceListVersion);
			pp.setUom(product.getDefaultUom());
			pp.setPrice(0F);
			result.add(pp); 
		}
		
		IProductPriceService service = (IProductPriceService)this.findEntityService(ProductPrice.class);
		service.insert(result);
		 
	}
	
	
}
