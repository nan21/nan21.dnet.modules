/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CourseCategory.class, sort = { @SortField(field = CourseCategoryDs.fNAME) })
public class CourseCategoryDs extends AbstractTypeDs<CourseCategory> {

    public CourseCategoryDs() {
        super();
    }

    public CourseCategoryDs(CourseCategory e) {
        super(e);
    }

}
