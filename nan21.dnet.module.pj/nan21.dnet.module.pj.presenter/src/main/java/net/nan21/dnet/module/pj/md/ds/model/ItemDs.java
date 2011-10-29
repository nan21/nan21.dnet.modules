/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Item.class)
public class ItemDs extends AbstractDsModel<Item> implements IModelWithId,
        IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fPROJECTID = "projectId";
    public static final String fPROJECTCODE = "projectCode";
    public static final String fPROJECT = "project";
    public static final String fINSTANCETYPE = "instanceType";
    public static final String fSUMMARY = "summary";
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

    @DsField(join = "left", path = "project.id")
    private Long projectId;

    @DsField(join = "left", path = "project.code")
    private String projectCode;

    @DsField(join = "left", path = "project.name")
    private String project;

    @DsField()
    private String instanceType;

    @DsField()
    private String summary;

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

    @DsField(join = "left", path = "assignee.name")
    private String assignee;

    @DsField(join = "left", path = "assigneeRole.id")
    private Long assigneeRoleId;

    @DsField(join = "left", path = "assigneeRole.name")
    private String assigneeRole;

    public ItemDs() {
        super();
    }

    public ItemDs(Item e) {
        super(e);
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

    public Long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

}
