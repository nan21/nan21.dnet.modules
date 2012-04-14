/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class AbsenceTypeDsFilter extends AbstractTypeDsFilter {

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    public Long getCategoryId() {
        return this.categoryId;
    }

    public Long getCategoryId_From() {
        return this.categoryId_From;
    }

    public Long getCategoryId_To() {
        return this.categoryId_To;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryId_From(Long categoryId_From) {
        this.categoryId_From = categoryId_From;
    }

    public void setCategoryId_To(Long categoryId_To) {
        this.categoryId_To = categoryId_To;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
