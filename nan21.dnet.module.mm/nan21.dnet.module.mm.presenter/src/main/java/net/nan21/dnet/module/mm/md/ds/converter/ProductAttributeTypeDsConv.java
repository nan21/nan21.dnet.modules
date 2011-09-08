/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeCategoryService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

public class ProductAttributeTypeDsConv extends
        AbstractDsConverter<ProductAttributeTypeDs, ProductAttributeType>
        implements IDsConverter<ProductAttributeTypeDs, ProductAttributeType> {

    protected void modelToEntityAttributes(ProductAttributeTypeDs ds,
            ProductAttributeType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProductAttributeTypeDs ds,
            ProductAttributeType e) throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ProductAttributeCategory) this.em.getReference(
                        ProductAttributeCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ProductAttributeCategory(ds, e);
        }
    }

    protected void lookup_category_ProductAttributeCategory(
            ProductAttributeTypeDs ds, ProductAttributeType e) throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            ProductAttributeCategory x = null;
            try {
                x = ((IProductAttributeCategoryService) getService(IProductAttributeCategoryService.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);
        }
    }

    @Override
    public void entityToModel(ProductAttributeType e, ProductAttributeTypeDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCategoryId(((e.getCategory() != null)) ? e.getCategory().getId()
                : null);
        ds.setCategory(((e.getCategory() != null)) ? e.getCategory().getName()
                : null);
    }

}
