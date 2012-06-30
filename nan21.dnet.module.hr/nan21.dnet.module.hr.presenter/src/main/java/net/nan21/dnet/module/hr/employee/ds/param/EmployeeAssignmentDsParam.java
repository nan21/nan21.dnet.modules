/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.param;

import java.util.Date;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class EmployeeAssignmentDsParam extends EmptyParam {

    public static final String fVALIDAT = "validAt";

    private Date validAt;

    public Date getValidAt() {
        return this.validAt;
    }

    public void setValidAt(Date validAt) {
        this.validAt = validAt;
    }

}
