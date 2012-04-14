/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Job.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = JobLovDs.fCODE) })
public class JobLovDs extends AbstractTypeWithCodeLov<Job> {

    public JobLovDs() {
        super();
    }

    public JobLovDs(Job e) {
        super(e);
    }

}
