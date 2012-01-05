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

public class IssueTextDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long issueId;

    private Long issueId_From;
    private Long issueId_To;

    private Long issueTextTypeId;

    private Long issueTextTypeId_From;
    private Long issueTextTypeId_To;

    private String issueTextType;

    private String content;

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
