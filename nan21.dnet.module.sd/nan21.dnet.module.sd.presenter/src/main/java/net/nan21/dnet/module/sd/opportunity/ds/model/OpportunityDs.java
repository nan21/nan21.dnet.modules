/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Opportunity.class, sort = { @SortField(field = OpportunityDs.fNAME) })
public class OpportunityDs extends AbstractDsModel<Opportunity> implements
        IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fACTIVE = "active";
    public static final String fDESCRIPTION = "description";
    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fACCOUNTID = "accountId";
    public static final String fACCOUNT = "account";
    public static final String fEXPECTEDCLOSEDATE = "expectedCloseDate";
    public static final String fPROBABILITY = "probability";
    public static final String fEXPECTEDAMOUNT = "expectedAmount";
    public static final String fEXPECTEDCURRENCYID = "expectedCurrencyId";
    public static final String fEXPECTEDCURRENCY = "expectedCurrency";
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

    @DsField()
    private String name;

    @DsField()
    private Boolean active;

    @DsField()
    private String description;

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(join = "left", path = "account.id")
    private Long accountId;

    @DsField(join = "left", path = "account.name")
    private String account;

    @DsField()
    private Date expectedCloseDate;

    @DsField()
    private Float probability;

    @DsField()
    private Float expectedAmount;

    @DsField(join = "left", path = "expectedCurrency.id")
    private Long expectedCurrencyId;

    @DsField(join = "left", path = "expectedCurrency.code")
    private String expectedCurrency;

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public Date getExpectedCloseDate() {
        return this.expectedCloseDate;
    }

    public void setExpectedCloseDate(Date expectedCloseDate) {
        this.expectedCloseDate = expectedCloseDate;
    }

    public Float getProbability() {
        return this.probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Float getExpectedAmount() {
        return this.expectedAmount;
    }

    public void setExpectedAmount(Float expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public Long getExpectedCurrencyId() {
        return this.expectedCurrencyId;
    }

    public void setExpectedCurrencyId(Long expectedCurrencyId) {
        this.expectedCurrencyId = expectedCurrencyId;
    }

    public String getExpectedCurrency() {
        return this.expectedCurrency;
    }

    public void setExpectedCurrency(String expectedCurrency) {
        this.expectedCurrency = expectedCurrency;
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
