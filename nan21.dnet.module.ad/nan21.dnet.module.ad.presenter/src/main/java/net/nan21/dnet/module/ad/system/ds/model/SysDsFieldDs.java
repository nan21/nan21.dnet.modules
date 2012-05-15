/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDsField.class, sort = { @SortField(field = SysDsFieldDs.fNAME) })
public class SysDsFieldDs extends AbstractTypeDs<SysDsField> {

    public static final String fDATASOURCEID = "dataSourceId";
    public static final String fDATASOURCE = "dataSource";
    public static final String fDATATYPE = "dataType";

    @DsField(join = "left", path = "dataSource.id")
    private Long dataSourceId;

    @DsField(join = "left", path = "dataSource.name")
    private String dataSource;

    @DsField()
    private String dataType;

    public SysDsFieldDs() {
        super();
    }

    public SysDsFieldDs(SysDsField e) {
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

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
