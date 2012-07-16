/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

@Ds(entity = WorkRequirement.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = WorkRequirementLovDs.fNAME) })
public class WorkRequirementLovDs extends AbstractTypeLov<WorkRequirement> {

    public WorkRequirementLovDs() {
        super();
    }

    public WorkRequirementLovDs(WorkRequirement e) {
        super(e);
    }

}
