/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;

import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityAttachment;

public interface IOpportunityAttachmentService extends
        IEntityService<OpportunityAttachment> {

    public List<OpportunityAttachment> findByOpportunity(Opportunity opportunity);

    public List<OpportunityAttachment> findByOpportunityId(Long opportunityId);

}
