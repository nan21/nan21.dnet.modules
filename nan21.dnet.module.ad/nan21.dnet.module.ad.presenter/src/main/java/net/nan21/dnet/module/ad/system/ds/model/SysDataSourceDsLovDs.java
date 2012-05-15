/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysDataSource.class, jpqlWhere = " e.isAsgn = false ", sort = { @SortField(field = SysDataSourceDsLovDs.fNAME) })
public class SysDataSourceDsLovDs extends AbstractTypeLov<SysDataSource> {

    public SysDataSourceDsLovDs() {
        super();
    }

    public SysDataSourceDsLovDs(SysDataSource e) {
        super(e);
    }

}
