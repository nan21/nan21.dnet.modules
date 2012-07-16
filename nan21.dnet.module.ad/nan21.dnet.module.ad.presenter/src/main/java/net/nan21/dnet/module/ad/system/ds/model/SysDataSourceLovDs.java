/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

@Ds(entity = SysDataSource.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SysDataSourceLovDs.fNAME) })
public class SysDataSourceLovDs extends AbstractTypeLov<SysDataSource> {

    public SysDataSourceLovDs() {
        super();
    }

    public SysDataSourceLovDs(SysDataSource e) {
        super(e);
    }

}
