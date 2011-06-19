/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

public class GradeRateLovDsConv extends
        AbstractDsConverter<GradeRateLovDs, GradeRate> implements
        IDsConverter<GradeRateLovDs, GradeRate> {

    protected void modelToEntityAttributes(GradeRateLovDs ds, GradeRate e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(GradeRateLovDs ds, GradeRate e)
            throws Exception {
    }

    @Override
    public void entityToModel(GradeRate e, GradeRateLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
