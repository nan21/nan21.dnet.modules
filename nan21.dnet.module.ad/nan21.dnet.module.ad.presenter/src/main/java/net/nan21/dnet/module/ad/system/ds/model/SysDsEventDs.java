/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDsEvent.class)
public class SysDsEventDs extends AbstractAuditableDs<SysDsEvent> {

    public static final String fDATASOURCEID = "dataSourceId";
    public static final String fDATASOURCE = "dataSource";
    public static final String fNAME = "name";

    @DsField(join = "left", path = "dataSource.id")
    private Long dataSourceId;

    @DsField(join = "left", path = "dataSource.name")
    private String dataSource;

    @DsField(path = "eventType")
    private String name;

    public SysDsEventDs() {
        super();
    }

    public SysDsEventDs(SysDsEvent e) {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
