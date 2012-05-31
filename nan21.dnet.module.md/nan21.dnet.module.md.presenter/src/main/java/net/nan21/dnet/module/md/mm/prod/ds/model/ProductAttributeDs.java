/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import javax.persistence.QueryHint;
import net.nan21.dnet.core.api.annotation.DsQueryHints;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import org.eclipse.persistence.config.QueryHints;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttribute.class)
@DsQueryHints({
        @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.product.attributeGroup"),
        @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.groupAttribute.attribute.type"),
        @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.groupAttribute.attribute.uom") })
public class ProductAttributeDs extends AbstractAuditableDs<ProductAttribute> {

    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fGROUPID = "groupId";
    public static final String fGROUP = "group";
    public static final String fGROUPATTRIBUTEID = "groupAttributeId";
    public static final String fATTRIBUTEID = "attributeId";
    public static final String fATTRIBUTE = "attribute";
    public static final String fTITLE = "title";
    public static final String fDATATYPE = "dataType";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fUOM = "uom";
    public static final String fLISTOFVALUES = "listOfvalues";
    public static final String fVALUE = "value";

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField(join = "left", path = "product.attributeGroup.id")
    private Long groupId;

    @DsField(join = "left", path = "product.attributeGroup.name")
    private String group;

    @DsField(join = "left", path = "groupAttribute.id")
    private Long groupAttributeId;

    @DsField(join = "left", path = "groupAttribute.attribute.id")
    private Long attributeId;

    @DsField(join = "left", path = "groupAttribute.attribute.name")
    private String attribute;

    @DsField(join = "left", path = "groupAttribute.attribute.title")
    private String title;

    @DsField(join = "left", path = "groupAttribute.attribute.dataType")
    private String dataType;

    @DsField(join = "left", path = "groupAttribute.attribute.type.id")
    private Long typeId;

    @DsField(join = "left", path = "groupAttribute.attribute.type.name")
    private String type;

    @DsField(join = "left", path = "groupAttribute.attribute.uom.code")
    private String uom;

    @DsField(join = "left", path = "groupAttribute.attribute.listOfvalues")
    private String listOfvalues;

    @DsField()
    private String value;

    public ProductAttributeDs() {
        super();
    }

    public ProductAttributeDs(ProductAttribute e) {
        super(e);
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Long getGroupAttributeId() {
        return this.groupAttributeId;
    }

    public void setGroupAttributeId(Long groupAttributeId) {
        this.groupAttributeId = groupAttributeId;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getListOfvalues() {
        return this.listOfvalues;
    }

    public void setListOfvalues(String listOfvalues) {
        this.listOfvalues = listOfvalues;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
