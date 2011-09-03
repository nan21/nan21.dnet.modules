/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;

public class ProductAttributeGroupLovDsConv extends
        AbstractDsConverter<ProductAttributeGroupLovDs, ProductAttributeGroup>
        implements
        IDsConverter<ProductAttributeGroupLovDs, ProductAttributeGroup> {

    protected void modelToEntityAttributes(ProductAttributeGroupLovDs ds,
            ProductAttributeGroup e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductAttributeGroupLovDs ds,
            ProductAttributeGroup e) throws Exception {
    }

    @Override
    public void entityToModel(ProductAttributeGroup e,
            ProductAttributeGroupLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
