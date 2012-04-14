/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Opportunity.class, sort = { @SortField(field = OpportunityDs.fNAME) })
public class OpportunityDs extends AbstractTypeDs<Opportunity> {

    public static final String fACCOUNTID = "accountId";
    public static final String fACCOUNT = "account";
    public static final String fCLOSEDATE = "closeDate";
    public static final String fPROBABILITY = "probability";
    public static final String fAMOUNT = "amount";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUS = "status";
    public static final String fPRIORITYID = "priorityId";
    public static final String fPRIORITY = "priority";
    public static final String fSALESSTAGEID = "salesStageId";
    public static final String fSALESSTAGE = "salesStage";
    public static final String fLEADSOURCEID = "leadSourceId";
    public static final String fLEADSOURCE = "leadSource";
    public static final String fCAMPAIGN = "campaign";
    public static final String fRESULTREASONID = "resultReasonId";
    public static final String fRESULTREASON = "resultReason";
    public static final String fRESULTNOTE = "resultNote";
    public static final String fASSIGNEDTOID = "assignedToId";
    public static final String fASSIGNEDTO = "assignedTo";
    public static final String fCLASSNAME = "className";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField(join = "left", path = "account.id")
    private Long accountId;

    @DsField(join = "left", path = "account.name")
    private String account;

    @DsField(path = "expectedCloseDate")
    private Date closeDate;

    @DsField()
    private Float probability;

    @DsField(path = "expectedAmount")
    private Float amount;

    @DsField(join = "left", path = "expectedCurrency.id")
    private Long currencyId;

    @DsField(join = "left", path = "expectedCurrency.code")
    private String currency;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String status;

    @DsField(join = "left", path = "priority.id")
    private Long priorityId;

    @DsField(join = "left", path = "priority.name")
    private String priority;

    @DsField(join = "left", path = "salesStage.id")
    private Long salesStageId;

    @DsField(join = "left", path = "salesStage.name")
    private String salesStage;

    @DsField(join = "left", path = "leadSource.id")
    private Long leadSourceId;

    @DsField(join = "left", path = "leadSource.name")
    private String leadSource;

    @DsField()
    private String campaign;

    @DsField(join = "left", path = "resultReason.id")
    private Long resultReasonId;

    @DsField(join = "left", path = "resultReason.name")
    private String resultReason;

    @DsField()
    private String resultNote;

    @DsField(join = "left", path = "assignedTo.id")
    private Long assignedToId;

    @DsField(join = "left", path = "assignedTo.name")
    private String assignedTo;

    @DsField(fetch = false)
    private String className;

    @DsField(fetch = false)
    private String businessObject;

    public OpportunityDs() {
        super();
    }

    public OpportunityDs(Opportunity e) {
        super(e);
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCloseDate() {
        return this.closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Float getProbability() {
        return this.probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getSalesStageId() {
        return this.salesStageId;
    }

    public void setSalesStageId(Long salesStageId) {
        this.salesStageId = salesStageId;
    }

    public String getSalesStage() {
        return this.salesStage;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public Long getLeadSourceId() {
        return this.leadSourceId;
    }

    public void setLeadSourceId(Long leadSourceId) {
        this.leadSourceId = leadSourceId;
    }

    public String getLeadSource() {
        return this.leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getCampaign() {
        return this.campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Long getResultReasonId() {
        return this.resultReasonId;
    }

    public void setResultReasonId(Long resultReasonId) {
        this.resultReasonId = resultReasonId;
    }

    public String getResultReason() {
        return this.resultReason;
    }

    public void setResultReason(String resultReason) {
        this.resultReason = resultReason;
    }

    public String getResultNote() {
        return this.resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    public Long getAssignedToId() {
        return this.assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

}
