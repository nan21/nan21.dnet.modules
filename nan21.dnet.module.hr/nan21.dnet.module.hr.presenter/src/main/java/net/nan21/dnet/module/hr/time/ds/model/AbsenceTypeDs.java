/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AbsenceType.class, sort = { @SortField(field = AbsenceTypeDs.fNAME) })
public class AbsenceTypeDs extends AbstractTypeDs<AbsenceType> {

    public static final String fCATEGORYID = "categoryId";
    public static final String fCATEGORY = "category";

    @DsField(join = "left", path = "category.id")
    private Long categoryId;

    @DsField(join = "left", path = "category.name")
    private String category;

    public AbsenceTypeDs() {
        super();
    }

    public AbsenceTypeDs(AbsenceType e) {
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
