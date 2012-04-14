/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Issue.class, jpqlWhere = "e.fixedInVersion.id is not null", sort = {
        @SortField(field = IssueChangelogDs.fFIXEDINVERSIONDATE, desc = true),
        @SortField(field = IssueChangelogDs.fFIXEDINVERSION),
        @SortField(field = IssueChangelogDs.fMODIFIEDAT, desc = true) })
public class IssueChangelogDs extends AbstractAuditableDs<Issue> {

    public static final String fPROJECTID = "projectId";
    public static final String fPROJECT = "project";
    public static final String fPROJECTNAME = "projectName";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUS = "status";
    public static final String fCODE = "code";
    public static final String fSUMMARY = "summary";
    public static final String fTARGETVERSIONID = "targetVersionId";
    public static final String fTARGETVERSION = "targetVersion";
    public static final String fTARGETVERSIONDATE = "targetVersionDate";
    public static final String fFIXEDINVERSIONID = "fixedInVersionId";
    public static final String fFIXEDINVERSION = "fixedInVersion";
    public static final String fFIXEDINVERSIONDATE = "fixedInVersionDate";

    @DsField(join = "left", path = "project.id")
    private Long projectId;

    @DsField(join = "left", path = "project.code")
    private String project;

    @DsField(join = "left", path = "project.name")
    private String projectName;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String status;

    @DsField()
    private String code;

    @DsField()
    private String summary;

    @DsField(join = "left", path = "targetVersion.id")
    private Long targetVersionId;

    @DsField(join = "left", path = "targetVersion.name")
    private String targetVersion;

    @DsField(join = "left", path = "targetVersion.planDate")
    private Date targetVersionDate;

    @DsField(join = "left", path = "fixedInVersion.id")
    private Long fixedInVersionId;

    @DsField(join = "left", path = "fixedInVersion.name")
    private String fixedInVersion;

    @DsField(join = "left", path = "fixedInVersion.planDate")
    private Date fixedInVersionDate;

    public IssueChangelogDs() {
        super();
    }

    public IssueChangelogDs(Issue e) {
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

    public void setTargetVersionId(Long targetVersionId) {
        this.targetVersionId = targetVersionId;
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

    public void setTargetVersionDate(Date targetVersionDate) {
        this.targetVersionDate = targetVersionDate;
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

    public Date getFixedInVersionDate() {
        return this.fixedInVersionDate;
    }

    public void setFixedInVersionDate(Date fixedInVersionDate) {
        this.fixedInVersionDate = fixedInVersionDate;
    }

}
