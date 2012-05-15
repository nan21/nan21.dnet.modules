/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.business.service.IJobTypeService;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.JobDs;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

public class JobDsConv extends AbstractDsConverter<JobDs, Job> implements
        IDsConverter<JobDs, Job> {

    @Override
    protected void modelToEntityReferences(JobDs ds, Job e, boolean isInsert)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getJobType() == null
                    || !e.getJobType().getId().equals(ds.getTypeId())) {
                e.setJobType((JobType) this.em.find(JobType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_jobType_JobType(ds, e);
        }

    }

    protected void lookup_jobType_JobType(JobDs ds, Job e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            JobType x = null;
            try {
                x = ((IJobTypeService) findEntityService(JobType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `JobType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setJobType(x);

        } else {
            e.setJobType(null);
        }
    }

}
