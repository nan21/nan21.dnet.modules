/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Course.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CourseLovDs.fCODE) })
public class CourseLovDs extends AbstractTypeWithCodeLov<Course> {

    public CourseLovDs() {
        super();
    }

    public CourseLovDs(Course e) {
        super(e);
    }

}
