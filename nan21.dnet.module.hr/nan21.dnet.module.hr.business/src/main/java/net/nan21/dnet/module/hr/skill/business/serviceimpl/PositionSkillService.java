/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.skill.business.service.IPositionSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;

public class PositionSkillService extends AbstractEntityService<PositionSkill>
        implements IPositionSkillService {

    public PositionSkillService() {
        super();
    }

    public PositionSkillService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PositionSkill> getEntityClass() {
        return PositionSkill.class;
    }

    public List<PositionSkill> findByPosition(Position position) {
        return this.findByPositionId(position.getId());
    }

    public List<PositionSkill> findByPositionId(Long positionId) {
        return (List<PositionSkill>) this.em
                .createQuery(
                        "select e from PositionSkill e where e.position.id = :pPositionId",
                        PositionSkill.class)
                .setParameter("pPositionId", positionId).getResultList();
    }

    public List<PositionSkill> findBySkill(Skill skill) {
        return this.findBySkillId(skill.getId());
    }

    public List<PositionSkill> findBySkillId(Long skillId) {
        return (List<PositionSkill>) this.em
                .createQuery(
                        "select e from PositionSkill e where e.skill.id = :pSkillId",
                        PositionSkill.class).setParameter("pSkillId", skillId)
                .getResultList();
    }

    public List<PositionSkill> findByRequiredLevel(RatingLevel requiredLevel) {
        return this.findByRequiredLevelId(requiredLevel.getId());
    }

    public List<PositionSkill> findByRequiredLevelId(Long requiredLevelId) {
        return (List<PositionSkill>) this.em
                .createQuery(
                        "select e from PositionSkill e where e.requiredLevel.id = :pRequiredLevelId",
                        PositionSkill.class)
                .setParameter("pRequiredLevelId", requiredLevelId)
                .getResultList();
    }

}
