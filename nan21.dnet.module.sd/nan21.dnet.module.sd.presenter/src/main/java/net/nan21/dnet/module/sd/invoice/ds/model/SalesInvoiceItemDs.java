/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesInvoiceItem.class)
public class SalesInvoiceItemDs extends AbstractAuditableDs<SalesInvoiceItem> {

    public static final String fSALESINVOICEID = "salesInvoiceId";
    public static final String fPRODUCTID = "productId";
    public static final String fPRODUCTCODE = "productCode";
    public static final String fPRODUCTNAME = "productName";
    public static final String fQUANTITY = "quantity";
    public static final String fUOMID = "uomId";
    public static final String fUOMCODE = "uomCode";
    public static final String fUNITPRICE = "unitPrice";
    public static final String fNETAMOUNT = "netAmount";
    public static final String fTAXAMOUNT = "taxAmount";
    public static final String fTAXID = "taxId";
    public static final String fTAX = "tax";

    @DsField(noUpdate = true, join = "left", path = "salesInvoice.id")
    private Long salesInvoiceId;

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

    @DsField(noInsert = true, noUpdate = true)
    private Float netAmount;

    @DsField(noInsert = true, noUpdate = true)
    private Float taxAmount;

    @DsField(join = "left", path = "tax.id")
    private Long taxId;

    @DsField(join = "left", path = "tax.name")
    private String tax;

    public SalesInvoiceItemDs() {
        super();
    }

    public SalesInvoiceItemDs(SalesInvoiceItem e) {
        super(e);
    }

    public Long getSalesInvoiceId() {
        return this.salesInvoiceId;
    }

    public void setSalesInvoiceId(Long salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
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
