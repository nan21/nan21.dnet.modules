/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ElementValueDsFilter extends AbstractAuditableDsFilter {

    private Long elementId;

    private Long elementId_From;
    private Long elementId_To;

    private String element;

    private String elementName;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String dataType;

    private String value;

    public Long getElementId() {
        return this.elementId;
    }

    public Long getElementId_From() {
        return this.elementId_From;
    }

    public Long getElementId_To() {
        return this.elementId_To;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public void setElementId_From(Long elementId_From) {
        this.elementId_From = elementId_From;
    }

    public void setElementId_To(Long elementId_To) {
        this.elementId_To = elementId_To;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
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

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
