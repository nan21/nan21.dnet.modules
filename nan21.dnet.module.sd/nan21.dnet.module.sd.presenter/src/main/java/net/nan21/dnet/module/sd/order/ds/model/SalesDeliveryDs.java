/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesInventoryTransaction.class)
public class SalesDeliveryDs extends
        AbstractAuditableDs<SalesInventoryTransaction> {

    public static final String fCUSTOMERID = "customerId";
    public static final String fCUSTOMERCODE = "customerCode";
    public static final String fCUSTOMER = "customer";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fSALESORDERID = "salesOrderId";
    public static final String fSALESORDERUUID = "salesOrderUuid";
    public static final String fSALESORDER = "salesOrder";
    public static final String fTRANSACTIONTYPEID = "transactionTypeId";
    public static final String fTRANSACTIONTYPE = "transactionType";
    public static final String fCARRIERID = "carrierId";
    public static final String fCARRIER = "carrier";
    public static final String fWAREHOUSEID = "warehouseId";
    public static final String fWAREHOUSE = "warehouse";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";
    public static final String fEVENTDATE = "eventDate";

    @DsField(join = "left", path = "customer.id")
    private Long customerId;

    @DsField(noUpdate = true, join = "left", path = "customer.code")
    private String customerCode;

    @DsField(noUpdate = true, join = "left", path = "customer.name")
    private String customer;

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField(join = "left", path = "salesOrder.id")
    private Long salesOrderId;

    @DsField(join = "left", path = "salesOrder.uuid")
    private String salesOrderUuid;

    @DsField(join = "left", path = "salesOrder.code")
    private String salesOrder;

    @DsField(join = "left", path = "transactionType.id")
    private Long transactionTypeId;

    @DsField(join = "left", path = "transactionType.name")
    private String transactionType;

    @DsField(join = "left", path = "toInventory.id")
    private Long carrierId;

    @DsField(join = "left", path = "toInventory.code")
    private String carrier;

    @DsField(join = "left", path = "fromInventory.id")
    private Long warehouseId;

    @DsField(join = "left", path = "fromInventory.code")
    private String warehouse;

    @DsField()
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    @DsField()
    private Date eventDate;

    public SalesDeliveryDs() {
        super();
    }

    public SalesDeliveryDs(SalesInventoryTransaction e) {
        super(e);
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
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

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
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

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
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

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
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

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

}
