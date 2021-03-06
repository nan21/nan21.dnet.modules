/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SysDsEventDsFilter extends AbstractAuditableDsFilter {

    private Long dataSourceId;

    private Long dataSourceId_From;
    private Long dataSourceId_To;

    private String dataSource;

    private String name;

    public Long getDataSourceId() {
        return this.dataSourceId;
    }

    public Long getDataSourceId_From() {
        return this.dataSourceId_From;
    }

    public Long getDataSourceId_To() {
        return this.dataSourceId_To;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public void setDataSourceId_From(Long dataSourceId_From) {
        this.dataSourceId_From = dataSourceId_From;
    }

    public void setDataSourceId_To(Long dataSourceId_To) {
        this.dataSourceId_To = dataSourceId_To;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
