/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AttributeSetAttribute.class)
public class AttributeSetAttributeDs extends
        AbstractAuditableDs<AttributeSetAttribute> {

    public static final String fSETID = "setId";
    public static final String fSET = "set";
    public static final String fATTRIBUTEID = "attributeId";
    public static final String fATTRIBUTE = "attribute";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fINDESCRIPTION = "inDescription";

    @DsField(join = "left", path = "attributeSet.id")
    private Long setId;

    @DsField(join = "left", path = "attributeSet.name")
    private String set;

    @DsField(join = "left", path = "attribute.id")
    private Long attributeId;

    @DsField(join = "left", path = "attribute.name")
    private String attribute;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private Boolean inDescription;

    public AttributeSetAttributeDs() {
        super();
    }

    public AttributeSetAttributeDs(AttributeSetAttribute e) {
        super(e);
    }

    public Long getSetId() {
        return this.setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
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

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
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

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Boolean getInDescription() {
        return this.inDescription;
    }

    public void setInDescription(Boolean inDescription) {
        this.inDescription = inDescription;
    }

}
