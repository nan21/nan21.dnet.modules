/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDsService.class, sort = { @SortField(field = SysDsServiceDs.fNAME) })
public class SysDsServiceDs extends AbstractTypeDs<SysDsService> {

    public static final String fDATASOURCEID = "dataSourceId";
    public static final String fDATASOURCE = "dataSource";

    @DsField(join = "left", path = "dataSource.id")
    private Long dataSourceId;

    @DsField(join = "left", path = "dataSource.name")
    private String dataSource;

    public SysDsServiceDs() {
        super();
    }

    public SysDsServiceDs(SysDsService e) {
        super(e);
    }

    public Long getDataSourceId() {
        return this.dataSourceId;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

}
