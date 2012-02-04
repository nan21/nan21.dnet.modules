/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

public class SkillService extends AbstractEntityService<Skill> implements
        ISkillService {

    public SkillService() {
        super();
    }

    public SkillService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Skill> getEntityClass() {
        return Skill.class;
    }

    public Skill findByName(Long clientId, String name) {
        return (Skill) this.em.createNamedQuery(Skill.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Skill> findByType(SkillType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Skill> findByTypeId(Long typeId) {
        return (List<Skill>) this.em
                .createQuery(
                        "select e from Skill e where e.type.id = :pTypeId",
                        Skill.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<Skill> findByRatingScale(RatingScale ratingScale) {
        return this.findByRatingScaleId(ratingScale.getId());
    }

    public List<Skill> findByRatingScaleId(Long ratingScaleId) {
        return (List<Skill>) this.em
                .createQuery(
                        "select e from Skill e where e.ratingScale.id = :pRatingScaleId",
                        Skill.class)
                .setParameter("pRatingScaleId", ratingScaleId).getResultList();
    }

}
