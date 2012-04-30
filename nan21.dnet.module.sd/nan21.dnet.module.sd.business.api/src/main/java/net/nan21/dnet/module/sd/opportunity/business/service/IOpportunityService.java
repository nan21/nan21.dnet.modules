/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;

public interface IOpportunityService extends IEntityService<Opportunity> {

    public List<Opportunity> findByAccount(BusinessPartner account);

    public List<Opportunity> findByAccountId(Long accountId);

    public List<Opportunity> findByExpectedCurrency(Currency expectedCurrency);

    public List<Opportunity> findByExpectedCurrencyId(Long expectedCurrencyId);

    public List<Opportunity> findBySalesStage(OpportunityStage salesStage);

    public List<Opportunity> findBySalesStageId(Long salesStageId);

    public List<Opportunity> findByStatus(OpportunityStatus status);

    public List<Opportunity> findByStatusId(Long statusId);

    public List<Opportunity> findByPriority(OpportunityPriority priority);

    public List<Opportunity> findByPriorityId(Long priorityId);

    public List<Opportunity> findByLeadSource(OpportunitySource leadSource);

    public List<Opportunity> findByLeadSourceId(Long leadSourceId);

    public List<Opportunity> findByResultReason(
            OpportunityResultReason resultReason);

    public List<Opportunity> findByResultReasonId(Long resultReasonId);

    public List<Opportunity> findByAssignedTo(Assignable assignedTo);

    public List<Opportunity> findByAssignedToId(Long assignedToId);

}
