/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class SysJobCtxDsFilter extends AbstractTypeDsFilter {

    private String jobAlias;

    public String getJobAlias() {
        return this.jobAlias;
    }

    public void setJobAlias(String jobAlias) {
        this.jobAlias = jobAlias;
    }

}
