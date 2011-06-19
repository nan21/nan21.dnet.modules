/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductManufacturer;

public class ProductManufacturerDsConv extends
        AbstractDsConverter<ProductManufacturerDs, ProductManufacturer>
        implements IDsConverter<ProductManufacturerDs, ProductManufacturer> {

    protected void modelToEntityAttributes(ProductManufacturerDs ds,
            ProductManufacturer e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProductManufacturerDs ds,
            ProductManufacturer e) throws Exception {
    }

    @Override
    public void entityToModel(ProductManufacturer e, ProductManufacturerDs ds)
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
    }

}
