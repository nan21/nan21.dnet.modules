/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductManufacturer;

public class ProductManufacturerLovDsConv extends
        AbstractDsConverter<ProductManufacturerLovDs, ProductManufacturer>
        implements IDsConverter<ProductManufacturerLovDs, ProductManufacturer> {

    protected void modelToEntityAttributes(ProductManufacturerLovDs ds,
            ProductManufacturer e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductManufacturerLovDs ds,
            ProductManufacturer e) throws Exception {
    }

    @Override
    public void entityToModel(ProductManufacturer e, ProductManufacturerLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
