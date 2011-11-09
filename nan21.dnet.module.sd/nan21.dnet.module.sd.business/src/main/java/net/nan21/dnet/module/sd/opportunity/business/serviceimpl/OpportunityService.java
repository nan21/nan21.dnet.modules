/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;

public class OpportunityService extends AbstractEntityService<Opportunity>
        implements IOpportunityService {

    public OpportunityService() {
        super();
    }

    public OpportunityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Opportunity> getEntityClass() {
        return Opportunity.class;
    }

    public List<Opportunity> findByAccount(BusinessPartner account) {
        return this.findByAccountId(account.getId());
    }

    public List<Opportunity> findByAccountId(Long accountId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.account.id = :pAccountId",
                        Opportunity.class)
                .setParameter("pAccountId", accountId).getResultList();
    }

    public List<Opportunity> findByExpectedCurrency(Currency expectedCurrency) {
        return this.findByExpectedCurrencyId(expectedCurrency.getId());
    }

    public List<Opportunity> findByExpectedCurrencyId(Long expectedCurrencyId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.expectedCurrency.id = :pExpectedCurrencyId",
                        Opportunity.class)
                .setParameter("pExpectedCurrencyId", expectedCurrencyId)
                .getResultList();
    }

    public List<Opportunity> findBySalesStage(OpportunityStage salesStage) {
        return this.findBySalesStageId(salesStage.getId());
    }

    public List<Opportunity> findBySalesStageId(Long salesStageId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.salesStage.id = :pSalesStageId",
                        Opportunity.class)
                .setParameter("pSalesStageId", salesStageId).getResultList();
    }

    public List<Opportunity> findByStatus(OpportunityStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<Opportunity> findByStatusId(Long statusId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.status.id = :pStatusId",
                        Opportunity.class).setParameter("pStatusId", statusId)
                .getResultList();
    }

    public List<Opportunity> findByPriority(OpportunityPriority priority) {
        return this.findByPriorityId(priority.getId());
    }

    public List<Opportunity> findByPriorityId(Long priorityId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.priority.id = :pPriorityId",
                        Opportunity.class)
                .setParameter("pPriorityId", priorityId).getResultList();
    }

    public List<Opportunity> findByLeadSource(OpportunitySource leadSource) {
        return this.findByLeadSourceId(leadSource.getId());
    }

    public List<Opportunity> findByLeadSourceId(Long leadSourceId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.leadSource.id = :pLeadSourceId",
                        Opportunity.class)
                .setParameter("pLeadSourceId", leadSourceId).getResultList();
    }

    public List<Opportunity> findByResultReason(
            OpportunityResultReason resultReason) {
        return this.findByResultReasonId(resultReason.getId());
    }

    public List<Opportunity> findByResultReasonId(Long resultReasonId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.resultReason.id = :pResultReasonId",
                        Opportunity.class)
                .setParameter("pResultReasonId", resultReasonId)
                .getResultList();
    }

    public List<Opportunity> findByAssignedTo(Assignable assignedTo) {
        return this.findByAssignedToId(assignedTo.getId());
    }

    public List<Opportunity> findByAssignedToId(Long assignedToId) {
        return (List<Opportunity>) this.em
                .createQuery(
                        "select e from Opportunity e where e.assignedTo.id = :pAssignedToId",
                        Opportunity.class)
                .setParameter("pAssignedToId", assignedToId).getResultList();
    }

}
