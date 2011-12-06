/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListType;

import net.nan21.dnet.module.mm.price.domain.entity.ProductPrice;

public interface IProductPriceService extends IEntityService<ProductPrice> {

    public ProductPrice findByName(Long clientId, PriceListType priceList,
            Product product);

    public ProductPrice findByName(Long clientId, Long priceListId,
            Long productId);

    public List<ProductPrice> findByPriceList(PriceListType priceList);

    public List<ProductPrice> findByPriceListId(Long priceListId);

    public List<ProductPrice> findByProduct(Product product);

    public List<ProductPrice> findByProductId(Long productId);

}
