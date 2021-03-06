/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class BookmarkRtLovDsFilter extends AbstractTypeDsFilter {

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private Long parentId;

    private Long parentId_From;
    private Long parentId_To;

    private String parent;

    private String text;

    private String frame;

    private String bundle;

    private Boolean separatorBefore;

    private Boolean separatorAfter;

    private Boolean leaf;

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Long getParentId_From() {
        return this.parentId_From;
    }

    public Long getParentId_To() {
        return this.parentId_To;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setParentId_From(Long parentId_From) {
        this.parentId_From = parentId_From;
    }

    public void setParentId_To(Long parentId_To) {
        this.parentId_To = parentId_To;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrame() {
        return this.frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public Boolean getSeparatorBefore() {
        return this.separatorBefore;
    }

    public void setSeparatorBefore(Boolean separatorBefore) {
        this.separatorBefore = separatorBefore;
    }

    public Boolean getSeparatorAfter() {
        return this.separatorAfter;
    }

    public void setSeparatorAfter(Boolean separatorAfter) {
        this.separatorAfter = separatorAfter;
    }

    public Boolean getLeaf() {
        return this.leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

}
