/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = EmploymentType.class, sort = { @SortField(field = EmploymentTypeDs.fNAME) })
public class EmploymentTypeDs extends AbstractTypeDs<EmploymentType> {

    public EmploymentTypeDs() {
        super();
    }

    public EmploymentTypeDs(EmploymentType e) {
        super(e);
    }

}
