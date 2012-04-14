/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PurchaseInvoice.class)
public class PurchaseInvoiceDs extends AbstractAuditableDs<PurchaseInvoice> {

    public static final String fCODE = "code";
    public static final String fDOCDATE = "docDate";
    public static final String fCUSTOMERID = "customerId";
    public static final String fCUSTOMER = "customer";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIERUUID = "supplierUuid";
    public static final String fSUPPLIERCODE = "supplierCode";
    public static final String fSUPPLIER = "supplier";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";
    public static final String fPAYMENTTERMID = "paymentTermId";
    public static final String fPAYMENTTERM = "paymentTerm";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fTOTALNETAMOUNT = "totalNetAmount";
    public static final String fTOTALTAXAMOUNT = "totalTaxAmount";
    public static final String fTOTALAMOUNT = "totalAmount";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";
    public static final String fPURCHASEORDERID = "purchaseOrderId";
    public static final String fCLASSNAME = "className";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField()
    private String code;

    @DsField()
    private Date docDate;

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

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField(join = "left", path = "paymentMethod.id")
    private Long paymentMethodId;

    @DsField(join = "left", path = "paymentMethod.name")
    private String paymentMethod;

    @DsField(join = "left", path = "paymentTerm.id")
    private Long paymentTermId;

    @DsField(join = "left", path = "paymentTerm.name")
    private String paymentTerm;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField()
    private Float totalNetAmount;

    @DsField()
    private Float totalTaxAmount;

    @DsField()
    private Float totalAmount;

    @DsField()
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    @DsField(join = "left", path = "purchaseOrder.id")
    private Long purchaseOrderId;

    @DsField(fetch = false)
    private String className;

    @DsField(fetch = false)
    private String businessObject;

    public PurchaseInvoiceDs() {
        super();
    }

    public PurchaseInvoiceDs(PurchaseInvoice e) {
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

    public Float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
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

    public Long getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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
