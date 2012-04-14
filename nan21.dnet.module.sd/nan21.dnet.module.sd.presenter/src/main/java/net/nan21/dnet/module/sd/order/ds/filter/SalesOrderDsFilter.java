/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SalesOrderDsFilter extends AbstractAuditableDsFilter {

    private String code;

    private Date docDate;

    private Date docDate_From;
    private Date docDate_To;

    private Long supplierId;

    private Long supplierId_From;
    private Long supplierId_To;

    private String supplier;

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    private Long customerId;

    private Long customerId_From;
    private Long customerId_To;

    private String customerUuid;

    private String customerCode;

    private String customer;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currency;

    private Long priceListId;

    private Long priceListId_From;
    private Long priceListId_To;

    private String priceList;

    private Long paymentMethodId;

    private Long paymentMethodId_From;
    private Long paymentMethodId_To;

    private String paymentMethod;

    private Long paymentTermId;

    private Long paymentTermId_From;
    private Long paymentTermId_To;

    private String paymentTerm;

    private Long deliveryMethodId;

    private Long deliveryMethodId_From;
    private Long deliveryMethodId_To;

    private String deliveryMethod;

    private Date plannedDeliveryDate;

    private Date plannedDeliveryDate_From;
    private Date plannedDeliveryDate_To;

    private String deliveryNotes;

    private Long inventoryId;

    private Long inventoryId_From;
    private Long inventoryId_To;

    private String inventory;

    private Long billToId;

    private Long billToId_From;
    private Long billToId_To;

    private String billToUuid;

    private String billToCode;

    private String billTo;

    private Long billToLocationId;

    private Long billToLocationId_From;
    private Long billToLocationId_To;

    private String billToLocation;

    private Long shipToId;

    private Long shipToId_From;
    private Long shipToId_To;

    private String shipToUuid;

    private String shipToCode;

    private String shipTo;

    private Long shipToLocationId;

    private Long shipToLocationId_From;
    private Long shipToLocationId_To;

    private String shipToLocation;

    private Long carrierId;

    private Long carrierId_From;
    private Long carrierId_To;

    private String carrier;

    private Float totalAmount;

    private Float totalAmount_From;
    private Float totalAmount_To;

    private Float totalNetAmount;

    private Float totalNetAmount_From;
    private Float totalNetAmount_To;

    private Float totalTaxAmount;

    private Float totalTaxAmount_From;
    private Float totalTaxAmount_To;

    private Boolean confirmed;

    private Boolean invoiced;

    private Boolean delivered;

    private String className;

    private String businessObject;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getSupplierId() {
        return this.supplierId;
    }

    public Long getSupplierId_From() {
        return this.supplierId_From;
    }

    public Long getSupplierId_To() {
        return this.supplierId_To;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierId_From(Long supplierId_From) {
        this.supplierId_From = supplierId_From;
    }

    public void setSupplierId_To(Long supplierId_To) {
        this.supplierId_To = supplierId_To;
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

    public Long getCurrencyId_From() {
        return this.currencyId_From;
    }

    public Long getCurrencyId_To() {
        return this.currencyId_To;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyId_From(Long currencyId_From) {
        this.currencyId_From = currencyId_From;
    }

    public void setCurrencyId_To(Long currencyId_To) {
        this.currencyId_To = currencyId_To;
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

    public Long getPriceListId_From() {
        return this.priceListId_From;
    }

    public Long getPriceListId_To() {
        return this.priceListId_To;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public void setPriceListId_From(Long priceListId_From) {
        this.priceListId_From = priceListId_From;
    }

    public void setPriceListId_To(Long priceListId_To) {
        this.priceListId_To = priceListId_To;
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

    public Long getPaymentMethodId_From() {
        return this.paymentMethodId_From;
    }

    public Long getPaymentMethodId_To() {
        return this.paymentMethodId_To;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public void setPaymentMethodId_From(Long paymentMethodId_From) {
        this.paymentMethodId_From = paymentMethodId_From;
    }

    public void setPaymentMethodId_To(Long paymentMethodId_To) {
        this.paymentMethodId_To = paymentMethodId_To;
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

    public Long getPaymentTermId_From() {
        return this.paymentTermId_From;
    }

    public Long getPaymentTermId_To() {
        return this.paymentTermId_To;
    }

    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public void setPaymentTermId_From(Long paymentTermId_From) {
        this.paymentTermId_From = paymentTermId_From;
    }

    public void setPaymentTermId_To(Long paymentTermId_To) {
        this.paymentTermId_To = paymentTermId_To;
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

    public Long getDeliveryMethodId_From() {
        return this.deliveryMethodId_From;
    }

    public Long getDeliveryMethodId_To() {
        return this.deliveryMethodId_To;
    }

    public void setDeliveryMethodId(Long deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    public void setDeliveryMethodId_From(Long deliveryMethodId_From) {
        this.deliveryMethodId_From = deliveryMethodId_From;
    }

    public void setDeliveryMethodId_To(Long deliveryMethodId_To) {
        this.deliveryMethodId_To = deliveryMethodId_To;
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

    public Date getPlannedDeliveryDate_From() {
        return this.plannedDeliveryDate_From;
    }

    public Date getPlannedDeliveryDate_To() {
        return this.plannedDeliveryDate_To;
    }

    public void setPlannedDeliveryDate(Date plannedDeliveryDate) {
        this.plannedDeliveryDate = plannedDeliveryDate;
    }

    public void setPlannedDeliveryDate_From(Date plannedDeliveryDate_From) {
        this.plannedDeliveryDate_From = plannedDeliveryDate_From;
    }

    public void setPlannedDeliveryDate_To(Date plannedDeliveryDate_To) {
        this.plannedDeliveryDate_To = plannedDeliveryDate_To;
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

    public Long getInventoryId_From() {
        return this.inventoryId_From;
    }

    public Long getInventoryId_To() {
        return this.inventoryId_To;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setInventoryId_From(Long inventoryId_From) {
        this.inventoryId_From = inventoryId_From;
    }

    public void setInventoryId_To(Long inventoryId_To) {
        this.inventoryId_To = inventoryId_To;
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

    public Long getBillToId_From() {
        return this.billToId_From;
    }

    public Long getBillToId_To() {
        return this.billToId_To;
    }

    public void setBillToId(Long billToId) {
        this.billToId = billToId;
    }

    public void setBillToId_From(Long billToId_From) {
        this.billToId_From = billToId_From;
    }

    public void setBillToId_To(Long billToId_To) {
        this.billToId_To = billToId_To;
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

    public Long getBillToLocationId_From() {
        return this.billToLocationId_From;
    }

    public Long getBillToLocationId_To() {
        return this.billToLocationId_To;
    }

    public void setBillToLocationId(Long billToLocationId) {
        this.billToLocationId = billToLocationId;
    }

    public void setBillToLocationId_From(Long billToLocationId_From) {
        this.billToLocationId_From = billToLocationId_From;
    }

    public void setBillToLocationId_To(Long billToLocationId_To) {
        this.billToLocationId_To = billToLocationId_To;
    }

    public String getBillToLocation() {
        return this.billToLocation;
    }

    public void setBillToLocation(String billToLocation) {
        this.billToLocation = billToLocation;
    }

    public Long getShipToId() {
        return this.shipToId;
    }

    public Long getShipToId_From() {
        return this.shipToId_From;
    }

    public Long getShipToId_To() {
        return this.shipToId_To;
    }

    public void setShipToId(Long shipToId) {
        this.shipToId = shipToId;
    }

    public void setShipToId_From(Long shipToId_From) {
        this.shipToId_From = shipToId_From;
    }

    public void setShipToId_To(Long shipToId_To) {
        this.shipToId_To = shipToId_To;
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

    public Long getShipToLocationId_From() {
        return this.shipToLocationId_From;
    }

    public Long getShipToLocationId_To() {
        return this.shipToLocationId_To;
    }

    public void setShipToLocationId(Long shipToLocationId) {
        this.shipToLocationId = shipToLocationId;
    }

    public void setShipToLocationId_From(Long shipToLocationId_From) {
        this.shipToLocationId_From = shipToLocationId_From;
    }

    public void setShipToLocationId_To(Long shipToLocationId_To) {
        this.shipToLocationId_To = shipToLocationId_To;
    }

    public String getShipToLocation() {
        return this.shipToLocation;
    }

    public void setShipToLocation(String shipToLocation) {
        this.shipToLocation = shipToLocation;
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

    public Float getTotalAmount() {
        return this.totalAmount;
    }

    public Float getTotalAmount_From() {
        return this.totalAmount_From;
    }

    public Float getTotalAmount_To() {
        return this.totalAmount_To;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTotalAmount_From(Float totalAmount_From) {
        this.totalAmount_From = totalAmount_From;
    }

    public void setTotalAmount_To(Float totalAmount_To) {
        this.totalAmount_To = totalAmount_To;
    }

    public Float getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public Float getTotalNetAmount_From() {
        return this.totalNetAmount_From;
    }

    public Float getTotalNetAmount_To() {
        return this.totalNetAmount_To;
    }

    public void setTotalNetAmount(Float totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    public void setTotalNetAmount_From(Float totalNetAmount_From) {
        this.totalNetAmount_From = totalNetAmount_From;
    }

    public void setTotalNetAmount_To(Float totalNetAmount_To) {
        this.totalNetAmount_To = totalNetAmount_To;
    }

    public Float getTotalTaxAmount() {
        return this.totalTaxAmount;
    }

    public Float getTotalTaxAmount_From() {
        return this.totalTaxAmount_From;
    }

    public Float getTotalTaxAmount_To() {
        return this.totalTaxAmount_To;
    }

    public void setTotalTaxAmount(Float totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public void setTotalTaxAmount_From(Float totalTaxAmount_From) {
        this.totalTaxAmount_From = totalTaxAmount_From;
    }

    public void setTotalTaxAmount_To(Float totalTaxAmount_To) {
        this.totalTaxAmount_To = totalTaxAmount_To;
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
