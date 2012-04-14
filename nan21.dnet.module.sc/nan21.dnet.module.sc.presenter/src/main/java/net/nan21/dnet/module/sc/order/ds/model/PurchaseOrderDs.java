/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PurchaseOrder.class)
public class PurchaseOrderDs extends AbstractAuditableDs<PurchaseOrder> {

    public static final String fCODE = "code";
    public static final String fDOCDATE = "docDate";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fCUSTOMERID = "customerId";
    public static final String fCUSTOMER = "customer";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIERUUID = "supplierUuid";
    public static final String fSUPPLIERCODE = "supplierCode";
    public static final String fSUPPLIER = "supplier";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fPRICELISTID = "priceListId";
    public static final String fPRICELIST = "priceList";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";
    public static final String fPAYMENTTERMID = "paymentTermId";
    public static final String fPAYMENTTERM = "paymentTerm";
    public static final String fDELIVERYMETHODID = "deliveryMethodId";
    public static final String fDELIVERYMETHOD = "deliveryMethod";
    public static final String fINVENTORYID = "inventoryId";
    public static final String fINVENTORY = "inventory";
    public static final String fPLANNEDDELIVERYDATE = "plannedDeliveryDate";
    public static final String fDELIVERYNOTES = "deliveryNotes";
    public static final String fTOTALAMOUNT = "totalAmount";
    public static final String fTOTALNETAMOUNT = "totalNetAmount";
    public static final String fTOTALTAXAMOUNT = "totalTaxAmount";
    public static final String fCONFIRMED = "confirmed";
    public static final String fCLASSNAME = "className";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField()
    private String code;

    @DsField(noUpdate = true)
    private Date docDate;

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField(noUpdate = true, join = "left", path = "customer.id")
    private Long customerId;

    @DsField(noUpdate = true, join = "left", path = "customer.code")
    private String customer;

    @DsField(noUpdate = true, join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(noUpdate = true, join = "left", path = "supplier.uuid")
    private String supplierUuid;

    @DsField(noUpdate = true, join = "left", path = "supplier.code")
    private String supplierCode;

    @DsField(noUpdate = true, join = "left", path = "supplier.name")
    private String supplier;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField(join = "left", path = "priceList.id")
    private Long priceListId;

    @DsField(join = "left", path = "priceList.name")
    private String priceList;

    @DsField(join = "left", path = "paymentMethod.id")
    private Long paymentMethodId;

    @DsField(join = "left", path = "paymentMethod.name")
    private String paymentMethod;

    @DsField(join = "left", path = "paymentTerm.id")
    private Long paymentTermId;

    @DsField(join = "left", path = "paymentTerm.name")
    private String paymentTerm;

    @DsField(join = "left", path = "deliveryMethod.id")
    private Long deliveryMethodId;

    @DsField(join = "left", path = "deliveryMethod.name")
    private String deliveryMethod;

    @DsField(join = "left", path = "inventory.id")
    private Long inventoryId;

    @DsField(join = "left", path = "inventory.code")
    private String inventory;

    @DsField()
    private Date plannedDeliveryDate;

    @DsField()
    private String deliveryNotes;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalNetAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalTaxAmount;

    @DsField()
    private Boolean confirmed;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private String className;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private String businessObject;

    public PurchaseOrderDs() {
        super();
    }

    public PurchaseOrderDs(PurchaseOrder e) {
        super(e);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
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

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierUuid() {
        return this.supplierUuid;
    }

    public void setSupplierUuid(String supplierUuid) {
        this.supplierUuid = supplierUuid;
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

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getPriceListId() {
        return this.priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public String getPriceList() {
        return this.priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public Long getPaymentMethodId() {
        return this.paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getPaymentTermId() {
        return this.paymentTermId;
    }

    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public String getPaymentTerm() {
        return this.paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public Long getDeliveryMethodId() {
        return this.deliveryMethodId;
    }

    public void setDeliveryMethodId(Long deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    public String getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public Date getPlannedDeliveryDate() {
        return this.plannedDeliveryDate;
    }

    public void setPlannedDeliveryDate(Date plannedDeliveryDate) {
        this.plannedDeliveryDate = plannedDeliveryDate;
    }

    public String getDeliveryNotes() {
        return this.deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public Float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public void setTotalNetAmount(Float totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    public Float getTotalTaxAmount() {
        return this.totalTaxAmount;
    }

    public void setTotalTaxAmount(Float totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

}
