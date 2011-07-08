/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.skill.business.service.IJobSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.JobSkill;

public class JobSkillService extends AbstractEntityService<JobSkill> implements
        IJobSkillService {

    public JobSkillService() {
        super();
    }

    public JobSkillService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<JobSkill> getEntityClass() {
        return JobSkill.class;
    }

    public List<JobSkill> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<JobSkill> findByJobId(Long jobId) {
        return (List<JobSkill>) this.em
                .createQuery(
                        "select e from JobSkill e where e.job.id = :pJobId",
                        JobSkill.class).setParameter("pJobId", jobId)
                .getResultList();
    }

    public List<JobSkill> findBySkill(Skill skill) {
        return this.findBySkillId(skill.getId());
    }

    public List<JobSkill> findBySkillId(Long skillId) {
        return (List<JobSkill>) this.em
                .createQuery(
                        "select e from JobSkill e where e.skill.id = :pSkillId",
                        JobSkill.class).setParameter("pSkillId", skillId)
                .getResultList();
    }

    public List<JobSkill> findByRequiredLevel(RatingLevel requiredLevel) {
        return this.findByRequiredLevelId(requiredLevel.getId());
    }

    public List<JobSkill> findByRequiredLevelId(Long requiredLevelId) {
        return (List<JobSkill>) this.em
                .createQuery(
                        "select e from JobSkill e where e.requiredLevel.id = :pRequiredLevelId",
                        JobSkill.class)
                .setParameter("pRequiredLevelId", requiredLevelId)
                .getResultList();
    }

}
