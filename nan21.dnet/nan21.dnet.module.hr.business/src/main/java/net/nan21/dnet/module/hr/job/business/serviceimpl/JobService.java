/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IJobService;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

public class JobService extends AbstractEntityService<Job> implements
        IJobService {

    public JobService() {
        super();
    }

    public JobService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Job> getEntityClass() {
        return Job.class;
    }

    public Job findByCode(Long clientId, String code) {
        return (Job) this.em.createNamedQuery(Job.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Job findByName(Long clientId, String name) {
        return (Job) this.em.createNamedQuery(Job.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Job> findByJobType(JobType jobType) {
        return this.findByJobTypeId(jobType.getId());
    }

    public List<Job> findByJobTypeId(Long jobTypeId) {
        return (List<Job>) this.em
                .createQuery(
                        "select e from Job e where e.jobType.id = :pJobTypeId",
                        Job.class).setParameter("pJobTypeId", jobTypeId)
                .getResultList();
    }

}
