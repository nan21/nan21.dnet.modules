/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.GradeDs;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

public class GradeDsConv extends AbstractDsConverter<GradeDs, Grade> implements
        IDsConverter<GradeDs, Grade> {

    protected void modelToEntityAttributes(GradeDs ds, Grade e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
        e.setValidFrom(ds.getValidFrom());
        e.setValidTo(ds.getValidTo());
    }

    protected void modelToEntityReferences(GradeDs ds, Grade e)
            throws Exception {
    }

    @Override
    public void entityToModel(Grade e, GradeDs ds) throws Exception {
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
        ds.setSequenceNo(e.getSequenceNo());
        ds.setValidFrom(e.getValidFrom());
        ds.setValidTo(e.getValidTo());
    }

}
