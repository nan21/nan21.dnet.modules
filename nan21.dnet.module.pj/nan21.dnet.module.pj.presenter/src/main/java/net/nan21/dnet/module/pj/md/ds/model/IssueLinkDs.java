/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = IssueLink.class)
public class IssueLinkDs extends AbstractAuditableDs<IssueLink> {

    public static final String fSOURCEISSUEID = "sourceIssueId";
    public static final String fSOURCEISSUE = "sourceIssue";
    public static final String fSOURCESUMMARY = "sourceSummary";
    public static final String fTARGETISSUEID = "targetIssueId";
    public static final String fTARGETISSUE = "targetIssue";
    public static final String fTARGETSUMMARY = "targetSummary";
    public static final String fLINKTYPEID = "linkTypeId";
    public static final String fLINKTYPE = "linkType";

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
