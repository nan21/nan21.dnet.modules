/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class SalesOrderItemDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

    private Long salesOrderId;

    private Long salesOrderId_From;
    private Long salesOrderId_To;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String productName;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uomCode;

    private Float qtyOrdered;

    private Float qtyOrdered_From;
    private Float qtyOrdered_To;

    private Float netUnitPrice;

    private Float netUnitPrice_From;
    private Float netUnitPrice_To;

    private Float netAmount;

    private Float netAmount_From;
    private Float netAmount_To;

    private Long taxId;

    private Long taxId_From;
    private Long taxId_To;

    private String tax;

    private Float taxAmount;

    private Float taxAmount_From;
    private Float taxAmount_To;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getSalesOrderId() {
        return this.salesOrderId;
    }

    public Long getSalesOrderId_From() {
        return this.salesOrderId_From;
    }

    public Long getSalesOrderId_To() {
        return this.salesOrderId_To;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public void setSalesOrderId_From(Long salesOrderId_From) {
        this.salesOrderId_From = salesOrderId_From;
    }

    public void setSalesOrderId_To(Long salesOrderId_To) {
        this.salesOrderId_To = salesOrderId_To;
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

    public Long getUomId() {
        return this.uomId;
    }

    public Long getUomId_From() {
        return this.uomId_From;
    }

    public Long getUomId_To() {
        return this.uomId_To;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setUomId_From(Long uomId_From) {
        this.uomId_From = uomId_From;
    }

    public void setUomId_To(Long uomId_To) {
        this.uomId_To = uomId_To;
    }

    public String getUomCode() {
        return this.uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Float getQtyOrdered() {
        return this.qtyOrdered;
    }

    public Float getQtyOrdered_From() {
        return this.qtyOrdered_From;
    }

    public Float getQtyOrdered_To() {
        return this.qtyOrdered_To;
    }

    public void setQtyOrdered(Float qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public void setQtyOrdered_From(Float qtyOrdered_From) {
        this.qtyOrdered_From = qtyOrdered_From;
    }

    public void setQtyOrdered_To(Float qtyOrdered_To) {
        this.qtyOrdered_To = qtyOrdered_To;
    }

    public Float getNetUnitPrice() {
        return this.netUnitPrice;
    }

    public Float getNetUnitPrice_From() {
        return this.netUnitPrice_From;
    }

    public Float getNetUnitPrice_To() {
        return this.netUnitPrice_To;
    }

    public void setNetUnitPrice(Float netUnitPrice) {
        this.netUnitPrice = netUnitPrice;
    }

    public void setNetUnitPrice_From(Float netUnitPrice_From) {
        this.netUnitPrice_From = netUnitPrice_From;
    }

    public void setNetUnitPrice_To(Float netUnitPrice_To) {
        this.netUnitPrice_To = netUnitPrice_To;
    }

    public Float getNetAmount() {
        return this.netAmount;
    }

    public Float getNetAmount_From() {
        return this.netAmount_From;
    }

    public Float getNetAmount_To() {
        return this.netAmount_To;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public void setNetAmount_From(Float netAmount_From) {
        this.netAmount_From = netAmount_From;
    }

    public void setNetAmount_To(Float netAmount_To) {
        this.netAmount_To = netAmount_To;
    }

    public Long getTaxId() {
        return this.taxId;
    }

    public Long getTaxId_From() {
        return this.taxId_From;
    }

    public Long getTaxId_To() {
        return this.taxId_To;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public void setTaxId_From(Long taxId_From) {
        this.taxId_From = taxId_From;
    }

    public void setTaxId_To(Long taxId_To) {
        this.taxId_To = taxId_To;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public Float getTaxAmount() {
        return this.taxAmount;
    }

    public Float getTaxAmount_From() {
        return this.taxAmount_From;
    }

    public Float getTaxAmount_To() {
        return this.taxAmount_To;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTaxAmount_From(Float taxAmount_From) {
        this.taxAmount_From = taxAmount_From;
    }

    public void setTaxAmount_To(Float taxAmount_To) {
        this.taxAmount_To = taxAmount_To;
    }

}
