/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AttributeSetAttributeDsFilter extends AbstractAuditableDsFilter {

    private Long setId;

    private Long setId_From;
    private Long setId_To;

    private String set;

    private Long attributeId;

    private Long attributeId_From;
    private Long attributeId_To;

    private String attribute;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private Boolean inDescription;

    public Long getSetId() {
        return this.setId;
    }

    public Long getSetId_From() {
        return this.setId_From;
    }

    public Long getSetId_To() {
        return this.setId_To;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public void setSetId_From(Long setId_From) {
        this.setId_From = setId_From;
    }

    public void setSetId_To(Long setId_To) {
        this.setId_To = setId_To;
    }

    public String getSet() {
        return this.set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public Long getAttributeId() {
        return this.attributeId;
    }

    public Long getAttributeId_From() {
        return this.attributeId_From;
    }

    public Long getAttributeId_To() {
        return this.attributeId_To;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public void setAttributeId_From(Long attributeId_From) {
        this.attributeId_From = attributeId_From;
    }

    public void setAttributeId_To(Long attributeId_To) {
        this.attributeId_To = attributeId_To;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

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

    public Boolean getInDescription() {
        return this.inDescription;
    }

    public void setInDescription(Boolean inDescription) {
        this.inDescription = inDescription;
    }

}
