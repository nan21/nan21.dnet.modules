/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class UserTypeDsFilter extends AbstractTypeDsFilter {

    private Boolean employeeAccount;

    private Boolean bpAccount;

    public Boolean getEmployeeAccount() {
        return this.employeeAccount;
    }

    public void setEmployeeAccount(Boolean employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public Boolean getBpAccount() {
        return this.bpAccount;
    }

    public void setBpAccount(Boolean bpAccount) {
        this.bpAccount = bpAccount;
    }

}
