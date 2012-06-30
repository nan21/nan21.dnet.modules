/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeValueDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;

public class ProductAttributeValueDsConv extends
        AbstractDsConverter<ProductAttributeValueDs, ProductAttributeValue>
        implements IDsConverter<ProductAttributeValueDs, ProductAttributeValue> {

    @Override
    protected void modelToEntityReferences(ProductAttributeValueDs ds,
            ProductAttributeValue e, boolean isInsert) throws Exception {

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }

        if (ds.getAttributeId() != null) {
            if (e.getAttribute() == null
                    || !e.getAttribute().getId().equals(ds.getAttributeId())) {
                e.setAttribute((Attribute) this.em.find(Attribute.class,
                        ds.getAttributeId()));
            }
        } else {
            this.lookup_attribute_Attribute(ds, e);
        }

    }

    protected void lookup_product_Product(ProductAttributeValueDs ds,
            ProductAttributeValue e) throws Exception {
        if (ds.getProductCode() != null && !ds.getProductCode().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getProductCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `productCode` = "
                                + ds.getProductCode() + "  ");
            }
            e.setProduct(x);
            ds.setProductId(x.getId());
        } else {
            e.setProduct(null);
        }
    }

    protected void lookup_attribute_Attribute(ProductAttributeValueDs ds,
            ProductAttributeValue e) throws Exception {
        if (ds.getAttribute() != null && !ds.getAttribute().equals("")) {
            Attribute x = null;
            try {
                x = ((IAttributeService) findEntityService(Attribute.class))
                        .findByName(ds.getAttribute());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Attribute` reference:  `attribute` = "
                                + ds.getAttribute() + "  ");
            }
            e.setAttribute(x);
            ds.setAttributeId(x.getId());
        } else {
            e.setAttribute(null);
        }
    }

}
