/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityResultReasonService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;

public class OpportunityResultReasonService extends
        AbstractEntityService<OpportunityResultReason> implements
        IOpportunityResultReasonService {

    public OpportunityResultReasonService() {
        super();
    }

    public OpportunityResultReasonService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OpportunityResultReason> getEntityClass() {
        return OpportunityResultReason.class;
    }

    public OpportunityResultReason findByName(String name) {
        return (OpportunityResultReason) this.em
                .createNamedQuery(OpportunityResultReason.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
