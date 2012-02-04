/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class OpportunityDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private String name;

    private Boolean active;

    private String description;

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

    private Long accountId;

    private Long accountId_From;
    private Long accountId_To;

    private String account;

    private Date closeDate;

    private Date closeDate_From;
    private Date closeDate_To;

    private Float probability;

    private Float probability_From;
    private Float probability_To;

    private Float amount;

    private Float amount_From;
    private Float amount_To;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currency;

    private Long statusId;

    private Long statusId_From;
    private Long statusId_To;

    private String status;

    private Long priorityId;

    private Long priorityId_From;
    private Long priorityId_To;

    private String priority;

    private Long salesStageId;

    private Long salesStageId_From;
    private Long salesStageId_To;

    private String salesStage;

    private Long leadSourceId;

    private Long leadSourceId_From;
    private Long leadSourceId_To;

    private String leadSource;

    private String campaign;

    private Long resultReasonId;

    private Long resultReasonId_From;
    private Long resultReasonId_To;

    private String resultReason;

    private String resultNote;

    private Long assignedToId;

    private Long assignedToId_From;
    private Long assignedToId_To;

    private String assignedTo;

    private String className;

    private String businessObject;

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

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public Long getAccountId_From() {
        return this.accountId_From;
    }

    public Long getAccountId_To() {
        return this.accountId_To;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAccountId_From(Long accountId_From) {
        this.accountId_From = accountId_From;
    }

    public void setAccountId_To(Long accountId_To) {
        this.accountId_To = accountId_To;
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

    public Date getCloseDate_From() {
        return this.closeDate_From;
    }

    public Date getCloseDate_To() {
        return this.closeDate_To;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public void setCloseDate_From(Date closeDate_From) {
        this.closeDate_From = closeDate_From;
    }

    public void setCloseDate_To(Date closeDate_To) {
        this.closeDate_To = closeDate_To;
    }

    public Float getProbability() {
        return this.probability;
    }

    public Float getProbability_From() {
        return this.probability_From;
    }

    public Float getProbability_To() {
        return this.probability_To;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public void setProbability_From(Float probability_From) {
        this.probability_From = probability_From;
    }

    public void setProbability_To(Float probability_To) {
        this.probability_To = probability_To;
    }

    public Float getAmount() {
        return this.amount;
    }

    public Float getAmount_From() {
        return this.amount_From;
    }

    public Float getAmount_To() {
        return this.amount_To;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setAmount_From(Float amount_From) {
        this.amount_From = amount_From;
    }

    public void setAmount_To(Float amount_To) {
        this.amount_To = amount_To;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public Long getCurrencyId_From() {
        return this.currencyId_From;
    }

    public Long getCurrencyId_To() {
        return this.currencyId_To;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyId_From(Long currencyId_From) {
        this.currencyId_From = currencyId_From;
    }

    public void setCurrencyId_To(Long currencyId_To) {
        this.currencyId_To = currencyId_To;
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

    public Long getStatusId_From() {
        return this.statusId_From;
    }

    public Long getStatusId_To() {
        return this.statusId_To;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setStatusId_From(Long statusId_From) {
        this.statusId_From = statusId_From;
    }

    public void setStatusId_To(Long statusId_To) {
        this.statusId_To = statusId_To;
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

    public Long getPriorityId_From() {
        return this.priorityId_From;
    }

    public Long getPriorityId_To() {
        return this.priorityId_To;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public void setPriorityId_From(Long priorityId_From) {
        this.priorityId_From = priorityId_From;
    }

    public void setPriorityId_To(Long priorityId_To) {
        this.priorityId_To = priorityId_To;
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

    public Long getSalesStageId_From() {
        return this.salesStageId_From;
    }

    public Long getSalesStageId_To() {
        return this.salesStageId_To;
    }

    public void setSalesStageId(Long salesStageId) {
        this.salesStageId = salesStageId;
    }

    public void setSalesStageId_From(Long salesStageId_From) {
        this.salesStageId_From = salesStageId_From;
    }

    public void setSalesStageId_To(Long salesStageId_To) {
        this.salesStageId_To = salesStageId_To;
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

    public Long getLeadSourceId_From() {
        return this.leadSourceId_From;
    }

    public Long getLeadSourceId_To() {
        return this.leadSourceId_To;
    }

    public void setLeadSourceId(Long leadSourceId) {
        this.leadSourceId = leadSourceId;
    }

    public void setLeadSourceId_From(Long leadSourceId_From) {
        this.leadSourceId_From = leadSourceId_From;
    }

    public void setLeadSourceId_To(Long leadSourceId_To) {
        this.leadSourceId_To = leadSourceId_To;
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

    public Long getResultReasonId_From() {
        return this.resultReasonId_From;
    }

    public Long getResultReasonId_To() {
        return this.resultReasonId_To;
    }

    public void setResultReasonId(Long resultReasonId) {
        this.resultReasonId = resultReasonId;
    }

    public void setResultReasonId_From(Long resultReasonId_From) {
        this.resultReasonId_From = resultReasonId_From;
    }

    public void setResultReasonId_To(Long resultReasonId_To) {
        this.resultReasonId_To = resultReasonId_To;
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

    public Long getAssignedToId_From() {
        return this.assignedToId_From;
    }

    public Long getAssignedToId_To() {
        return this.assignedToId_To;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public void setAssignedToId_From(Long assignedToId_From) {
        this.assignedToId_From = assignedToId_From;
    }

    public void setAssignedToId_To(Long assignedToId_To) {
        this.assignedToId_To = assignedToId_To;
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
