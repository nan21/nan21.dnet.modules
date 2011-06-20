/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.CourseTypeLovDs;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

public class CourseTypeLovDsConv extends
        AbstractDsConverter<CourseTypeLovDs, CourseType> implements
        IDsConverter<CourseTypeLovDs, CourseType> {

    protected void modelToEntityAttributes(CourseTypeLovDs ds, CourseType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CourseTypeLovDs ds, CourseType e)
            throws Exception {
    }

    @Override
    public void entityToModel(CourseType e, CourseTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
