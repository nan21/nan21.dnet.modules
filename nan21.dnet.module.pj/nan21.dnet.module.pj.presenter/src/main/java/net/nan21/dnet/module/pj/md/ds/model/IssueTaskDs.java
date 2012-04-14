/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.pj.md.domain.entity.IssueTask;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueTask.class)
public class IssueTaskDs extends AbstractAuditableDs<IssueTask> {

    public static final String fCODE = "code";
    public static final String fDESCRIPTION = "description";
    public static final String fISSUEID = "issueId";
    public static final String fISSUEUUID = "issueUuId";
    public static final String fISSUE = "issue";
    public static final String fISSUESUMMARY = "issueSummary";
    public static final String fISSUEPRIORITYID = "issuePriorityId";
    public static final String fISSUEPRIORITY = "issuePriority";
    public static final String fISSUETYPEID = "issueTypeId";
    public static final String fISSUETYPE = "issueType";
    public static final String fISSUESTATUSID = "issueStatusId";
    public static final String fISSUESTATUS = "issueStatus";
    public static final String fISSUESEVERITYID = "issueSeverityId";
    public static final String fISSUESEVERITY = "issueSeverity";
    public static final String fISSUEPRIORITYSEQUENCENO = "issuePrioritySequenceNo";
    public static final String fISSUEBUSINESSOBJECT = "issueBusinessObject";
    public static final String fISSUECLASSNAME = "issueClassName";
    public static final String fPROJECTID = "projectId";
    public static final String fPROJECT = "project";
    public static final String fPROJECTNAME = "projectName";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUS = "status";
    public static final String fASSIGNEEID = "assigneeId";
    public static final String fASSIGNEE = "assignee";

    @DsField()
    private String code;

    @DsField()
    private String description;

    @DsField(join = "left", path = "issue.id")
    private Long issueId;

    @DsField(join = "left", path = "issue.uuid")
    private String issueUuId;

    @DsField(join = "left", path = "issue.code")
    private String issue;

    @DsField(join = "left", path = "issue.summary")
    private String issueSummary;

    @DsField(join = "left", path = "issue.priority.id")
    private Long issuePriorityId;

    @DsField(join = "left", path = "issue.priority.name")
    private String issuePriority;

    @DsField(join = "left", path = "issue.type.id")
    private Long issueTypeId;

    @DsField(join = "left", path = "issue.type.name")
    private String issueType;

    @DsField(join = "left", path = "issue.status.id")
    private Long issueStatusId;

    @DsField(join = "left", path = "issue.status.name")
    private String issueStatus;

    @DsField(join = "left", path = "issue.severity.id")
    private Long issueSeverityId;

    @DsField(join = "left", path = "issue.severity.name")
    private String issueSeverity;

    @DsField(join = "left", path = "issue.priority.sequenceNo")
    private Integer issuePrioritySequenceNo;

    @DsField(join = "left", fetch = false, path = "issue.businessObject")
    private String issueBusinessObject;

    @DsField(join = "left", fetch = false, path = "issue.className")
    private String issueClassName;

    @DsField(join = "left", path = "issue.project.id")
    private Long projectId;

    @DsField(join = "left", path = "issue.project.code")
    private String project;

    @DsField(join = "left", path = "issue.project.name")
    private String projectName;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String status;

    @DsField(join = "left", path = "assignee.id")
    private Long assigneeId;

    @DsField(join = "left", path = "assignee.member.name")
    private String assignee;

    public IssueTaskDs() {
        super();
    }

    public IssueTaskDs(IssueTask e) {
        super(e);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
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

    public void setIssuePriorityId(Long issuePriorityId) {
        this.issuePriorityId = issuePriorityId;
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

    public void setIssueTypeId(Long issueTypeId) {
        this.issueTypeId = issueTypeId;
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

    public void setIssueStatusId(Long issueStatusId) {
        this.issueStatusId = issueStatusId;
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

    public void setIssueSeverityId(Long issueSeverityId) {
        this.issueSeverityId = issueSeverityId;
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

    public void setIssuePrioritySequenceNo(Integer issuePrioritySequenceNo) {
        this.issuePrioritySequenceNo = issuePrioritySequenceNo;
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

}
