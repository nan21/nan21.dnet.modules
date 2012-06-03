/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysJobCtx.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SysJobCtxLovDs.fNAME) })
public class SysJobCtxLovDs extends AbstractTypeLov<SysJobCtx> {

    public SysJobCtxLovDs() {
        super();
    }

    public SysJobCtxLovDs(SysJobCtx e) {
        super(e);
    }

}
