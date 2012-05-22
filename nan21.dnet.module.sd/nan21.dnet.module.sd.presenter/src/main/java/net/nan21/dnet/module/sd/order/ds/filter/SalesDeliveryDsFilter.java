/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SalesDeliveryDsFilter extends AbstractAuditableDsFilter {

    private String code;

    private String docNo;

    private Date docDate;

    private Date docDate_From;
    private Date docDate_To;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

    private Long customerId;

    private Long customerId_From;
    private Long customerId_To;

    private String customerCode;

    private String customer;

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

    private Long deliveryLocationId;

    private Long deliveryLocationId_From;
    private Long deliveryLocationId_To;

    private String deliveryLocation;

    private Long deliveryContactId;

    private Long deliveryContactId_From;
    private Long deliveryContactId_To;

    private String deliveryContact;

    private Boolean confirmed;

    private Boolean posted;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public Date getDocDate_From() {
        return this.docDate_From;
    }

    public Date getDocDate_To() {
        return this.docDate_To;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setDocDate_From(Date docDate_From) {
        this.docDate_From = docDate_From;
    }

    public void setDocDate_To(Date docDate_To) {
        this.docDate_To = docDate_To;
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

    public Long getDeliveryLocationId() {
        return this.deliveryLocationId;
    }

    public Long getDeliveryLocationId_From() {
        return this.deliveryLocationId_From;
    }

    public Long getDeliveryLocationId_To() {
        return this.deliveryLocationId_To;
    }

    public void setDeliveryLocationId(Long deliveryLocationId) {
        this.deliveryLocationId = deliveryLocationId;
    }

    public void setDeliveryLocationId_From(Long deliveryLocationId_From) {
        this.deliveryLocationId_From = deliveryLocationId_From;
    }

    public void setDeliveryLocationId_To(Long deliveryLocationId_To) {
        this.deliveryLocationId_To = deliveryLocationId_To;
    }

    public String getDeliveryLocation() {
        return this.deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Long getDeliveryContactId() {
        return this.deliveryContactId;
    }

    public Long getDeliveryContactId_From() {
        return this.deliveryContactId_From;
    }

    public Long getDeliveryContactId_To() {
        return this.deliveryContactId_To;
    }

    public void setDeliveryContactId(Long deliveryContactId) {
        this.deliveryContactId = deliveryContactId;
    }

    public void setDeliveryContactId_From(Long deliveryContactId_From) {
        this.deliveryContactId_From = deliveryContactId_From;
    }

    public void setDeliveryContactId_To(Long deliveryContactId_To) {
        this.deliveryContactId_To = deliveryContactId_To;
    }

    public String getDeliveryContact() {
        return this.deliveryContact;
    }

    public void setDeliveryContact(String deliveryContact) {
        this.deliveryContact = deliveryContact;
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
