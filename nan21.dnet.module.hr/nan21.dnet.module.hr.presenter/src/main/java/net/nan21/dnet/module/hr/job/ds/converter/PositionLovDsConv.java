/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.PositionLovDs;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

public class PositionLovDsConv extends
        AbstractDsConverter<PositionLovDs, Position> implements
        IDsConverter<PositionLovDs, Position> {

    protected void modelToEntityAttributes(PositionLovDs ds, Position e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(PositionLovDs ds, Position e)
            throws Exception {
    }

    @Override
    public void entityToModel(Position e, PositionLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}