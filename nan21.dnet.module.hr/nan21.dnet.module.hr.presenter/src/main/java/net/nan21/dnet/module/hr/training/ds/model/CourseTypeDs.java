/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.training.domain.entity.CourseType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CourseType.class, sort = { @SortField(field = CourseTypeDs.fNAME) })
public class CourseTypeDs extends AbstractTypeDs<CourseType> {

    public static final String fCATEGORYID = "categoryId";
    public static final String fCATEGORY = "category";

    @DsField(join = "left", path = "category.id")
    private Long categoryId;

    @DsField(join = "left", path = "category.name")
    private String category;

    public CourseTypeDs() {
        super();
    }

    public CourseTypeDs(CourseType e) {
        super(e);
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
