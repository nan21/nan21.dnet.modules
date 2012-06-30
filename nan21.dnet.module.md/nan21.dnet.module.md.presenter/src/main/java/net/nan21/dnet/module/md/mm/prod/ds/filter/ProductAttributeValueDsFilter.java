/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProductAttributeValueDsFilter extends AbstractAuditableDsFilter {

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String productName;

    private Long setId;

    private Long setId_From;
    private Long setId_To;

    private String set;

    private Long attributeId;

    private Long attributeId_From;
    private Long attributeId_To;

    private String attribute;

    private String title;

    private String dataType;

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    private String uom;

    private String listOfvalues;

    private String value;

    public Long getProductId() {
        return this.productId;
    }

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
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

    public Long getCategoryId_From() {
        return this.categoryId_From;
    }

    public Long getCategoryId_To() {
        return this.categoryId_To;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryId_From(Long categoryId_From) {
        this.categoryId_From = categoryId_From;
    }

    public void setCategoryId_To(Long categoryId_To) {
        this.categoryId_To = categoryId_To;
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
