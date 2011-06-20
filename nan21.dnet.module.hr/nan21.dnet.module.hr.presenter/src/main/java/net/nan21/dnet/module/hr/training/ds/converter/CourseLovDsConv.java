/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.CourseLovDs;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

public class CourseLovDsConv extends AbstractDsConverter<CourseLovDs, Course>
        implements IDsConverter<CourseLovDs, Course> {

    protected void modelToEntityAttributes(CourseLovDs ds, Course e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CourseLovDs ds, Course e)
            throws Exception {
    }

    @Override
    public void entityToModel(Course e, CourseLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
