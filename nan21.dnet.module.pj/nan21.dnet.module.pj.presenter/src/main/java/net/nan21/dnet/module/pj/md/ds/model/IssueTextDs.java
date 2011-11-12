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

import net.nan21.dnet.module.pj.md.domain.entity.IssueText;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueText.class)
public class IssueTextDs extends AbstractDsModel<IssueText> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fISSUEID = "issueId";
    public static final String fISSUETEXTTYPEID = "issueTextTypeId";
    public static final String fISSUETEXTTYPE = "issueTextType";
    public static final String fCONTENT = "content";

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

    @DsField(join = "left", path = "issue.id")
    private Long issueId;

    @DsField(join = "left", path = "issueTextType.id")
    private Long issueTextTypeId;

    @DsField(join = "left", path = "issueTextType.name")
    private String issueTextType;

    @DsField()
    private String content;

    public IssueTextDs() {
        super();
    }

    public IssueTextDs(IssueText e) {
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

    public Long getIssueId() {
        return this.issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getIssueTextTypeId() {
        return this.issueTextTypeId;
    }

    public void setIssueTextTypeId(Long issueTextTypeId) {
        this.issueTextTypeId = issueTextTypeId;
    }

    public String getIssueTextType() {
        return this.issueTextType;
    }

    public void setIssueTextType(String issueTextType) {
        this.issueTextType = issueTextType;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
