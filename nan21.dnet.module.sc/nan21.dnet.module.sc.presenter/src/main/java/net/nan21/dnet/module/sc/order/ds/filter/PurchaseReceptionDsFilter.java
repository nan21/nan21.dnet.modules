/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PurchaseReceptionDsFilter extends AbstractAuditableDsFilter {

    private Long supplierId;

    private Long supplierId_From;
    private Long supplierId_To;

    private String supplierCode;

    private String supplier;

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    private Long purchaseOrderId;

    private Long purchaseOrderId_From;
    private Long purchaseOrderId_To;

    private String purchaseOrderUuid;

    private String purchaseOrder;

    private Long transactionTypeId;

    private Long transactionTypeId_From;
    private Long transactionTypeId_To;

    private String transactionType;

    private Long carrierId;

    private Long carrierId_From;
    private Long carrierId_To;

    private String carrier;

    private Long warehouseId;

    private Long warehouseId_From;
    private Long warehouseId_To;

    private String warehouse;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

    private Boolean confirmed;

    private Boolean posted;

    public Long getSupplierId() {
        return this.supplierId;
    }

    public Long getSupplierId_From() {
        return this.supplierId_From;
    }

    public Long getSupplierId_To() {
        return this.supplierId_To;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierId_From(Long supplierId_From) {
        this.supplierId_From = supplierId_From;
    }

    public void setSupplierId_To(Long supplierId_To) {
        this.supplierId_To = supplierId_To;
    }

    public String getSupplierCode() {
        return this.supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getDocTypeId() {
        return this.docTypeId;
    }

    public Long getDocTypeId_From() {
        return this.docTypeId_From;
    }

    public Long getDocTypeId_To() {
        return this.docTypeId_To;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public void setDocTypeId_From(Long docTypeId_From) {
        this.docTypeId_From = docTypeId_From;
    }

    public void setDocTypeId_To(Long docTypeId_To) {
        this.docTypeId_To = docTypeId_To;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Long getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public Long getPurchaseOrderId_From() {
        return this.purchaseOrderId_From;
    }

    public Long getPurchaseOrderId_To() {
        return this.purchaseOrderId_To;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public void setPurchaseOrderId_From(Long purchaseOrderId_From) {
        this.purchaseOrderId_From = purchaseOrderId_From;
    }

    public void setPurchaseOrderId_To(Long purchaseOrderId_To) {
        this.purchaseOrderId_To = purchaseOrderId_To;
    }

    public String getPurchaseOrderUuid() {
        return this.purchaseOrderUuid;
    }

    public void setPurchaseOrderUuid(String purchaseOrderUuid) {
        this.purchaseOrderUuid = purchaseOrderUuid;
    }

    public String getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Long getTransactionTypeId() {
        return this.transactionTypeId;
    }

    public Long getTransactionTypeId_From() {
        return this.transactionTypeId_From;
    }

    public Long getTransactionTypeId_To() {
        return this.transactionTypeId_To;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public void setTransactionTypeId_From(Long transactionTypeId_From) {
        this.transactionTypeId_From = transactionTypeId_From;
    }

    public void setTransactionTypeId_To(Long transactionTypeId_To) {
        this.transactionTypeId_To = transactionTypeId_To;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getCarrierId() {
        return this.carrierId;
    }

    public Long getCarrierId_From() {
        return this.carrierId_From;
    }

    public Long getCarrierId_To() {
        return this.carrierId_To;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public void setCarrierId_From(Long carrierId_From) {
        this.carrierId_From = carrierId_From;
    }

    public void setCarrierId_To(Long carrierId_To) {
        this.carrierId_To = carrierId_To;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Long getWarehouseId() {
        return this.warehouseId;
    }

    public Long getWarehouseId_From() {
        return this.warehouseId_From;
    }

    public Long getWarehouseId_To() {
        return this.warehouseId_To;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setWarehouseId_From(Long warehouseId_From) {
        this.warehouseId_From = warehouseId_From;
    }

    public void setWarehouseId_To(Long warehouseId_To) {
        this.warehouseId_To = warehouseId_To;
    }

    public String getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public Date getEventDate_From() {
        return this.eventDate_From;
    }

    public Date getEventDate_To() {
        return this.eventDate_To;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDate_From(Date eventDate_From) {
        this.eventDate_From = eventDate_From;
    }

    public void setEventDate_To(Date eventDate_To) {
        this.eventDate_To = eventDate_To;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

}
