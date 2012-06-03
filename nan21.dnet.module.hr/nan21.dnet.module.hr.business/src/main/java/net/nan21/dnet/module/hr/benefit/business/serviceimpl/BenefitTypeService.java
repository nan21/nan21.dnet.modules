/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IBenefitTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.benefit.domain.entity.BenefitType;

public class BenefitTypeService extends AbstractEntityService<BenefitType>
        implements IBenefitTypeService {

    public BenefitTypeService() {
        super();
    }

    public BenefitTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BenefitType> getEntityClass() {
        return BenefitType.class;
    }

    public BenefitType findByName(String name) {
        return (BenefitType) this.em
                .createNamedQuery(BenefitType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
