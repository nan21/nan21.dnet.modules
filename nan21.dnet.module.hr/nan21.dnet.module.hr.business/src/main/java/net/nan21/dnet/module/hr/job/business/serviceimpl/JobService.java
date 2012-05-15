/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
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

    public Job findByCode(String code) {
        return (Job) this.em.createNamedQuery(Job.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Job findByName(String name) {
        return (Job) this.em.createNamedQuery(Job.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Job> findByJobType(JobType jobType) {
        return this.findByJobTypeId(jobType.getId());
    }

    public List<Job> findByJobTypeId(Long jobTypeId) {
        return (List<Job>) this.em
                .createQuery(
                        "select e from Job e where e.clientId = :pClientId and e.jobType.id = :pJobTypeId",
                        Job.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobTypeId", jobTypeId).getResultList();
    }

}
