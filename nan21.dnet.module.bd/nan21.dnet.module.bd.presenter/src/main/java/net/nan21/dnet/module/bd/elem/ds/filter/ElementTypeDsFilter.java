/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class ElementTypeDsFilter extends AbstractTypeDsFilter {

    private Long engineId;

    private Long engineId_From;
    private Long engineId_To;

    private String engine;

    private String engineType;

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    public Long getEngineId() {
        return this.engineId;
    }

    public Long getEngineId_From() {
        return this.engineId_From;
    }

    public Long getEngineId_To() {
        return this.engineId_To;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public void setEngineId_From(Long engineId_From) {
        this.engineId_From = engineId_From;
    }

    public void setEngineId_To(Long engineId_To) {
        this.engineId_To = engineId_To;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

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
