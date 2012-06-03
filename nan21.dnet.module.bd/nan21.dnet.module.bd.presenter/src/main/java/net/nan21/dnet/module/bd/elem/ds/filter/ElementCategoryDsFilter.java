/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class ElementCategoryDsFilter extends AbstractTypeDsFilter {

    private Long engineId;

    private Long engineId_From;
    private Long engineId_To;

    private String engine;

    private String engineType;

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

}
