/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunitySourceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;

public class OpportunitySourceService extends
        AbstractEntityService<OpportunitySource> implements
        IOpportunitySourceService {

    public OpportunitySourceService() {
        super();
    }

    public OpportunitySourceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OpportunitySource> getEntityClass() {
        return OpportunitySource.class;
    }

    public OpportunitySource findByName(String name) {
        return (OpportunitySource) this.em
                .createNamedQuery(OpportunitySource.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
