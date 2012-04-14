/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.pj.md.domain.entity.IssueText;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueText.class)
public class IssueTextDs extends AbstractAuditableDs<IssueText> {

    public static final String fISSUEID = "issueId";
    public static final String fISSUETEXTTYPEID = "issueTextTypeId";
    public static final String fISSUETEXTTYPE = "issueTextType";
    public static final String fCONTENT = "content";

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
