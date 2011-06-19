/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAccountGroupLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;

public class ProductAccountGroupLovDsConv extends
        AbstractDsConverter<ProductAccountGroupLovDs, ProductAccountGroup>
        implements IDsConverter<ProductAccountGroupLovDs, ProductAccountGroup> {

    protected void modelToEntityAttributes(ProductAccountGroupLovDs ds,
            ProductAccountGroup e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductAccountGroupLovDs ds,
            ProductAccountGroup e) throws Exception {
    }

    @Override
    public void entityToModel(ProductAccountGroup e, ProductAccountGroupLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
