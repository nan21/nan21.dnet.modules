/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PurchaseInvoiceItem.class)
public class PurchaseInvoiceItemDs extends
        AbstractAuditableDs<PurchaseInvoiceItem> {

    public static final String fPURCHASEINVOICEID = "purchaseInvoiceId";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fQUANTITY = "quantity";
    public static final String fUOMID = "uomId";
    public static final String fUOMCODE = "uomCode";
    public static final String fUNITPRICE = "unitPrice";
    public static final String fNETAMOUNT = "netAmount";
    public static final String fTAXAMOUNT = "taxAmount";
    public static final String fLINEAMOUNT = "lineAmount";
    public static final String fENTRYMODE = "entryMode";
    public static final String fTAXID = "taxId";
    public static final String fTAX = "tax";

    @DsField(noUpdate = true, join = "left", path = "purchaseInvoice.id")
    private Long purchaseInvoiceId;

    @DsField(join = "left", path = "product.id")
    private Long productId;

    @DsField(join = "left", path = "product.code")
    private String productCode;

    @DsField(join = "left", path = "product.name")
    private String productName;

    @DsField()
    private Float quantity;

    @DsField(join = "left", path = "uom.id")
    private Long uomId;

    @DsField(join = "left", path = "uom.code")
    private String uomCode;

    @DsField()
    private Float unitPrice;

    @DsField()
    private Float netAmount;

    @DsField()
    private Float taxAmount;

    @DsField()
    private Float lineAmount;

    @DsField()
    private String entryMode;

    @DsField(join = "left", path = "tax.id")
    private Long taxId;

    @DsField(join = "left", path = "tax.name")
    private String tax;

    public PurchaseInvoiceItemDs() {
        super();
    }

    public PurchaseInvoiceItemDs(PurchaseInvoiceItem e) {
        super(e);
    }

    public Long getPurchaseInvoiceId() {
        return this.purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
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

    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
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

    public String getEntryMode() {
        return this.entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
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
