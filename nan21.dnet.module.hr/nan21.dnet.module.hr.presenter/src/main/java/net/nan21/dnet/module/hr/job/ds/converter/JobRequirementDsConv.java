/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.business.service.IWorkRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.JobRequirementDs;
import net.nan21.dnet.module.hr.job.domain.entity.JobRequirement;

public class JobRequirementDsConv extends
        AbstractDsConverter<JobRequirementDs, JobRequirement> implements
        IDsConverter<JobRequirementDs, JobRequirement> {

    protected void modelToEntityReferences(JobRequirementDs ds, JobRequirement e)
            throws Exception {
        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.find(Job.class, ds.getJobId()));
            }
        }
        if (ds.getRequirementId() != null) {
            if (e.getRequirement() == null
                    || !e.getRequirement().getId()
                            .equals(ds.getRequirementId())) {
                e.setRequirement((WorkRequirement) this.em.find(
                        WorkRequirement.class, ds.getRequirementId()));
            }
        } else {
            this.lookup_requirement_WorkRequirement(ds, e);
        }
    }

    protected void lookup_requirement_WorkRequirement(JobRequirementDs ds,
            JobRequirement e) throws Exception {
        if (ds.getRequirement() != null && !ds.getRequirement().equals("")) {
            WorkRequirement x = null;
            try {
                x = ((IWorkRequirementService) findEntityService(WorkRequirement.class))
                        .findByName(ds.getClientId(), ds.getRequirement());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `WorkRequirement` reference:  `requirement` = "
                                + ds.getRequirement() + "  ");
            }
            e.setRequirement(x);

        } else {
            e.setRequirement(null);
        }
    }

}
