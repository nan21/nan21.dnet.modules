/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesOrderItem.class)
public class SalesOrderItemDs extends AbstractAuditableDs<SalesOrderItem> {

    public static final String fSALESORDERID = "salesOrderId";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fDESCRIPTION = "description";
    public static final String fUOMID = "uomId";
    public static final String fUOMCODE = "uomCode";
    public static final String fQUANTITY = "quantity";
    public static final String fUNITPRICE = "unitPrice";
    public static final String fNETAMOUNT = "netAmount";
    public static final String fTAXAMOUNT = "taxAmount";
    public static final String fLINEAMOUNT = "lineAmount";
    public static final String fTAXID = "taxId";
    public static final String fTAX = "tax";

    @DsField(noUpdate = true, join = "left", path = "salesOrder.id")
    private Long salesOrderId;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField()
    private String description;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uomCode;

    @DsField()
    private Float quantity;

    @DsField()
    private Float unitPrice;

    @DsField(noInsert = true, noUpdate = true)
    private Float netAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float taxAmount;

    @DsField(noInsert = true, noUpdate = true, fetch = false)
    private Float lineAmount;

    @DsField(join = "left", path = "tax.id")
    private Long taxId;

    @DsField(join = "left", path = "tax.name")
    private String tax;

    public SalesOrderItemDs() {
        super();
    }

    public SalesOrderItemDs(SalesOrderItem e) {
        super(e);
    }

    public Long getSalesOrderId() {
        return this.salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUomId() {
        return this.uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public String getUomCode() {
        return this.uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public Float getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Float getLineAmount() {
        return this.lineAmount;
    }

    public void setLineAmount(Float lineAmount) {
        this.lineAmount = lineAmount;
    }

    public Long getTaxId() {
        return this.taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

}
