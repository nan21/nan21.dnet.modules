/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityPriorityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;

public class OpportunityPriorityService extends
        AbstractEntityService<OpportunityPriority> implements
        IOpportunityPriorityService {

    public OpportunityPriorityService() {
        super();
    }

    public OpportunityPriorityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OpportunityPriority> getEntityClass() {
        return OpportunityPriority.class;
    }

    public OpportunityPriority findByName(String name) {
        return (OpportunityPriority) this.em
                .createNamedQuery(OpportunityPriority.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
