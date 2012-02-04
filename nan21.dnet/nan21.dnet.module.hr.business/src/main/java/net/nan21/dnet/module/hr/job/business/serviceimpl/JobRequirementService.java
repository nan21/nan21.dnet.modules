/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IJobRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.JobRequirement;

public class JobRequirementService extends
        AbstractEntityService<JobRequirement> implements IJobRequirementService {

    public JobRequirementService() {
        super();
    }

    public JobRequirementService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<JobRequirement> getEntityClass() {
        return JobRequirement.class;
    }

    public List<JobRequirement> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<JobRequirement> findByJobId(Long jobId) {
        return (List<JobRequirement>) this.em
                .createQuery(
                        "select e from JobRequirement e where e.job.id = :pJobId",
                        JobRequirement.class).setParameter("pJobId", jobId)
                .getResultList();
    }

    public List<JobRequirement> findByRequirement(WorkRequirement requirement) {
        return this.findByRequirementId(requirement.getId());
    }

    public List<JobRequirement> findByRequirementId(Long requirementId) {
        return (List<JobRequirement>) this.em
                .createQuery(
                        "select e from JobRequirement e where e.requirement.id = :pRequirementId",
                        JobRequirement.class)
                .setParameter("pRequirementId", requirementId).getResultList();
    }

}
