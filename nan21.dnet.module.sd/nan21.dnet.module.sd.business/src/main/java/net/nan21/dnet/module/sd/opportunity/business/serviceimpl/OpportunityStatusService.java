/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

public class OpportunityStatusService extends
        AbstractEntityService<OpportunityStatus> implements
        IOpportunityStatusService {

    public OpportunityStatusService() {
        super();
    }

    public OpportunityStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OpportunityStatus> getEntityClass() {
        return OpportunityStatus.class;
    }

    public OpportunityStatus findByName(Long clientId, String name) {
        return (OpportunityStatus) this.em
                .createNamedQuery(OpportunityStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
