/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WorkRequirementType.class, sort = { @SortField(field = WorkRequirementTypeDs.fNAME) })
public class WorkRequirementTypeDs extends AbstractTypeDs<WorkRequirementType> {

    public WorkRequirementTypeDs() {
        super();
    }

    public WorkRequirementTypeDs(WorkRequirementType e) {
        super(e);
    }

}
