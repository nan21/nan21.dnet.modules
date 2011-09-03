/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomTypeDs;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

public class UomTypeDsConv extends AbstractDsConverter<UomTypeDs, UomType>
        implements IDsConverter<UomTypeDs, UomType> {

    protected void modelToEntityAttributes(UomTypeDs ds, UomType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setCategory(ds.getCategory());
    }

    protected void modelToEntityReferences(UomTypeDs ds, UomType e)
            throws Exception {
    }

    @Override
    public void entityToModel(UomType e, UomTypeDs ds) throws Exception {
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
        ds.setCategory(e.getCategory());
    }

}
