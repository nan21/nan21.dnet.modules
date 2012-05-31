/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IBenefitService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.benefit.domain.entity.Benefit;

public class BenefitService extends AbstractEntityService<Benefit> implements
        IBenefitService {

    public BenefitService() {
        super();
    }

    public BenefitService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Benefit> getEntityClass() {
        return Benefit.class;
    }

    public Benefit findByName(String name) {
        return (Benefit) this.em.createNamedQuery(Benefit.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
