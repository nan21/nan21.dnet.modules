/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

@Ds(entity = EmployeeContactRelationship.class, sort = { @SortField(field = EmployeeContactRelationshipDs.fNAME) })
public class EmployeeContactRelationshipDs extends
        AbstractTypeDs<EmployeeContactRelationship> {

    public EmployeeContactRelationshipDs() {
        super();
    }

    public EmployeeContactRelationshipDs(EmployeeContactRelationship e) {
        super(e);
    }

}
