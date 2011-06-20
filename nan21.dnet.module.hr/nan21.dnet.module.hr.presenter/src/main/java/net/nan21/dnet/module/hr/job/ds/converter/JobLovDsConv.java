/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.JobLovDs;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

public class JobLovDsConv extends AbstractDsConverter<JobLovDs, Job> implements
        IDsConverter<JobLovDs, Job> {

    protected void modelToEntityAttributes(JobLovDs ds, Job e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(JobLovDs ds, Job e) throws Exception {
    }

    @Override
    public void entityToModel(Job e, JobLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
