/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class IssueLinkDsFilter extends AbstractAuditableDsFilter {

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
