/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.CourseCategoryLovDs;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

public class CourseCategoryLovDsConv extends
        AbstractDsConverter<CourseCategoryLovDs, CourseCategory> implements
        IDsConverter<CourseCategoryLovDs, CourseCategory> {

    protected void modelToEntityAttributes(CourseCategoryLovDs ds,
            CourseCategory e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CourseCategoryLovDs ds,
            CourseCategory e) throws Exception {
    }

    @Override
    public void entityToModel(CourseCategory e, CourseCategoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
