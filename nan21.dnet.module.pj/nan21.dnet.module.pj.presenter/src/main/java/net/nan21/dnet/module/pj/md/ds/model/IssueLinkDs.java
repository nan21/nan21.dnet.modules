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

import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueLink.class)
public class IssueLinkDs extends AbstractDsModel<IssueLink> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fSOURCEISSUEID = "sourceIssueId";
    public static final String fSOURCEISSUE = "sourceIssue";
    public static final String fSOURCESUMMARY = "sourceSummary";
    public static final String fTARGETISSUEID = "targetIssueId";
    public static final String fTARGETISSUE = "targetIssue";
    public static final String fTARGETSUMMARY = "targetSummary";
    public static final String fLINKTYPEID = "linkTypeId";
    public static final String fLINKTYPE = "linkType";

    @DsField(noUpdate = true)
    private Long id;

    @DsField(noUpdate = true)
    private String uuid;

    @DsField(noUpdate = true)
    private Long clientId;

    @DsField(noUpdate = true)
    private Date createdAt;

    @DsField(noUpdate = true)
    private Date modifiedAt;

    @DsField(noUpdate = true)
    private String createdBy;

    @DsField(noUpdate = true)
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(noUpdate = true, fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", jpqlFilter = " ( e.sourceIssue.id = :sourceIssueId or e.targetIssue.id = :sourceIssueId )  ", path = "sourceIssue.id")
    private Long sourceIssueId;

    @DsField(join = "left", path = "sourceIssue.code")
    private String sourceIssue;

    @DsField(join = "left", path = "sourceIssue.summary")
    private String sourceSummary;

    @DsField(join = "left", path = "targetIssue.id")
    private Long targetIssueId;

    @DsField(join = "left", path = "targetIssue.code")
    private String targetIssue;

    @DsField(join = "left", path = "targetIssue.summary")
    private String targetSummary;

    @DsField(join = "left", path = "linkType.id")
    private Long linkTypeId;

    @DsField(join = "left", path = "linkType.name")
    private String linkType;

    public IssueLinkDs() {
        super();
    }

    public IssueLinkDs(IssueLink e) {
        super(e);
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getSourceIssueId() {
        return this.sourceIssueId;
    }

    public void setSourceIssueId(Long sourceIssueId) {
        this.sourceIssueId = sourceIssueId;
    }

    public String getSourceIssue() {
        return this.sourceIssue;
    }

    public void setSourceIssue(String sourceIssue) {
        this.sourceIssue = sourceIssue;
    }

    public String getSourceSummary() {
        return this.sourceSummary;
    }

    public void setSourceSummary(String sourceSummary) {
        this.sourceSummary = sourceSummary;
    }

    public Long getTargetIssueId() {
        return this.targetIssueId;
    }

    public void setTargetIssueId(Long targetIssueId) {
        this.targetIssueId = targetIssueId;
    }

    public String getTargetIssue() {
        return this.targetIssue;
    }

    public void setTargetIssue(String targetIssue) {
        this.targetIssue = targetIssue;
    }

    public String getTargetSummary() {
        return this.targetSummary;
    }

    public void setTargetSummary(String targetSummary) {
        this.targetSummary = targetSummary;
    }

    public Long getLinkTypeId() {
        return this.linkTypeId;
    }

    public void setLinkTypeId(Long linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

}
