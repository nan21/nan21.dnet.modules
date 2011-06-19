/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductCategoryLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;

public class ProductCategoryLovDsConv extends
        AbstractDsConverter<ProductCategoryLovDs, ProductCategory> implements
        IDsConverter<ProductCategoryLovDs, ProductCategory> {

    protected void modelToEntityAttributes(ProductCategoryLovDs ds,
            ProductCategory e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductCategoryLovDs ds,
            ProductCategory e) throws Exception {
    }

    @Override
    public void entityToModel(ProductCategory e, ProductCategoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
