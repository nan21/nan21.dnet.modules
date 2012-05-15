/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDataSource.class, sort = { @SortField(field = SysDataSourceDs.fNAME) })
public class SysDataSourceDs extends AbstractTypeDs<SysDataSource> {

    public static final String fMODEL = "model";
    public static final String fISASGN = "isAsgn";

    @DsField()
    private String model;

    @DsField()
    private Boolean isAsgn;

    public SysDataSourceDs() {
        super();
    }

    public SysDataSourceDs(SysDataSource e) {
        super(e);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getIsAsgn() {
        return this.isAsgn;
    }

    public void setIsAsgn(Boolean isAsgn) {
        this.isAsgn = isAsgn;
    }

}
