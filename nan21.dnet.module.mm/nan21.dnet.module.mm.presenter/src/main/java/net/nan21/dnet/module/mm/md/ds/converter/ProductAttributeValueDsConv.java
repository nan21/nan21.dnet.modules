/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;

public class ProductAttributeValueDsConv extends
        AbstractDsConverter<ProductAttributeValueDs, ProductAttributeValue>
        implements IDsConverter<ProductAttributeValueDs, ProductAttributeValue> {

    protected void modelToEntityAttributes(ProductAttributeValueDs ds,
            ProductAttributeValue e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValue(ds.getValue());
    }

    protected void modelToEntityReferences(ProductAttributeValueDs ds,
            ProductAttributeValue e) throws Exception {

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        }
        if (ds.getAttributeId() != null) {
            if (e.getAttribute() == null
                    || !e.getAttribute().getId().equals(ds.getAttributeId())) {
                e.setAttribute((ProductAttribute) this.em.find(
                        ProductAttribute.class, ds.getAttributeId()));
            }
        } else {
            this.lookup_attribute_ProductAttribute(ds, e);
        }
    }

    protected void lookup_attribute_ProductAttribute(
            ProductAttributeValueDs ds, ProductAttributeValue e)
            throws Exception {
        if (ds.getAttribute() != null && !ds.getAttribute().equals("")) {
            ProductAttribute x = null;
            try {
                x = ((IProductAttributeService) getService(IProductAttributeService.class))
                        .findByName(ds.getClientId(), ds.getAttribute());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttribute` reference:  `attribute` = "
                                + ds.getAttribute() + "  ");
            }
            e.setAttribute(x);
        } else {
            e.setAttribute(null);
        }
    }

    @Override
    public void entityToModel(ProductAttributeValue e,
            ProductAttributeValueDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setValue(e.getValue());
        ds.setProductId(((e.getProduct() != null)) ? e.getProduct().getId()
                : null);
        ds.setAttributeId(((e.getAttribute() != null)) ? e.getAttribute()
                .getId() : null);
        ds.setAttribute(((e.getAttribute() != null)) ? e.getAttribute()
                .getName() : null);
        ds.setTitle(((e.getAttribute() != null)) ? e.getAttribute().getTitle()
                : null);
        ds.setDataType(((e.getAttribute() != null)) ? e.getAttribute()
                .getDataType() : null);
        ds.setTypeId(((e.getAttribute() != null) && (e.getAttribute().getType() != null)) ? e
                .getAttribute().getType().getId()
                : null);
        ds.setType(((e.getAttribute() != null) && (e.getAttribute().getType() != null)) ? e
                .getAttribute().getType().getName()
                : null);
        ds.setUom(((e.getAttribute() != null) && (e.getAttribute().getUom() != null)) ? e
                .getAttribute().getUom().getCode()
                : null);
    }

}
