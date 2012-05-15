/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IRatingScaleService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

public class RatingScaleService extends AbstractEntityService<RatingScale>
        implements IRatingScaleService {

    public RatingScaleService() {
        super();
    }

    public RatingScaleService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<RatingScale> getEntityClass() {
        return RatingScale.class;
    }

    public RatingScale findByName(String name) {
        return (RatingScale) this.em
                .createNamedQuery(RatingScale.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
