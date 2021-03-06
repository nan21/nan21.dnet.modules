/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IQualificationSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.QualificationSkill;

public class QualificationSkillService extends
        AbstractEntityService<QualificationSkill> implements
        IQualificationSkillService {

    public QualificationSkillService() {
        super();
    }

    public QualificationSkillService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<QualificationSkill> getEntityClass() {
        return QualificationSkill.class;
    }

    public List<QualificationSkill> findByQualification(
            Qualification qualification) {
        return this.findByQualificationId(qualification.getId());
    }

    public List<QualificationSkill> findByQualificationId(Long qualificationId) {
        return (List<QualificationSkill>) this.em
                .createQuery(
                        "select e from QualificationSkill e where e.clientId = :pClientId and e.qualification.id = :pQualificationId",
                        QualificationSkill.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pQualificationId", qualificationId)
                .getResultList();
    }

    public List<QualificationSkill> findBySkill(Skill skill) {
        return this.findBySkillId(skill.getId());
    }

    public List<QualificationSkill> findBySkillId(Long skillId) {
        return (List<QualificationSkill>) this.em
                .createQuery(
                        "select e from QualificationSkill e where e.clientId = :pClientId and e.skill.id = :pSkillId",
                        QualificationSkill.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSkillId", skillId).getResultList();
    }

    public List<QualificationSkill> findByRequiredLevel(
            RatingLevel requiredLevel) {
        return this.findByRequiredLevelId(requiredLevel.getId());
    }

    public List<QualificationSkill> findByRequiredLevelId(Long requiredLevelId) {
        return (List<QualificationSkill>) this.em
                .createQuery(
                        "select e from QualificationSkill e where e.clientId = :pClientId and e.requiredLevel.id = :pRequiredLevelId",
                        QualificationSkill.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRequiredLevelId", requiredLevelId)
                .getResultList();
    }

}
