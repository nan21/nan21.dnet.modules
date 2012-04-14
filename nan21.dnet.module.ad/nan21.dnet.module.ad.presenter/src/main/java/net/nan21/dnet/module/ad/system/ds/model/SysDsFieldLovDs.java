/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDsField.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SysDsFieldLovDs.fNAME) })
public class SysDsFieldLovDs extends AbstractTypeLov<SysDsField> {

    public static final String fDATASOURCEID = "dataSourceId";
    public static final String fDATASOURCENAME = "dataSourceName";
    public static final String fDATATYPE = "dataType";

    @DsField(join = "left", path = "dataSource.id")
    private Long dataSourceId;

    @DsField(join = "left", path = "dataSource.name")
    private String dataSourceName;

    @DsField()
    private String dataType;

    public SysDsFieldLovDs() {
        super();
    }

    public SysDsFieldLovDs(SysDsField e) {
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

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
