/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import javax.persistence.QueryHint;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.DsQueryHints;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;
import org.eclipse.persistence.config.QueryHints;

@Ds(entity = ProductAttributeValue.class)
@DsQueryHints({ @QueryHint(name = QueryHints.LEFT_FETCH, value = "e.product.attributeSet") })
public class ProductAttributeValueDs extends
        AbstractAuditableDs<ProductAttributeValue> {

    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fSETID = "setId";
    public static final String fSET = "set";
    public static final String fATTRIBUTEID = "attributeId";
    public static final String fATTRIBUTE = "attribute";
    public static final String fTITLE = "title";
    public static final String fDATATYPE = "dataType";
    public static final String fCATEGORYID = "categoryId";
    public static final String fCATEGORY = "category";
    public static final String fUOM = "uom";
    public static final String fLISTOFVALUES = "listOfvalues";
    public static final String fVALUE = "value";

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField(join = "left", path = "product.attributeSet.id")
    private Long setId;

    @DsField(join = "left", path = "product.attributeSet.name")
    private String set;

    @DsField(join = "left", path = "attribute.id")
    private Long attributeId;

    @DsField(join = "left", path = "attribute.name")
    private String attribute;

    @DsField(join = "left", path = "attribute.title")
    private String title;

    @DsField(join = "left", path = "attribute.dataType")
    private String dataType;

    @DsField(join = "left", path = "attribute.category.id")
    private Long categoryId;

    @DsField(join = "left", path = "attribute.category.name")
    private String category;

    @DsField(join = "left", path = "attribute.uom.code")
    private String uom;

    @DsField(join = "left", path = "attribute.listOfvalues")
    private String listOfvalues;

    @DsField()
    private String value;

    public ProductAttributeValueDs() {
        super();
    }

    public ProductAttributeValueDs(ProductAttributeValue e) {
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

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
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
