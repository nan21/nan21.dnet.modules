/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class IssueTextDsFilter extends AbstractAuditableDsFilter {

    private Long issueId;

    private Long issueId_From;
    private Long issueId_To;

    private Long issueTextTypeId;

    private Long issueTextTypeId_From;
    private Long issueTextTypeId_To;

    private String issueTextType;

    private String content;

    public Long getIssueId() {
        return this.issueId;
    }

    public Long getIssueId_From() {
        return this.issueId_From;
    }

    public Long getIssueId_To() {
        return this.issueId_To;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public void setIssueId_From(Long issueId_From) {
        this.issueId_From = issueId_From;
    }

    public void setIssueId_To(Long issueId_To) {
        this.issueId_To = issueId_To;
    }

    public Long getIssueTextTypeId() {
        return this.issueTextTypeId;
    }

    public Long getIssueTextTypeId_From() {
        return this.issueTextTypeId_From;
    }

    public Long getIssueTextTypeId_To() {
        return this.issueTextTypeId_To;
    }

    public void setIssueTextTypeId(Long issueTextTypeId) {
        this.issueTextTypeId = issueTextTypeId;
    }

    public void setIssueTextTypeId_From(Long issueTextTypeId_From) {
        this.issueTextTypeId_From = issueTextTypeId_From;
    }

    public void setIssueTextTypeId_To(Long issueTextTypeId_To) {
        this.issueTextTypeId_To = issueTextTypeId_To;
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
