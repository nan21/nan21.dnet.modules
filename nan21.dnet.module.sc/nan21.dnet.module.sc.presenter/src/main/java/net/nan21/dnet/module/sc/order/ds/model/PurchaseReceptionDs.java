/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;

@Ds(entity = PurchaseInventoryTransaction.class)
public class PurchaseReceptionDs extends
        AbstractAuditableDs<PurchaseInventoryTransaction> {

    public static final String fCODE = "code";
    public static final String fDOCNO = "docNo";
    public static final String fDOCDATE = "docDate";
    public static final String fEVENTDATE = "eventDate";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIERCODE = "supplierCode";
    public static final String fSUPPLIER = "supplier";
    public static final String fPURCHASEORDERID = "purchaseOrderId";
    public static final String fPURCHASEORDERUUID = "purchaseOrderUuid";
    public static final String fPURCHASEORDER = "purchaseOrder";
    public static final String fTRANSACTIONTYPEID = "transactionTypeId";
    public static final String fTRANSACTIONTYPE = "transactionType";
    public static final String fCARRIERID = "carrierId";
    public static final String fCARRIER = "carrier";
    public static final String fWAREHOUSEID = "warehouseId";
    public static final String fWAREHOUSE = "warehouse";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";

    @DsField()
    private String code;

    @DsField()
    private String docNo;

    @DsField()
    private Date docDate;

    @DsField()
    private Date eventDate;

    @DsField(join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(noUpdate = true, join = "left", path = "supplier.code")
    private String supplierCode;

    @DsField(noUpdate = true, join = "left", path = "supplier.name")
    private String supplier;

    @DsField(join = "left", path = "purchaseOrder.id")
    private Long purchaseOrderId;

    @DsField(join = "left", path = "purchaseOrder.uuid")
    private String purchaseOrderUuid;

    @DsField(join = "left", path = "purchaseOrder.code")
    private String purchaseOrder;

    @DsField(join = "left", path = "transactionType.id")
    private Long transactionTypeId;

    @DsField(join = "left", path = "transactionType.name")
    private String transactionType;

    @DsField(join = "left", path = "fromInventory.id")
    private Long carrierId;

    @DsField(join = "left", path = "fromInventory.code")
    private String carrier;

    @DsField(join = "left", path = "toInventory.id")
    private Long warehouseId;

    @DsField(join = "left", path = "toInventory.code")
    private String warehouse;

    @DsField()
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    public PurchaseReceptionDs() {
        super();
    }

    public PurchaseReceptionDs(PurchaseInventoryTransaction e) {
        super(e);
    }

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

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Long getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public Long getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

}
