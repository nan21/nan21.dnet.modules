/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesInvoice.class)
public class SalesInvoiceDs extends AbstractAuditableDs<SalesInvoice> {

    public static final String fCODE = "code";
    public static final String fDOCNO = "docNo";
    public static final String fDOCDATE = "docDate";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIER = "supplier";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fDESCRIPTION = "description";
    public static final String fCUSTOMERID = "customerId";
    public static final String fCUSTOMERUUID = "customerUuid";
    public static final String fCUSTOMERCODE = "customerCode";
    public static final String fCUSTOMER = "customer";
    public static final String fPRICELISTID = "priceListId";
    public static final String fPRICELIST = "priceList";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";
    public static final String fPAYMENTTERMID = "paymentTermId";
    public static final String fPAYMENTTERM = "paymentTerm";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fTOTALNETAMOUNT = "totalNetAmount";
    public static final String fTOTALTAXAMOUNT = "totalTaxAmount";
    public static final String fTOTALAMOUNT = "totalAmount";
    public static final String fBILLTOLOCATIONID = "billToLocationId";
    public static final String fBILLTOLOCATION = "billToLocation";
    public static final String fBILLTOCONTACTID = "billToContactId";
    public static final String fBILLTOCONTACT = "billToContact";
    public static final String fSALESORDERID = "salesOrderId";
    public static final String fSALESORDERCODE = "salesOrderCode";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";
    public static final String fCLASSNAME = "className";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField()
    private String code;

    @DsField()
    private String docNo;

    @DsField()
    private Date docDate;

    @DsField(noUpdate = true, join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(noUpdate = true, join = "left", path = "supplier.code")
    private String supplier;

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField()
    private String description;

    @DsField(noUpdate = true, join = "left", path = "customer.id")
    private Long customerId;

    @DsField(join = "left", path = "customer.uuid")
    private String customerUuid;

    @DsField(noUpdate = true, join = "left", path = "customer.code")
    private String customerCode;

    @DsField(noUpdate = true, join = "left", path = "customer.name")
    private String customer;

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

    @DsField(noUpdate = true, join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(noUpdate = true, join = "left", path = "currency.code")
    private String currency;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalNetAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalTaxAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalAmount;

    @DsField(join = "left", path = "billToLocation.id")
    private Long billToLocationId;

    @DsField(join = "left", fetch = false, path = "billToLocation.asString")
    private String billToLocation;

    @DsField(join = "left", path = "billToContact.id")
    private Long billToContactId;

    @DsField(join = "left", fetch = false, path = "billToContact.name")
    private String billToContact;

    @DsField(join = "left", path = "salesOrder.id")
    private Long salesOrderId;

    @DsField(join = "left", path = "salesOrder.code")
    private String salesOrderCode;

    @DsField(noInsert = true, noUpdate = true)
    private Boolean confirmed;

    @DsField(noInsert = true, noUpdate = true)
    private Boolean posted;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private String className;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private String businessObject;

    public SalesInvoiceDs() {
        super();
    }

    public SalesInvoiceDs(SalesInvoice e) {
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

    public Long getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerUuid() {
        return this.customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
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

    public Long getBillToLocationId() {
        return this.billToLocationId;
    }

    public void setBillToLocationId(Long billToLocationId) {
        this.billToLocationId = billToLocationId;
    }

    public String getBillToLocation() {
        return this.billToLocation;
    }

    public void setBillToLocation(String billToLocation) {
        this.billToLocation = billToLocation;
    }

    public Long getBillToContactId() {
        return this.billToContactId;
    }

    public void setBillToContactId(Long billToContactId) {
        this.billToContactId = billToContactId;
    }

    public String getBillToContact() {
        return this.billToContact;
    }

    public void setBillToContact(String billToContact) {
        this.billToContact = billToContact;
    }

    public Long getSalesOrderId() {
        return this.salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getSalesOrderCode() {
        return this.salesOrderCode;
    }

    public void setSalesOrderCode(String salesOrderCode) {
        this.salesOrderCode = salesOrderCode;
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
