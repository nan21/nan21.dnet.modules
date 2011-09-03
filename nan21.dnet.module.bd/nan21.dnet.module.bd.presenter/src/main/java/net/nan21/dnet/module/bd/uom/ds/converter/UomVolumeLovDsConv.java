/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public class UomVolumeLovDsConv extends
        AbstractDsConverter<UomVolumeLovDs, Uom> implements
        IDsConverter<UomVolumeLovDs, Uom> {

    protected void modelToEntityAttributes(UomVolumeLovDs ds, Uom e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UomVolumeLovDs ds, Uom e)
            throws Exception {
    }

    @Override
    public void entityToModel(Uom e, UomVolumeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
