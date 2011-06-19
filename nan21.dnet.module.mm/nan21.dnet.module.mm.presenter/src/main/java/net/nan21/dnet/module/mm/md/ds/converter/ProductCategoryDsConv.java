/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;
import net.nan21.dnet.module.mm.md.domain.service.IProductCategoryService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductCategoryDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;

public class ProductCategoryDsConv extends
        AbstractDsConverter<ProductCategoryDs, ProductCategory> implements
        IDsConverter<ProductCategoryDs, ProductCategory> {

    protected void modelToEntityAttributes(ProductCategoryDs ds,
            ProductCategory e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProductCategoryDs ds,
            ProductCategory e) throws Exception {

        if (ds.getParentId() != null) {
            if (e.getParent() == null
                    || !e.getParent().getId().equals(ds.getParentId())) {
                e.setParent((ProductCategory) this.em.getReference(
                        ProductCategory.class, ds.getParentId()));
            }
        } else {
            this.lookup_parent_ProductCategory(ds, e);
        }
    }

    protected void lookup_parent_ProductCategory(ProductCategoryDs ds,
            ProductCategory e) throws Exception {
        ProductCategory x = null;
        try {
            x = ((IProductCategoryService) getService(IProductCategoryService.class))
                    .findByName(ds.getClientId(), ds.getParentName());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setParent(x);
    }

    @Override
    public void entityToModel(ProductCategory e, ProductCategoryDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setParentId(((e.getParent() != null)) ? e.getParent().getId() : null);
        ds.setParentName(((e.getParent() != null)) ? e.getParent().getName()
                : null);
    }

}
