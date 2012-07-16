/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;

@Ds(entity = EmploymentType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = EmploymentTypeLovDs.fNAME) })
public class EmploymentTypeLovDs extends AbstractTypeLov<EmploymentType> {

    public EmploymentTypeLovDs() {
        super();
    }

    public EmploymentTypeLovDs(EmploymentType e) {
        super(e);
    }

}
