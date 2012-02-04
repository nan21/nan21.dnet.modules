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

public class IssueDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

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

    private Long projectId;

    private Long projectId_From;
    private Long projectId_To;

    private String project;

    private String projectName;

    private String code;

    private String summary;

    private String description;

    private Date dueDate;

    private Date dueDate_From;
    private Date dueDate_To;

    private Date resolutionDate;

    private Date resolutionDate_From;
    private Date resolutionDate_To;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Long statusId;

    private Long statusId_From;
    private Long statusId_To;

    private String status;

    private Long priorityId;

    private Long priorityId_From;
    private Long priorityId_To;

    private String priority;

    private Long resolutionId;

    private Long resolutionId_From;
    private Long resolutionId_To;

    private String resolution;

    private Long severityId;

    private Long severityId_From;
    private Long severityId_To;

    private String severity;

    private Long assigneeId;

    private Long assigneeId_From;
    private Long assigneeId_To;

    private String assignee;

    private Long assigneeRoleId;

    private Long assigneeRoleId_From;
    private Long assigneeRoleId_To;

    private String assigneeRole;

    private Long reportedVersionId;

    private Long reportedVersionId_From;
    private Long reportedVersionId_To;

    private String reportedVersion;

    private Long targetVersionId;

    private Long targetVersionId_From;
    private Long targetVersionId_To;

    private String targetVersion;

    private Long fixedInVersionId;

    private Long fixedInVersionId_From;
    private Long fixedInVersionId_To;

    private String fixedInVersion;

    private String businessObject;

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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getDueDate() {
        return this.dueDate;
    }

    public Date getDueDate_From() {
        return this.dueDate_From;
    }

    public Date getDueDate_To() {
        return this.dueDate_To;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDueDate_From(Date dueDate_From) {
        this.dueDate_From = dueDate_From;
    }

    public void setDueDate_To(Date dueDate_To) {
        this.dueDate_To = dueDate_To;
    }

    public Date getResolutionDate() {
        return this.resolutionDate;
    }

    public Date getResolutionDate_From() {
        return this.resolutionDate_From;
    }

    public Date getResolutionDate_To() {
        return this.resolutionDate_To;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public void setResolutionDate_From(Date resolutionDate_From) {
        this.resolutionDate_From = resolutionDate_From;
    }

    public void setResolutionDate_To(Date resolutionDate_To) {
        this.resolutionDate_To = resolutionDate_To;
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

    public Long getResolutionId() {
        return this.resolutionId;
    }

    public Long getResolutionId_From() {
        return this.resolutionId_From;
    }

    public Long getResolutionId_To() {
        return this.resolutionId_To;
    }

    public void setResolutionId(Long resolutionId) {
        this.resolutionId = resolutionId;
    }

    public void setResolutionId_From(Long resolutionId_From) {
        this.resolutionId_From = resolutionId_From;
    }

    public void setResolutionId_To(Long resolutionId_To) {
        this.resolutionId_To = resolutionId_To;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Long getSeverityId() {
        return this.severityId;
    }

    public Long getSeverityId_From() {
        return this.severityId_From;
    }

    public Long getSeverityId_To() {
        return this.severityId_To;
    }

    public void setSeverityId(Long severityId) {
        this.severityId = severityId;
    }

    public void setSeverityId_From(Long severityId_From) {
        this.severityId_From = severityId_From;
    }

    public void setSeverityId_To(Long severityId_To) {
        this.severityId_To = severityId_To;
    }

    public String getSeverity() {
        return this.severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
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

    public Long getAssigneeRoleId() {
        return this.assigneeRoleId;
    }

    public Long getAssigneeRoleId_From() {
        return this.assigneeRoleId_From;
    }

    public Long getAssigneeRoleId_To() {
        return this.assigneeRoleId_To;
    }

    public void setAssigneeRoleId(Long assigneeRoleId) {
        this.assigneeRoleId = assigneeRoleId;
    }

    public void setAssigneeRoleId_From(Long assigneeRoleId_From) {
        this.assigneeRoleId_From = assigneeRoleId_From;
    }

    public void setAssigneeRoleId_To(Long assigneeRoleId_To) {
        this.assigneeRoleId_To = assigneeRoleId_To;
    }

    public String getAssigneeRole() {
        return this.assigneeRole;
    }

    public void setAssigneeRole(String assigneeRole) {
        this.assigneeRole = assigneeRole;
    }

    public Long getReportedVersionId() {
        return this.reportedVersionId;
    }

    public Long getReportedVersionId_From() {
        return this.reportedVersionId_From;
    }

    public Long getReportedVersionId_To() {
        return this.reportedVersionId_To;
    }

    public void setReportedVersionId(Long reportedVersionId) {
        this.reportedVersionId = reportedVersionId;
    }

    public void setReportedVersionId_From(Long reportedVersionId_From) {
        this.reportedVersionId_From = reportedVersionId_From;
    }

    public void setReportedVersionId_To(Long reportedVersionId_To) {
        this.reportedVersionId_To = reportedVersionId_To;
    }

    public String getReportedVersion() {
        return this.reportedVersion;
    }

    public void setReportedVersion(String reportedVersion) {
        this.reportedVersion = reportedVersion;
    }

    public Long getTargetVersionId() {
        return this.targetVersionId;
    }

    public Long getTargetVersionId_From() {
        return this.targetVersionId_From;
    }

    public Long getTargetVersionId_To() {
        return this.targetVersionId_To;
    }

    public void setTargetVersionId(Long targetVersionId) {
        this.targetVersionId = targetVersionId;
    }

    public void setTargetVersionId_From(Long targetVersionId_From) {
        this.targetVersionId_From = targetVersionId_From;
    }

    public void setTargetVersionId_To(Long targetVersionId_To) {
        this.targetVersionId_To = targetVersionId_To;
    }

    public String getTargetVersion() {
        return this.targetVersion;
    }

    public void setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion;
    }

    public Long getFixedInVersionId() {
        return this.fixedInVersionId;
    }

    public Long getFixedInVersionId_From() {
        return this.fixedInVersionId_From;
    }

    public Long getFixedInVersionId_To() {
        return this.fixedInVersionId_To;
    }

    public void setFixedInVersionId(Long fixedInVersionId) {
        this.fixedInVersionId = fixedInVersionId;
    }

    public void setFixedInVersionId_From(Long fixedInVersionId_From) {
        this.fixedInVersionId_From = fixedInVersionId_From;
    }

    public void setFixedInVersionId_To(Long fixedInVersionId_To) {
        this.fixedInVersionId_To = fixedInVersionId_To;
    }

    public String getFixedInVersion() {
        return this.fixedInVersion;
    }

    public void setFixedInVersion(String fixedInVersion) {
        this.fixedInVersion = fixedInVersion;
    }

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

}
