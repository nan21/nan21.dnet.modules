/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

@Ds(entity = EmployeeContactRelationship.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = EmployeeContactRelationshipLovDs.fNAME) })
public class EmployeeContactRelationshipLovDs extends
        AbstractTypeLov<EmployeeContactRelationship> {

    public EmployeeContactRelationshipLovDs() {
        super();
    }

    public EmployeeContactRelationshipLovDs(EmployeeContactRelationship e) {
        super(e);
    }

}
