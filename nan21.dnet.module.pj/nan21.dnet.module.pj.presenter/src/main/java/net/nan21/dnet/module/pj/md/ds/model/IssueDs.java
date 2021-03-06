/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

@Ds(entity = Issue.class, sort = { @SortField(field = IssueDs.fMODIFIEDAT, desc = true) })
public class IssueDs extends AbstractAuditableDs<Issue> {

    public static final String fPROJECTID = "projectId";
    public static final String fPROJECT = "project";
    public static final String fPROJECTNAME = "projectName";
    public static final String fCODE = "code";
    public static final String fSUMMARY = "summary";
    public static final String fDESCRIPTION = "description";
    public static final String fBUSINESSVALUE = "businessValue";
    public static final String fESTIMATEDEFFORT = "estimatedEffort";
    public static final String fCLARITY = "clarity";
    public static final String fDUEDATE = "dueDate";
    public static final String fRESOLUTIONDATE = "resolutionDate";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUS = "status";
    public static final String fPRIORITYID = "priorityId";
    public static final String fPRIORITY = "priority";
    public static final String fRESOLUTIONID = "resolutionId";
    public static final String fRESOLUTION = "resolution";
    public static final String fSEVERITYID = "severityId";
    public static final String fSEVERITY = "severity";
    public static final String fASSIGNEEID = "assigneeId";
    public static final String fASSIGNEE = "assignee";
    public static final String fASSIGNEEROLEID = "assigneeRoleId";
    public static final String fASSIGNEEROLE = "assigneeRole";
    public static final String fREPORTEDVERSIONID = "reportedVersionId";
    public static final String fREPORTEDVERSION = "reportedVersion";
    public static final String fTARGETVERSIONID = "targetVersionId";
    public static final String fTARGETVERSION = "targetVersion";
    public static final String fFIXEDINVERSIONID = "fixedInVersionId";
    public static final String fFIXEDINVERSION = "fixedInVersion";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField(noUpdate = true, join = "left", path = "project.id")
    private Long projectId;

    @DsField(noUpdate = true, join = "left", path = "project.code")
    private String project;

    @DsField(noUpdate = true, join = "left", path = "project.name")
    private String projectName;

    @DsField(noUpdate = true)
    private String code;

    @DsField()
    private String summary;

    @DsField()
    private String description;

    @DsField()
    private Integer businessValue;

    @DsField()
    private Integer estimatedEffort;

    @DsField()
    private Integer clarity;

    @DsField()
    private Date dueDate;

    @DsField()
    private Date resolutionDate;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String status;

    @DsField(join = "left", path = "priority.id")
    private Long priorityId;

    @DsField(join = "left", path = "priority.name")
    private String priority;

    @DsField(join = "left", path = "resolution.id")
    private Long resolutionId;

    @DsField(join = "left", path = "resolution.name")
    private String resolution;

    @DsField(join = "left", path = "severity.id")
    private Long severityId;

    @DsField(join = "left", path = "severity.name")
    private String severity;

    @DsField(join = "left", path = "assignee.id")
    private Long assigneeId;

    @DsField(join = "left", path = "assignee.member.name")
    private String assignee;

    @DsField(join = "left", path = "assigneeRole.id")
    private Long assigneeRoleId;

    @DsField(join = "left", path = "assigneeRole.name")
    private String assigneeRole;

    @DsField(join = "left", path = "reportedVersion.id")
    private Long reportedVersionId;

    @DsField(join = "left", path = "reportedVersion.name")
    private String reportedVersion;

    @DsField(join = "left", path = "targetVersion.id")
    private Long targetVersionId;

    @DsField(join = "left", path = "targetVersion.name")
    private String targetVersion;

    @DsField(join = "left", path = "fixedInVersion.id")
    private Long fixedInVersionId;

    @DsField(join = "left", path = "fixedInVersion.name")
    private String fixedInVersion;

    @DsField(fetch = false)
    private String businessObject;

    public IssueDs() {
        super();
    }

    public IssueDs(Issue e) {
        super(e);
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public Integer getBusinessValue() {
        return this.businessValue;
    }

    public void setBusinessValue(Integer businessValue) {
        this.businessValue = businessValue;
    }

    public Integer getEstimatedEffort() {
        return this.estimatedEffort;
    }

    public void setEstimatedEffort(Integer estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public Integer getClarity() {
        return this.clarity;
    }

    public void setClarity(Integer clarity) {
        this.clarity = clarity;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getResolutionDate() {
        return this.resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public Long getResolutionId() {
        return this.resolutionId;
    }

    public void setResolutionId(Long resolutionId) {
        this.resolutionId = resolutionId;
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

    public void setSeverityId(Long severityId) {
        this.severityId = severityId;
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

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
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

    public void setAssigneeRoleId(Long assigneeRoleId) {
        this.assigneeRoleId = assigneeRoleId;
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

    public void setReportedVersionId(Long reportedVersionId) {
        this.reportedVersionId = reportedVersionId;
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

    public void setTargetVersionId(Long targetVersionId) {
        this.targetVersionId = targetVersionId;
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

    public void setFixedInVersionId(Long fixedInVersionId) {
        this.fixedInVersionId = fixedInVersionId;
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
