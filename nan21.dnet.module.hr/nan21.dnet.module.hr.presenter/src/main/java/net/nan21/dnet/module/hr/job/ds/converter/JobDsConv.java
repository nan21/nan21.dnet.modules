/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(JobDs ds, Job e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValidFrom(ds.getValidFrom());
        e.setValidTo(ds.getValidTo());
    }

    protected void modelToEntityReferences(JobDs ds, Job e) throws Exception {

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
                x = ((IJobTypeService) getService(IJobTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
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

    @Override
    public void entityToModel(Job e, JobDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setValidFrom(e.getValidFrom());
        ds.setValidTo(e.getValidTo());
        ds.setTypeId(((e.getJobType() != null)) ? e.getJobType().getId() : null);
        ds.setType(((e.getJobType() != null)) ? e.getJobType().getName() : null);
    }

}
