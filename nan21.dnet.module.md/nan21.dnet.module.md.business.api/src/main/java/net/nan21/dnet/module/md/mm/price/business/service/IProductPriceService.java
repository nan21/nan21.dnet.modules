/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import java.util.Date;

public interface IProductPriceService extends IEntityService<ProductPrice> {

    public ProductPrice findByName(PriceListVersion priceListVersion,
            Product product);

    public ProductPrice findByName(Long priceListVersionId, Long productId);

    public List<ProductPrice> findByPriceListVersion(
            PriceListVersion priceListVersion);

    public List<ProductPrice> findByPriceListVersionId(Long priceListVersionId);

    public List<ProductPrice> findByProduct(Product product);

    public List<ProductPrice> findByProductId(Long productId);

    public List<ProductPrice> findByUom(Uom uom);

    public List<ProductPrice> findByUomId(Long uomId);

    public ProductPrice getDefaultSalesProductPrice(Long productId,
            Date eventDate) throws Exception;

    public ProductPrice getDefaultPurchaseProductPrice(Long productId,
            Date eventDate) throws Exception;

    public ProductPrice getProductPrice(Long productId, Long priceListId,
            Date eventDate) throws Exception;

}
