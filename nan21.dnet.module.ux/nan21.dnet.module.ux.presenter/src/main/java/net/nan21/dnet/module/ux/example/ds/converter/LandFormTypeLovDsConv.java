/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ux.example.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs;
import net.nan21.dnet.module.ux.example.domain.entity.LandFormType;

public class LandFormTypeLovDsConv extends
        AbstractDsConverter<LandFormTypeLovDs, LandFormType> implements
        IDsConverter<LandFormTypeLovDs, LandFormType> {

    protected void modelToEntityAttributes(LandFormTypeLovDs ds, LandFormType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(LandFormTypeLovDs ds, LandFormType e)
            throws Exception {
    }

    @Override
    public void entityToModel(LandFormType e, LandFormTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
