/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SalesDeliveryDsFilter extends AbstractAuditableDsFilter {

    private Long customerId;

    private Long customerId_From;
    private Long customerId_To;

    private String customerCode;

    private String customer;

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    private Long salesOrderId;

    private Long salesOrderId_From;
    private Long salesOrderId_To;

    private String salesOrderUuid;

    private String salesOrder;

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

    private Boolean confirmed;

    private Boolean posted;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

    public Long getCustomerId() {
        return this.customerId;
    }

    public Long getCustomerId_From() {
        return this.customerId_From;
    }

    public Long getCustomerId_To() {
        return this.customerId_To;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerId_From(Long customerId_From) {
        this.customerId_From = customerId_From;
    }

    public void setCustomerId_To(Long customerId_To) {
        this.customerId_To = customerId_To;
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public String getSalesOrderUuid() {
        return this.salesOrderUuid;
    }

    public void setSalesOrderUuid(String salesOrderUuid) {
        this.salesOrderUuid = salesOrderUuid;
    }

    public String getSalesOrder() {
        return this.salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
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

}
