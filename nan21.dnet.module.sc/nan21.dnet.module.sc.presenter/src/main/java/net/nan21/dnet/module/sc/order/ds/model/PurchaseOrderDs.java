/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PurchaseOrder.class)
public class PurchaseOrderDs extends AbstractDsModel<PurchaseOrder> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fCODE = "code";
    public static final String fDOCDATE = "docDate";
    public static final String fBUSINESSOBJECT = "businessObject";
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
    public static final String fDELIVERYMETHODID = "deliveryMethodId";
    public static final String fDELIVERYMETHOD = "deliveryMethod";
    public static final String fSUPPLIERID = "supplierId";
    public static final String fSUPPLIER = "supplier";
    public static final String fTOTALAMOUNT = "totalAmount";
    public static final String fTOTALNETAMOUNT = "totalNetAmount";
    public static final String fTOTALTAXAMOUNT = "totalTaxAmount";
    public static final String fCLASSNAME = "className";

    @DsField(noUpdate = true)
    private Long id;

    @DsField(noUpdate = true)
    private String uuid;

    @DsField(noUpdate = true)
    private Long clientId;

    @DsField(noUpdate = true)
    private Date createdAt;

    @DsField(noUpdate = true)
    private Date modifiedAt;

    @DsField(noUpdate = true)
    private String createdBy;

    @DsField(noUpdate = true)
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(noUpdate = true, fetch = false, path = "className")
    private String entityFQN;

    @DsField()
    private String code;

    @DsField()
    private Date docDate;

    @DsField(fetch = false)
    private String businessObject;

    @DsField(join = "left", path = "customer.id")
    private Long customerId;

    @DsField(join = "left", path = "customer.uuid")
    private String customerUuid;

    @DsField(join = "left", path = "customer.code")
    private String customerCode;

    @DsField(join = "left", path = "customer.name")
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

    @DsField(join = "left", path = "deliveryMethod.id")
    private Long deliveryMethodId;

    @DsField(join = "left", path = "deliveryMethod.name")
    private String deliveryMethod;

    @DsField(join = "left", path = "supplier.id")
    private Long supplierId;

    @DsField(join = "left", path = "supplier.code")
    private String supplier;

    @DsField()
    private Float totalAmount;

    @DsField()
    private Float totalNetAmount;

    @DsField()
    private Float totalTaxAmount;

    @DsField(fetch = false)
    private String className;

    public PurchaseOrderDs() {
        super();
    }

    public PurchaseOrderDs(PurchaseOrder e) {
        super(e);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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

    public String getBusinessObject() {
        return this.businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
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

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
