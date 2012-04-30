/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityPriorityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityResultReasonService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunitySourceService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityStageService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityStatusService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;

public class OpportunityDsConv extends
        AbstractDsConverter<OpportunityDs, Opportunity> implements
        IDsConverter<OpportunityDs, Opportunity> {

    @Override
    protected void modelToEntityReferences(OpportunityDs ds, Opportunity e,
            boolean isInsert) throws Exception {

        if (ds.getAccountId() != null) {
            if (e.getAccount() == null
                    || !e.getAccount().getId().equals(ds.getAccountId())) {
                e.setAccount((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getAccountId()));
            }
        }

        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((OpportunityStatus) this.em.find(
                        OpportunityStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_OpportunityStatus(ds, e);
        }

        if (ds.getPriorityId() != null) {
            if (e.getPriority() == null
                    || !e.getPriority().getId().equals(ds.getPriorityId())) {
                e.setPriority((OpportunityPriority) this.em.find(
                        OpportunityPriority.class, ds.getPriorityId()));
            }
        } else {
            this.lookup_priority_OpportunityPriority(ds, e);
        }

        if (ds.getCurrencyId() != null) {
            if (e.getExpectedCurrency() == null
                    || !e.getExpectedCurrency().getId()
                            .equals(ds.getCurrencyId())) {
                e.setExpectedCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_expectedCurrency_Currency(ds, e);
        }

        if (ds.getSalesStageId() != null) {
            if (e.getSalesStage() == null
                    || !e.getSalesStage().getId().equals(ds.getSalesStageId())) {
                e.setSalesStage((OpportunityStage) this.em.find(
                        OpportunityStage.class, ds.getSalesStageId()));
            }
        } else {
            this.lookup_salesStage_OpportunityStage(ds, e);
        }

        if (ds.getLeadSourceId() != null) {
            if (e.getLeadSource() == null
                    || !e.getLeadSource().getId().equals(ds.getLeadSourceId())) {
                e.setLeadSource((OpportunitySource) this.em.find(
                        OpportunitySource.class, ds.getLeadSourceId()));
            }
        } else {
            this.lookup_leadSource_OpportunitySource(ds, e);
        }

        if (ds.getResultReasonId() != null) {
            if (e.getResultReason() == null
                    || !e.getResultReason().getId()
                            .equals(ds.getResultReasonId())) {
                e.setResultReason((OpportunityResultReason) this.em.find(
                        OpportunityResultReason.class, ds.getResultReasonId()));
            }
        } else {
            this.lookup_resultReason_OpportunityResultReason(ds, e);
        }

        if (ds.getAssignedToId() != null) {
            if (e.getAssignedTo() == null
                    || !e.getAssignedTo().getId().equals(ds.getAssignedToId())) {
                e.setAssignedTo((Assignable) this.em.find(Assignable.class,
                        ds.getAssignedToId()));
            }
        }

    }

    protected void lookup_status_OpportunityStatus(OpportunityDs ds,
            Opportunity e) throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            OpportunityStatus x = null;
            try {
                x = ((IOpportunityStatusService) findEntityService(OpportunityStatus.class))
                        .findByName(ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OpportunityStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);

        } else {
            e.setStatus(null);
        }
    }

    protected void lookup_priority_OpportunityPriority(OpportunityDs ds,
            Opportunity e) throws Exception {
        if (ds.getPriority() != null && !ds.getPriority().equals("")) {
            OpportunityPriority x = null;
            try {
                x = ((IOpportunityPriorityService) findEntityService(OpportunityPriority.class))
                        .findByName(ds.getPriority());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OpportunityPriority` reference:  `priority` = "
                                + ds.getPriority() + "  ");
            }
            e.setPriority(x);

        } else {
            e.setPriority(null);
        }
    }

    protected void lookup_expectedCurrency_Currency(OpportunityDs ds,
            Opportunity e) throws Exception {
        if (ds.getCurrency() != null && !ds.getCurrency().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getCurrency());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Currency` reference:  `currency` = "
                                + ds.getCurrency() + "  ");
            }
            e.setExpectedCurrency(x);

        } else {
            e.setExpectedCurrency(null);
        }
    }

    protected void lookup_salesStage_OpportunityStage(OpportunityDs ds,
            Opportunity e) throws Exception {
        if (ds.getSalesStage() != null && !ds.getSalesStage().equals("")) {
            OpportunityStage x = null;
            try {
                x = ((IOpportunityStageService) findEntityService(OpportunityStage.class))
                        .findByName(ds.getSalesStage());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OpportunityStage` reference:  `salesStage` = "
                                + ds.getSalesStage() + "  ");
            }
            e.setSalesStage(x);

        } else {
            e.setSalesStage(null);
        }
    }

    protected void lookup_leadSource_OpportunitySource(OpportunityDs ds,
            Opportunity e) throws Exception {
        if (ds.getLeadSource() != null && !ds.getLeadSource().equals("")) {
            OpportunitySource x = null;
            try {
                x = ((IOpportunitySourceService) findEntityService(OpportunitySource.class))
                        .findByName(ds.getLeadSource());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OpportunitySource` reference:  `leadSource` = "
                                + ds.getLeadSource() + "  ");
            }
            e.setLeadSource(x);

        } else {
            e.setLeadSource(null);
        }
    }

    protected void lookup_resultReason_OpportunityResultReason(
            OpportunityDs ds, Opportunity e) throws Exception {
        if (ds.getResultReason() != null && !ds.getResultReason().equals("")) {
            OpportunityResultReason x = null;
            try {
                x = ((IOpportunityResultReasonService) findEntityService(OpportunityResultReason.class))
                        .findByName(ds.getResultReason());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OpportunityResultReason` reference:  `resultReason` = "
                                + ds.getResultReason() + "  ");
            }
            e.setResultReason(x);

        } else {
            e.setResultReason(null);
        }
    }

}
