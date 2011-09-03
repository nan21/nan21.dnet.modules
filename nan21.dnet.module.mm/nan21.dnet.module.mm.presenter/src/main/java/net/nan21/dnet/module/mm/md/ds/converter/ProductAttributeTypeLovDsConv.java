/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

public class ProductAttributeTypeLovDsConv extends
        AbstractDsConverter<ProductAttributeTypeLovDs, ProductAttributeType>
        implements
        IDsConverter<ProductAttributeTypeLovDs, ProductAttributeType> {

    protected void modelToEntityAttributes(ProductAttributeTypeLovDs ds,
            ProductAttributeType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductAttributeTypeLovDs ds,
            ProductAttributeType e) throws Exception {
    }

    @Override
    public void entityToModel(ProductAttributeType e,
            ProductAttributeTypeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
