/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityAttachmentService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityAttachment;

public class OpportunityAttachmentService extends
        AbstractEntityService<OpportunityAttachment> implements
        IOpportunityAttachmentService {

    public OpportunityAttachmentService() {
        super();
    }

    public OpportunityAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OpportunityAttachment> getEntityClass() {
        return OpportunityAttachment.class;
    }

    public List<OpportunityAttachment> findByOpportunity(Opportunity opportunity) {
        return this.findByOpportunityId(opportunity.getId());
    }

    public List<OpportunityAttachment> findByOpportunityId(Long opportunityId) {
        return (List<OpportunityAttachment>) this.em
                .createQuery(
                        "select e from OpportunityAttachment e where e.opportunity.id = :pOpportunityId",
                        OpportunityAttachment.class)
                .setParameter("pOpportunityId", opportunityId).getResultList();
    }

}
