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

public class IssueLinkDsFilter extends AbstractDsFilter implements
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

    private Long sourceIssueId;

    private Long sourceIssueId_From;
    private Long sourceIssueId_To;

    private String sourceIssue;

    private String sourceSummary;

    private Long targetIssueId;

    private Long targetIssueId_From;
    private Long targetIssueId_To;

    private String targetIssue;

    private String targetSummary;

    private Long linkTypeId;

    private Long linkTypeId_From;
    private Long linkTypeId_To;

    private String linkType;

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

    public Long getSourceIssueId() {
        return this.sourceIssueId;
    }

    public Long getSourceIssueId_From() {
        return this.sourceIssueId_From;
    }

    public Long getSourceIssueId_To() {
        return this.sourceIssueId_To;
    }

    public void setSourceIssueId(Long sourceIssueId) {
        this.sourceIssueId = sourceIssueId;
    }

    public void setSourceIssueId_From(Long sourceIssueId_From) {
        this.sourceIssueId_From = sourceIssueId_From;
    }

    public void setSourceIssueId_To(Long sourceIssueId_To) {
        this.sourceIssueId_To = sourceIssueId_To;
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

    public Long getTargetIssueId_From() {
        return this.targetIssueId_From;
    }

    public Long getTargetIssueId_To() {
        return this.targetIssueId_To;
    }

    public void setTargetIssueId(Long targetIssueId) {
        this.targetIssueId = targetIssueId;
    }

    public void setTargetIssueId_From(Long targetIssueId_From) {
        this.targetIssueId_From = targetIssueId_From;
    }

    public void setTargetIssueId_To(Long targetIssueId_To) {
        this.targetIssueId_To = targetIssueId_To;
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

    public Long getLinkTypeId_From() {
        return this.linkTypeId_From;
    }

    public Long getLinkTypeId_To() {
        return this.linkTypeId_To;
    }

    public void setLinkTypeId(Long linkTypeId) {
        this.linkTypeId = linkTypeId;
    }

    public void setLinkTypeId_From(Long linkTypeId_From) {
        this.linkTypeId_From = linkTypeId_From;
    }

    public void setLinkTypeId_To(Long linkTypeId_To) {
        this.linkTypeId_To = linkTypeId_To;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

}
