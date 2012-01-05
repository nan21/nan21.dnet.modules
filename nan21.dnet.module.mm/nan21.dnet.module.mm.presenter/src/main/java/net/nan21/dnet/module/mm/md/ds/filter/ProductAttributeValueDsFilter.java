/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ProductAttributeValueDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String productName;

    private Long groupId;

    private Long groupId_From;
    private Long groupId_To;

    private String group;

    private Long groupAttributeId;

    private Long groupAttributeId_From;
    private Long groupAttributeId_To;

    private Long attributeId;

    private Long attributeId_From;
    private Long attributeId_To;

    private String attribute;

    private String title;

    private String dataType;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private String uom;

    private String listOfvalues;

    private String value;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

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

    public Long getGroupId() {
        return this.groupId;
    }

    public Long getGroupId_From() {
        return this.groupId_From;
    }

    public Long getGroupId_To() {
        return this.groupId_To;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupId_From(Long groupId_From) {
        this.groupId_From = groupId_From;
    }

    public void setGroupId_To(Long groupId_To) {
        this.groupId_To = groupId_To;
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

    public Long getGroupAttributeId_From() {
        return this.groupAttributeId_From;
    }

    public Long getGroupAttributeId_To() {
        return this.groupAttributeId_To;
    }

    public void setGroupAttributeId(Long groupAttributeId) {
        this.groupAttributeId = groupAttributeId;
    }

    public void setGroupAttributeId_From(Long groupAttributeId_From) {
        this.groupAttributeId_From = groupAttributeId_From;
    }

    public void setGroupAttributeId_To(Long groupAttributeId_To) {
        this.groupAttributeId_To = groupAttributeId_To;
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

    public Long getTypeId() {
        return this.typeId;
    }

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
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
