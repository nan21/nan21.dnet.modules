/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesInvoice.class)
public class SalesInvoiceDs extends AbstractDsModel<SalesInvoice> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fDOCNO = "docNo";
    public static final String fDOCDATE = "docDate";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUS = "status";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCYCODE = "currencyCode";
    public static final String fTOTALNETAMOUNT = "totalNetAmount";
    public static final String fTOTALTAXAMOUNT = "totalTaxAmount";
    public static final String fTOTALAMOUNT = "totalAmount";
    public static final String fCUSTOMERID = "customerId";
    public static final String fCUSTOMERCODE = "customerCode";
    public static final String fBILLTOLOCATIONID = "billToLocationId";
    public static final String fBILLTOLOCATION = "billToLocation";
    public static final String fBILLTOCONTACTID = "billToContactId";
    public static final String fBILLTOCONTACT = "billToContact";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIERCODE = "supplierCode";
    public static final String fSALESORDERID = "salesOrderId";
    public static final String fCLASSNAME = "className";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField()
    private String docNo;

    @DsField()
    private Date docDate;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String status;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currencyCode;

    @DsField()
    private Float totalNetAmount;

    @DsField()
    private Float totalTaxAmount;

    @DsField()
    private Float totalAmount;

    @DsField(join = "left", path = "customer.id")
    private Long customerId;

    @DsField(join = "left", path = "customer.code")
    private String customerCode;

    @DsField(join = "left", path = "billToLocation.id")
    private Long billToLocationId;

    @DsField(join = "left", fetch = false, path = "billToLocation.asString")
    private String billToLocation;

    @DsField(join = "left", path = "billToContact.id")
    private Long billToContactId;

    @DsField(join = "left", fetch = false, path = "billToContact.name")
    private String billToContact;

    @DsField(join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(join = "left", path = "supplier.code")
    private String supplierCode;

    @DsField(join = "left", path = "salesOrder.id")
    private Long salesOrderId;

    @DsField(fetch = false)
    private String className;

    public SalesInvoiceDs() {
        super();
    }

    public SalesInvoiceDs(SalesInvoice e) {
        super(e);
    }

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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    public Long getSalesOrderId() {
        return this.salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}