/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

public class ProductAttributeLovDsConv extends
        AbstractDsConverter<ProductAttributeLovDs, ProductAttribute> implements
        IDsConverter<ProductAttributeLovDs, ProductAttribute> {

    protected void modelToEntityAttributes(ProductAttributeLovDs ds,
            ProductAttribute e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductAttributeLovDs ds,
            ProductAttribute e) throws Exception {
    }

    @Override
    public void entityToModel(ProductAttribute e, ProductAttributeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
