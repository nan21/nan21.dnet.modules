/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WorkRequirementType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = WorkRequirementTypeLovDs.fNAME) })
public class WorkRequirementTypeLovDs extends
        AbstractTypeLov<WorkRequirementType> {

    public WorkRequirementTypeLovDs() {
        super();
    }

    public WorkRequirementTypeLovDs(WorkRequirementType e) {
        super(e);
    }

}
