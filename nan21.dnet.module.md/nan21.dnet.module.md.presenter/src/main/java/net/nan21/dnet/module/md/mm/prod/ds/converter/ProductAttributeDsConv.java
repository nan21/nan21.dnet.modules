/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeGroupAttributeService;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public class ProductAttributeDsConv extends
        AbstractDsConverter<ProductAttributeDs, ProductAttribute> implements
        IDsConverter<ProductAttributeDs, ProductAttribute> {

    @Override
    protected void modelToEntityReferences(ProductAttributeDs ds,
            ProductAttribute e, boolean isInsert) throws Exception {

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
            Attribute x = ((IAttributeService) findEntityService(Attribute.class))
                    .findByName(ds.getAttribute());

            ds.setAttributeId(x.getId());
        }

        if (ds.getGroupAttributeId() != null) {
            if (e.getGroupAttribute() == null
                    || !e.getGroupAttribute().getId()
                            .equals(ds.getGroupAttributeId())) {
                e.setGroupAttribute((AttributeGroupAttribute) this.em.find(
                        AttributeGroupAttribute.class, ds.getGroupAttributeId()));
            }
        } else {
            this.lookup_groupAttribute_AttributeGroupAttribute(ds, e);
        }

    }

    protected void lookup_product_Product(ProductAttributeDs ds,
            ProductAttribute e) throws Exception {
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

    protected void lookup_groupAttribute_AttributeGroupAttribute(
            ProductAttributeDs ds, ProductAttribute e) throws Exception {
        if (ds.getAttributeId() != null && !ds.getAttributeId().equals("")) {
            AttributeGroupAttribute x = null;
            try {
                x = ((IAttributeGroupAttributeService) findEntityService(AttributeGroupAttribute.class))
                        .findByName(e.getProduct().getAttributeGroup().getId(),
                                ds.getAttributeId());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttributeGroupAttribute` reference:  `groupId` = "
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
