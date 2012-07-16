/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

@Ds(entity = JobType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = JobTypeLovDs.fNAME) })
public class JobTypeLovDs extends AbstractTypeLov<JobType> {

    public JobTypeLovDs() {
        super();
    }

    public JobTypeLovDs(JobType e) {
        super(e);
    }

}
