/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysTimer.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SysTimerLovDs.fNAME) })
public class SysTimerLovDs extends AbstractTypeLov<SysTimer> {

    public SysTimerLovDs() {
        super();
    }

    public SysTimerLovDs(SysTimer e) {
        super(e);
    }

}
