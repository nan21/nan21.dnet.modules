/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.base.elem.domain.entity.ElementValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ElementValue.class, sort = { @SortField(field = ElementValueDs.fSEQUENCENO) })
public class ElementValueDs extends AbstractAuditableDs<ElementValue> {

    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDATATYPE = "dataType";
    public static final String fVALUE = "value";

    @DsField(join = "left", path = "element.id")
    private Long elementId;

    @DsField(join = "left", path = "element.code")
    private String element;

    @DsField(join = "left", path = "element.name")
    private String elementName;

    @DsField(join = "left", path = "element.sequenceNo")
    private Integer sequenceNo;

    @DsField(join = "left", path = "element.dataType")
    private String dataType;

    @DsField()
    private String value;

    public ElementValueDs() {
        super();
    }

    public ElementValueDs(ElementValue e) {
        super(e);
    }

    public Long getElementId() {
        return this.elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
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

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
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
