/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

@Ds(entity = SysJobCtx.class, sort = { @SortField(field = SysJobCtxDs.fNAME) })
public class SysJobCtxDs extends AbstractTypeDs<SysJobCtx> {

    public static final String fJOBALIAS = "jobAlias";

    @DsField()
    private String jobAlias;

    public SysJobCtxDs() {
        super();
    }

    public SysJobCtxDs(SysJobCtx e) {
        super(e);
    }

    public String getJobAlias() {
        return this.jobAlias;
    }

    public void setJobAlias(String jobAlias) {
        this.jobAlias = jobAlias;
    }

}
