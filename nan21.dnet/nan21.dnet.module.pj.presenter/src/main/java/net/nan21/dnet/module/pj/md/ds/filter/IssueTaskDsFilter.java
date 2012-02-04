/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class IssueTaskDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

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

    private String summary;

    private String description;

    private Long issueId;

    private Long issueId_From;
    private Long issueId_To;

    private String issueUuId;

    private String issue;

    private String issueSummary;

    private Long issuePriorityId;

    private Long issuePriorityId_From;
    private Long issuePriorityId_To;

    private String issuePriority;

    private Long issueTypeId;

    private Long issueTypeId_From;
    private Long issueTypeId_To;

    private String issueType;

    private Long issueStatusId;

    private Long issueStatusId_From;
    private Long issueStatusId_To;

    private String issueStatus;

    private Long issueSeverityId;

    private Long issueSeverityId_From;
    private Long issueSeverityId_To;

    private String issueSeverity;

    private Integer issuePrioritySequenceNo;

    private Integer issuePrioritySequenceNo_From;
    private Integer issuePrioritySequenceNo_To;

    private String issueBusinessObject;

    private String issueClassName;

    private Long projectId;

    private Long projectId_From;
    private Long projectId_To;

    private String project;

    private String projectName;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Long statusId;

    private Long statusId_From;
    private Long statusId_To;

    private String status;

    private Long assigneeId;

    private Long assigneeId_From;
    private Long assigneeId_To;

    private String assignee;

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

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIssueId() {
        return this.issueId;
    }

    public Long getIssueId_From() {
        return this.issueId_From;
    }

    public Long getIssueId_To() {
        return this.issueId_To;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public void setIssueId_From(Long issueId_From) {
        this.issueId_From = issueId_From;
    }

    public void setIssueId_To(Long issueId_To) {
        this.issueId_To = issueId_To;
    }

    public String getIssueUuId() {
        return this.issueUuId;
    }

    public void setIssueUuId(String issueUuId) {
        this.issueUuId = issueUuId;
    }

    public String getIssue() {
        return this.issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getIssueSummary() {
        return this.issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    public Long getIssuePriorityId() {
        return this.issuePriorityId;
    }

    public Long getIssuePriorityId_From() {
        return this.issuePriorityId_From;
    }

    public Long getIssuePriorityId_To() {
        return this.issuePriorityId_To;
    }

    public void setIssuePriorityId(Long issuePriorityId) {
        this.issuePriorityId = issuePriorityId;
    }

    public void setIssuePriorityId_From(Long issuePriorityId_From) {
        this.issuePriorityId_From = issuePriorityId_From;
    }

    public void setIssuePriorityId_To(Long issuePriorityId_To) {
        this.issuePriorityId_To = issuePriorityId_To;
    }

    public String getIssuePriority() {
        return this.issuePriority;
    }

    public void setIssuePriority(String issuePriority) {
        this.issuePriority = issuePriority;
    }

    public Long getIssueTypeId() {
        return this.issueTypeId;
    }

    public Long getIssueTypeId_From() {
        return this.issueTypeId_From;
    }

    public Long getIssueTypeId_To() {
        return this.issueTypeId_To;
    }

    public void setIssueTypeId(Long issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public void setIssueTypeId_From(Long issueTypeId_From) {
        this.issueTypeId_From = issueTypeId_From;
    }

    public void setIssueTypeId_To(Long issueTypeId_To) {
        this.issueTypeId_To = issueTypeId_To;
    }

    public String getIssueType() {
        return this.issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public Long getIssueStatusId() {
        return this.issueStatusId;
    }

    public Long getIssueStatusId_From() {
        return this.issueStatusId_From;
    }

    public Long getIssueStatusId_To() {
        return this.issueStatusId_To;
    }

    public void setIssueStatusId(Long issueStatusId) {
        this.issueStatusId = issueStatusId;
    }

    public void setIssueStatusId_From(Long issueStatusId_From) {
        this.issueStatusId_From = issueStatusId_From;
    }

    public void setIssueStatusId_To(Long issueStatusId_To) {
        this.issueStatusId_To = issueStatusId_To;
    }

    public String getIssueStatus() {
        return this.issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Long getIssueSeverityId() {
        return this.issueSeverityId;
    }

    public Long getIssueSeverityId_From() {
        return this.issueSeverityId_From;
    }

    public Long getIssueSeverityId_To() {
        return this.issueSeverityId_To;
    }

    public void setIssueSeverityId(Long issueSeverityId) {
        this.issueSeverityId = issueSeverityId;
    }

    public void setIssueSeverityId_From(Long issueSeverityId_From) {
        this.issueSeverityId_From = issueSeverityId_From;
    }

    public void setIssueSeverityId_To(Long issueSeverityId_To) {
        this.issueSeverityId_To = issueSeverityId_To;
    }

    public String getIssueSeverity() {
        return this.issueSeverity;
    }

    public void setIssueSeverity(String issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

    public Integer getIssuePrioritySequenceNo() {
        return this.issuePrioritySequenceNo;
    }

    public Integer getIssuePrioritySequenceNo_From() {
        return this.issuePrioritySequenceNo_From;
    }

    public Integer getIssuePrioritySequenceNo_To() {
        return this.issuePrioritySequenceNo_To;
    }

    public void setIssuePrioritySequenceNo(Integer issuePrioritySequenceNo) {
        this.issuePrioritySequenceNo = issuePrioritySequenceNo;
    }

    public void setIssuePrioritySequenceNo_From(
            Integer issuePrioritySequenceNo_From) {
        this.issuePrioritySequenceNo_From = issuePrioritySequenceNo_From;
    }

    public void setIssuePrioritySequenceNo_To(Integer issuePrioritySequenceNo_To) {
        this.issuePrioritySequenceNo_To = issuePrioritySequenceNo_To;
    }

    public String getIssueBusinessObject() {
        return this.issueBusinessObject;
    }

    public void setIssueBusinessObject(String issueBusinessObject) {
        this.issueBusinessObject = issueBusinessObject;
    }

    public String getIssueClassName() {
        return this.issueClassName;
    }

    public void setIssueClassName(String issueClassName) {
        this.issueClassName = issueClassName;
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public Long getProjectId_From() {
        return this.projectId_From;
    }

    public Long getProjectId_To() {
        return this.projectId_To;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setProjectId_From(Long projectId_From) {
        this.projectId_From = projectId_From;
    }

    public void setProjectId_To(Long projectId_To) {
        this.projectId_To = projectId_To;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getAssigneeId() {
        return this.assigneeId;
    }

    public Long getAssigneeId_From() {
        return this.assigneeId_From;
    }

    public Long getAssigneeId_To() {
        return this.assigneeId_To;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public void setAssigneeId_From(Long assigneeId_From) {
        this.assigneeId_From = assigneeId_From;
    }

    public void setAssigneeId_To(Long assigneeId_To) {
        this.assigneeId_To = assigneeId_To;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

}
