/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.service.IRatingLevelService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;

public class RatingLevelService extends AbstractEntityService<RatingLevel>
        implements IRatingLevelService {

    public RatingLevelService() {
        super();
    }

    public RatingLevelService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<RatingLevel> getEntityClass() {
        return RatingLevel.class;
    }

    public RatingLevel findByName(Long clientId, RatingScale ratingScale,
            String name) {
        return (RatingLevel) this.em
                .createNamedQuery(RatingLevel.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pRatingScale", ratingScale)
                .setParameter("pName", name).getSingleResult();
    }

    public RatingLevel findByName(Long clientId, Long ratingScaleId, String name) {
        return (RatingLevel) this.em
                .createNamedQuery(RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pRatingScaleId", ratingScaleId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<RatingLevel> findByRatingScale(RatingScale ratingScale) {
        return this.findByRatingScaleId(ratingScale.getId());
    }

    public List<RatingLevel> findByRatingScaleId(Long ratingScaleId) {
        return (List<RatingLevel>) this.em
                .createQuery(
                        "select e from RatingLevel where e.ratingScale.id = :pRatingScaleId",
                        RatingLevel.class)
                .setParameter("pRatingScaleId", ratingScaleId).getResultList();
    }

}
