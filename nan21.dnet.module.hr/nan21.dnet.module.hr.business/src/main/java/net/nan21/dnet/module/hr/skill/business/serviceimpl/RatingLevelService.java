/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IRatingLevelService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

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

    public RatingLevel findByName(RatingScale ratingScale, String name) {
        return (RatingLevel) this.em
                .createNamedQuery(RatingLevel.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRatingScale", ratingScale)
                .setParameter("pName", name).getSingleResult();
    }

    public RatingLevel findByName(Long ratingScaleId, String name) {
        return (RatingLevel) this.em
                .createNamedQuery(RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRatingScaleId", ratingScaleId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<RatingLevel> findByRatingScale(RatingScale ratingScale) {
        return this.findByRatingScaleId(ratingScale.getId());
    }

    public List<RatingLevel> findByRatingScaleId(Long ratingScaleId) {
        return (List<RatingLevel>) this.em
                .createQuery(
                        "select e from RatingLevel e where e.clientId = :pClientId and e.ratingScale.id = :pRatingScaleId",
                        RatingLevel.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRatingScaleId", ratingScaleId).getResultList();
    }

}
