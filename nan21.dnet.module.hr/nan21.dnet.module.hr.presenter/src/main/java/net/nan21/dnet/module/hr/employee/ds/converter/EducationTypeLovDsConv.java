/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EducationTypeLovDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;

public class EducationTypeLovDsConv extends
        AbstractDsConverter<EducationTypeLovDs, EducationType> implements
        IDsConverter<EducationTypeLovDs, EducationType> {

    protected void modelToEntityAttributes(EducationTypeLovDs ds,
            EducationType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(EducationTypeLovDs ds,
            EducationType e) throws Exception {
    }

    @Override
    public void entityToModel(EducationType e, EducationTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
