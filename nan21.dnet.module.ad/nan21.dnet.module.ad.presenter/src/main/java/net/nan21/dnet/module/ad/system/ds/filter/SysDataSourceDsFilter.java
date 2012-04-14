/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class SysDataSourceDsFilter extends AbstractTypeDsFilter {

    private String model;

    private Boolean isAsgn;

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
