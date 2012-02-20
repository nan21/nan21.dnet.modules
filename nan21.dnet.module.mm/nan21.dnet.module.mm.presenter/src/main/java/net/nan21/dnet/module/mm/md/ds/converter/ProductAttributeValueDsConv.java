/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeGroupAttributeService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeService;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroupAttribute;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;

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

        if (ds.getAttributeId() == null) {
            ProductAttribute x = ((IProductAttributeService) findEntityService(ProductAttribute.class))
                    .findByName(ds.getAttribute());

            ds.setAttributeId(x.getId());
        }

        if (ds.getGroupAttributeId() != null) {
            if (e.getGroupAttribute() == null
                    || !e.getGroupAttribute().getId()
                            .equals(ds.getGroupAttributeId())) {
                e.setGroupAttribute((ProductAttributeGroupAttribute) this.em
                        .find(ProductAttributeGroupAttribute.class,
                                ds.getGroupAttributeId()));
            }
        } else {
            this.lookup_groupAttribute_ProductAttributeGroupAttribute(ds, e);
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

    protected void lookup_groupAttribute_ProductAttributeGroupAttribute(
            ProductAttributeValueDs ds, ProductAttributeValue e)
            throws Exception {
        if (ds.getAttributeId() != null && !ds.getAttributeId().equals("")) {
            ProductAttributeGroupAttribute x = null;
            try {
                x = ((IProductAttributeGroupAttributeService) findEntityService(ProductAttributeGroupAttribute.class))
                        .findByName(e.getProduct().getAttributeGroup().getId(),
                                ds.getAttributeId());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeGroupAttribute` reference:  `groupId` = "
                                + ds.getGroupId()
                                + " , `attributeId` = "
                                + ds.getAttributeId() + "  ");
            }
            e.setGroupAttribute(x);

        } else {
            e.setGroupAttribute(null);
        }
    }

}
