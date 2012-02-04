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

public class ProjectVersionDsFilter extends AbstractDsFilter implements
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

    private Long projectId;

    private Long projectId_From;
    private Long projectId_To;

    private String project;

    private String projectName;

    private Date planDate;

    private Date planDate_From;
    private Date planDate_To;

    private Date releaseDate;

    private Date releaseDate_From;
    private Date releaseDate_To;

    private Long projectVersionId;

    private Long projectVersionId_From;
    private Long projectVersionId_To;

    private String projectVersion;

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

    public Date getPlanDate() {
        return this.planDate;
    }

    public Date getPlanDate_From() {
        return this.planDate_From;
    }

    public Date getPlanDate_To() {
        return this.planDate_To;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public void setPlanDate_From(Date planDate_From) {
        this.planDate_From = planDate_From;
    }

    public void setPlanDate_To(Date planDate_To) {
        this.planDate_To = planDate_To;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public Date getReleaseDate_From() {
        return this.releaseDate_From;
    }

    public Date getReleaseDate_To() {
        return this.releaseDate_To;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseDate_From(Date releaseDate_From) {
        this.releaseDate_From = releaseDate_From;
    }

    public void setReleaseDate_To(Date releaseDate_To) {
        this.releaseDate_To = releaseDate_To;
    }

    public Long getProjectVersionId() {
        return this.projectVersionId;
    }

    public Long getProjectVersionId_From() {
        return this.projectVersionId_From;
    }

    public Long getProjectVersionId_To() {
        return this.projectVersionId_To;
    }

    public void setProjectVersionId(Long projectVersionId) {
        this.projectVersionId = projectVersionId;
    }

    public void setProjectVersionId_From(Long projectVersionId_From) {
        this.projectVersionId_From = projectVersionId_From;
    }

    public void setProjectVersionId_To(Long projectVersionId_To) {
        this.projectVersionId_To = projectVersionId_To;
    }

    public String getProjectVersion() {
        return this.projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

}
