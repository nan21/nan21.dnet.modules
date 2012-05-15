/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class IssueChangelogDsFilter extends AbstractAuditableDsFilter {

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

    private Date fixedInVersionDate;

    private Date fixedInVersionDate_From;
    private Date fixedInVersionDate_To;

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

    public Date getFixedInVersionDate() {
        return this.fixedInVersionDate;
    }

    public Date getFixedInVersionDate_From() {
        return this.fixedInVersionDate_From;
    }

    public Date getFixedInVersionDate_To() {
        return this.fixedInVersionDate_To;
    }

    public void setFixedInVersionDate(Date fixedInVersionDate) {
        this.fixedInVersionDate = fixedInVersionDate;
    }

    public void setFixedInVersionDate_From(Date fixedInVersionDate_From) {
        this.fixedInVersionDate_From = fixedInVersionDate_From;
    }

    public void setFixedInVersionDate_To(Date fixedInVersionDate_To) {
        this.fixedInVersionDate_To = fixedInVersionDate_To;
    }

}
