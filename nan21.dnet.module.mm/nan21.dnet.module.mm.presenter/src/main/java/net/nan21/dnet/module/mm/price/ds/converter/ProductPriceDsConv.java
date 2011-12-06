/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.price.ds.model.ProductPriceDs;
import net.nan21.dnet.module.mm.price.domain.entity.ProductPrice;

public class ProductPriceDsConv extends
        AbstractDsConverter<ProductPriceDs, ProductPrice> implements
        IDsConverter<ProductPriceDs, ProductPrice> {

    protected void modelToEntityReferences(ProductPriceDs ds, ProductPrice e)
            throws Exception {
        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }
        if (ds.getPriceListId() != null) {
            if (e.getPriceList() == null
                    || !e.getPriceList().getId().equals(ds.getPriceListId())) {
                e.setPriceList((PriceListType) this.em.find(
                        PriceListType.class, ds.getPriceListId()));
            }
        }
    }

    protected void lookup_product_Product(ProductPriceDs ds, ProductPrice e)
            throws Exception {
        if (ds.getProduct() != null && !ds.getProduct().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) getService(IProductService.class))
                        .findByName(ds.getClientId(), ds.getProduct());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `product` = "
                                + ds.getProduct() + "  ");
            }
            e.setProduct(x);

        } else {
            e.setProduct(null);
        }
    }

}
