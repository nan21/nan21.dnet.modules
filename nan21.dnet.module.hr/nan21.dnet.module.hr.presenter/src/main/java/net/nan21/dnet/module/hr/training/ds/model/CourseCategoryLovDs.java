/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CourseCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CourseCategoryLovDs.fNAME) })
public class CourseCategoryLovDs extends AbstractTypeLov<CourseCategory> {

    public CourseCategoryLovDs() {
        super();
    }

    public CourseCategoryLovDs(CourseCategory e) {
        super(e);
    }

}
