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

public class IssueRoadmapDsFilter extends AbstractDsFilter implements
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

    private String code;

    private String summary;

    private Long targetVersionId;

    private Long targetVersionId_From;
    private Long targetVersionId_To;

    private String targetVersion;

    private Date targetVersionDate;

    private Date targetVersionDate_From;
    private Date targetVersionDate_To;

    private Long fixedInVersionId;

    private Long fixedInVersionId_From;
    private Long fixedInVersionId_To;

    private String fixedInVersion;

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

    public Date getTargetVersionDate() {
        return this.targetVersionDate;
    }

    public Date getTargetVersionDate_From() {
        return this.targetVersionDate_From;
    }

    public Date getTargetVersionDate_To() {
        return this.targetVersionDate_To;
    }

    public void setTargetVersionDate(Date targetVersionDate) {
        this.targetVersionDate = targetVersionDate;
    }

    public void setTargetVersionDate_From(Date targetVersionDate_From) {
        this.targetVersionDate_From = targetVersionDate_From;
    }

    public void setTargetVersionDate_To(Date targetVersionDate_To) {
        this.targetVersionDate_To = targetVersionDate_To;
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

}
