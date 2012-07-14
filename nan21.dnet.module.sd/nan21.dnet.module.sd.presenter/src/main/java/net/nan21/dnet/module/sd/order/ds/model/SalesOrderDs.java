/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesOrder.class)
public class SalesOrderDs extends AbstractAuditableDs<SalesOrder> {

    public static final String fCODE = "code";
    public static final String fDOCNO = "docNo";
    public static final String fDESCRIPTION = "description";
    public static final String fDOCDATE = "docDate";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIER = "supplier";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fCUSTOMERID = "customerId";
    public static final String fCUSTOMERUUID = "customerUuid";
    public static final String fCUSTOMERCODE = "customerCode";
    public static final String fCUSTOMER = "customer";
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
    public static final String fPLANNEDDELIVERYDATE = "plannedDeliveryDate";
    public static final String fDELIVERYNOTES = "deliveryNotes";
    public static final String fINVENTORYID = "inventoryId";
    public static final String fINVENTORY = "inventory";
    public static final String fBILLTOID = "billToId";
    public static final String fBILLTOUUID = "billToUuid";
    public static final String fBILLTOCODE = "billToCode";
    public static final String fBILLTO = "billTo";
    public static final String fBILLTOLOCATIONID = "billToLocationId";
    public static final String fBILLTOLOCATION = "billToLocation";
    public static final String fBILLTOCONTACTID = "billToContactId";
    public static final String fBILLTOCONTACT = "billToContact";
    public static final String fSHIPTOID = "shipToId";
    public static final String fSHIPTOUUID = "shipToUuid";
    public static final String fSHIPTOCODE = "shipToCode";
    public static final String fSHIPTO = "shipTo";
    public static final String fSHIPTOLOCATIONID = "shipToLocationId";
    public static final String fSHIPTOLOCATION = "shipToLocation";
    public static final String fSHIPTOCONTACTID = "shipToContactId";
    public static final String fSHIPTOCONTACT = "shipToContact";
    public static final String fCARRIERID = "carrierId";
    public static final String fCARRIER = "carrier";
    public static final String fTOTALAMOUNT = "totalAmount";
    public static final String fTOTALNETAMOUNT = "totalNetAmount";
    public static final String fTOTALTAXAMOUNT = "totalTaxAmount";
    public static final String fCONFIRMED = "confirmed";
    public static final String fINVOICED = "invoiced";
    public static final String fDELIVERED = "delivered";
    public static final String fCLASSNAME = "className";
    public static final String fBUSINESSOBJECT = "businessObject";

    @DsField()
    private String code;

    @DsField()
    private String docNo;

    @DsField()
    private String description;

    @DsField(noUpdate = true)
    private Date docDate;

    @DsField(noUpdate = true, join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(noUpdate = true, join = "left", path = "supplier.code")
    private String supplier;

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField(noUpdate = true, join = "left", path = "customer.id")
    private Long customerId;

    @DsField(noUpdate = true, join = "left", path = "customer.uuid")
    private String customerUuid;

    @DsField(noUpdate = true, join = "left", path = "customer.code")
    private String customerCode;

    @DsField(noUpdate = true, join = "left", path = "customer.name")
    private String customer;

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

    @DsField()
    private Date plannedDeliveryDate;

    @DsField()
    private String deliveryNotes;

    @DsField(join = "left", path = "inventory.id")
    private Long inventoryId;

    @DsField(join = "left", path = "inventory.code")
    private String inventory;

    @DsField(join = "left", path = "billTo.id")
    private Long billToId;

    @DsField(join = "left", path = "billTo.uuid")
    private String billToUuid;

    @DsField(join = "left", path = "billTo.code")
    private String billToCode;

    @DsField(join = "left", path = "billTo.name")
    private String billTo;

    @DsField(join = "left", path = "billToLocation.id")
    private Long billToLocationId;

    @DsField(join = "left", fetch = false, path = "billToLocation.asString")
    private String billToLocation;

    @DsField(join = "left", path = "billToContact.id")
    private Long billToContactId;

    @DsField(join = "left", fetch = false, path = "billToContact.name")
    private String billToContact;

    @DsField(join = "left", path = "shipTo.id")
    private Long shipToId;

    @DsField(join = "left", path = "shipTo.uuid")
    private String shipToUuid;

    @DsField(join = "left", path = "shipTo.code")
    private String shipToCode;

    @DsField(join = "left", path = "shipTo.name")
    private String shipTo;

    @DsField(join = "left", path = "shipToLocation.id")
    private Long shipToLocationId;

    @DsField(join = "left", fetch = false, path = "shipToLocation.asString")
    private String shipToLocation;

    @DsField(join = "left", path = "shipToContact.id")
    private Long shipToContactId;

    @DsField(join = "left", fetch = false, path = "shipToContact.name")
    private String shipToContact;

    @DsField(join = "left", path = "carrier.id")
    private Long carrierId;

    @DsField(join = "left", path = "carrier.code")
    private String carrier;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalNetAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float totalTaxAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Boolean confirmed;

    @DsField(noInsert = true, noUpdate = true)
    private Boolean invoiced;

    @DsField(noInsert = true, noUpdate = true)
    private Boolean delivered;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private String className;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private String businessObject;

    public SalesOrderDs() {
        super();
    }

    public SalesOrderDs(SalesOrder e) {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getBillToId() {
        return this.billToId;
    }

    public void setBillToId(Long billToId) {
        this.billToId = billToId;
    }

    public String getBillToUuid() {
        return this.billToUuid;
    }

    public void setBillToUuid(String billToUuid) {
        this.billToUuid = billToUuid;
    }

    public String getBillToCode() {
        return this.billToCode;
    }

    public void setBillToCode(String billToCode) {
        this.billToCode = billToCode;
    }

    public String getBillTo() {
        return this.billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
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

    public Long getShipToId() {
        return this.shipToId;
    }

    public void setShipToId(Long shipToId) {
        this.shipToId = shipToId;
    }

    public String getShipToUuid() {
        return this.shipToUuid;
    }

    public void setShipToUuid(String shipToUuid) {
        this.shipToUuid = shipToUuid;
    }

    public String getShipToCode() {
        return this.shipToCode;
    }

    public void setShipToCode(String shipToCode) {
        this.shipToCode = shipToCode;
    }

    public String getShipTo() {
        return this.shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public Long getShipToLocationId() {
        return this.shipToLocationId;
    }

    public void setShipToLocationId(Long shipToLocationId) {
        this.shipToLocationId = shipToLocationId;
    }

    public String getShipToLocation() {
        return this.shipToLocation;
    }

    public void setShipToLocation(String shipToLocation) {
        this.shipToLocation = shipToLocation;
    }

    public Long getShipToContactId() {
        return this.shipToContactId;
    }

    public void setShipToContactId(Long shipToContactId) {
        this.shipToContactId = shipToContactId;
    }

    public String getShipToContact() {
        return this.shipToContact;
    }

    public void setShipToContact(String shipToContact) {
        this.shipToContact = shipToContact;
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

    public Boolean getInvoiced() {
        return this.invoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        this.invoiced = invoiced;
    }

    public Boolean getDelivered() {
        return this.delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
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
