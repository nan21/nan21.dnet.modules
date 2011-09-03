/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

public class UomTypeLovDsConv extends
        AbstractDsConverter<UomTypeLovDs, UomType> implements
        IDsConverter<UomTypeLovDs, UomType> {

    protected void modelToEntityAttributes(UomTypeLovDs ds, UomType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UomTypeLovDs ds, UomType e)
            throws Exception {
    }

    @Override
    public void entityToModel(UomType e, UomTypeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
