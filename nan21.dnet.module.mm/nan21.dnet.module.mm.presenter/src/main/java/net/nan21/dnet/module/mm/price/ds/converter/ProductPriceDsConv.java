/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.price.business.service.IPriceListVersionService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListVersion;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.price.ds.model.ProductPriceDs;
import net.nan21.dnet.module.mm.price.domain.entity.ProductPrice;

public class ProductPriceDsConv extends
        AbstractDsConverter<ProductPriceDs, ProductPrice> implements
        IDsConverter<ProductPriceDs, ProductPrice> {

    @Override
    protected void modelToEntityReferences(ProductPriceDs ds, ProductPrice e,
            boolean isInsert) throws Exception {

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }

        if (ds.getPriceListVersionId() != null) {
            if (e.getPriceListVersion() == null
                    || !e.getPriceListVersion().getId()
                            .equals(ds.getPriceListVersionId())) {
                e.setPriceListVersion((PriceListVersion) this.em.find(
                        PriceListVersion.class, ds.getPriceListVersionId()));
            }
        } else {
            this.lookup_priceListVersion_PriceListVersion(ds, e);
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

    }

    protected void lookup_product_Product(ProductPriceDs ds, ProductPrice e)
            throws Exception {
        if (ds.getProduct() != null && !ds.getProduct().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByName(ds.getProduct());
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

    protected void lookup_priceListVersion_PriceListVersion(ProductPriceDs ds,
            ProductPrice e) throws Exception {
        if (ds.getPriceListVersion() != null
                && !ds.getPriceListVersion().equals("")) {
            PriceListVersion x = null;
            try {
                x = ((IPriceListVersionService) findEntityService(PriceListVersion.class))
                        .findByName(ds.getPriceListVersion());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PriceListVersion` reference:  `priceListVersion` = "
                                + ds.getPriceListVersion() + "  ");
            }
            e.setPriceListVersion(x);

        } else {
            e.setPriceListVersion(null);
        }
    }

    protected void lookup_uom_Uom(ProductPriceDs ds, ProductPrice e)
            throws Exception {
        if (ds.getUom() != null && !ds.getUom().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getUom());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `uom` = "
                                + ds.getUom() + "  ");
            }
            e.setUom(x);

        } else {
            e.setUom(null);
        }
    }

}
