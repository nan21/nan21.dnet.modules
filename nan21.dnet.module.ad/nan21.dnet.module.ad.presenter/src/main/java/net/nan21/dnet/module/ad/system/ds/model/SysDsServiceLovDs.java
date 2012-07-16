/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

@Ds(entity = SysDsService.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SysDsServiceLovDs.fNAME) })
public class SysDsServiceLovDs extends AbstractTypeLov<SysDsService> {

    public static final String fDATASOURCEID = "dataSourceId";
    public static final String fDATASOURCENAME = "dataSourceName";

    @DsField(join = "left", path = "dataSource.id")
    private Long dataSourceId;

    @DsField(join = "left", path = "dataSource.name")
    private String dataSourceName;

    public SysDsServiceLovDs() {
        super();
    }

    public SysDsServiceLovDs(SysDsService e) {
        super(e);
    }

    public Long getDataSourceId() {
        return this.dataSourceId;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getDataSourceName() {
        return this.dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

}
