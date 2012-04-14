/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroupAttribute;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttributeGroupAttribute.class)
public class ProductAttributeGroupAttributeDs extends
        AbstractAuditableDs<ProductAttributeGroupAttribute> {

    public static final String fGROUPID = "groupId";
    public static final String fGROUP = "group";
    public static final String fATTRIBUTEID = "attributeId";
    public static final String fATTRIBUTE = "attribute";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fINDESCRIPTION = "inDescription";

    @DsField(join = "left", path = "group.id")
    private Long groupId;

    @DsField(join = "left", path = "group.name")
    private String group;

    @DsField(join = "left", path = "attribute.id")
    private Long attributeId;

    @DsField(join = "left", path = "attribute.name")
    private String attribute;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private Boolean inDescription;

    public ProductAttributeGroupAttributeDs() {
        super();
    }

    public ProductAttributeGroupAttributeDs(ProductAttributeGroupAttribute e) {
        super(e);
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
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
