/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.usr.domain.entity.UserType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = UserType.class, sort = { @SortField(field = UserTypeDs.fNAME) })
public class UserTypeDs extends AbstractTypeDs<UserType> {

    public static final String fEMPLOYEEACCOUNT = "employeeAccount";
    public static final String fBPACCOUNT = "bpAccount";

    @DsField()
    private Boolean employeeAccount;

    @DsField()
    private Boolean bpAccount;

    public UserTypeDs() {
        super();
    }

    public UserTypeDs(UserType e) {
        super(e);
    }

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
