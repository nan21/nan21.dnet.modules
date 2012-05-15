/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IJobGradeService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.JobGrade;

public class JobGradeService extends AbstractEntityService<JobGrade> implements
        IJobGradeService {

    public JobGradeService() {
        super();
    }

    public JobGradeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<JobGrade> getEntityClass() {
        return JobGrade.class;
    }

    public List<JobGrade> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<JobGrade> findByJobId(Long jobId) {
        return (List<JobGrade>) this.em
                .createQuery(
                        "select e from JobGrade e where e.clientId = :pClientId and e.job.id = :pJobId",
                        JobGrade.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).getResultList();
    }

    public List<JobGrade> findByGrade(Grade grade) {
        return this.findByGradeId(grade.getId());
    }

    public List<JobGrade> findByGradeId(Long gradeId) {
        return (List<JobGrade>) this.em
                .createQuery(
                        "select e from JobGrade e where e.clientId = :pClientId and e.grade.id = :pGradeId",
                        JobGrade.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGradeId", gradeId).getResultList();
    }

}
