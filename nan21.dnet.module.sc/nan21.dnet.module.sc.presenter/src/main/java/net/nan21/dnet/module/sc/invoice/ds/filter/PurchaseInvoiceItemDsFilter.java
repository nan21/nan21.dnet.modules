/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PurchaseInvoiceItemDsFilter extends AbstractAuditableDsFilter {

    private Long purchaseInvoiceId;

    private Long purchaseInvoiceId_From;
    private Long purchaseInvoiceId_To;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String productName;

    private Float quantity;

    private Float quantity_From;
    private Float quantity_To;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uomCode;

    private Float unitPrice;

    private Float unitPrice_From;
    private Float unitPrice_To;

    private Float netAmount;

    private Float netAmount_From;
    private Float netAmount_To;

    private Float taxAmount;

    private Float taxAmount_From;
    private Float taxAmount_To;

    private Float lineAmount;

    private Float lineAmount_From;
    private Float lineAmount_To;

    private Long taxId;

    private Long taxId_From;
    private Long taxId_To;

    private String tax;

    public Long getPurchaseInvoiceId() {
        return this.purchaseInvoiceId;
    }

    public Long getPurchaseInvoiceId_From() {
        return this.purchaseInvoiceId_From;
    }

    public Long getPurchaseInvoiceId_To() {
        return this.purchaseInvoiceId_To;
    }

    public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId_From(Long purchaseInvoiceId_From) {
        this.purchaseInvoiceId_From = purchaseInvoiceId_From;
    }

    public void setPurchaseInvoiceId_To(Long purchaseInvoiceId_To) {
        this.purchaseInvoiceId_To = purchaseInvoiceId_To;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
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

    public Float getQuantity_From() {
        return this.quantity_From;
    }

    public Float getQuantity_To() {
        return this.quantity_To;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void setQuantity_From(Float quantity_From) {
        this.quantity_From = quantity_From;
    }

    public void setQuantity_To(Float quantity_To) {
        this.quantity_To = quantity_To;
    }

    public Long getUomId() {
        return this.uomId;
    }

    public Long getUomId_From() {
        return this.uomId_From;
    }

    public Long getUomId_To() {
        return this.uomId_To;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setUomId_From(Long uomId_From) {
        this.uomId_From = uomId_From;
    }

    public void setUomId_To(Long uomId_To) {
        this.uomId_To = uomId_To;
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

    public Float getUnitPrice_From() {
        return this.unitPrice_From;
    }

    public Float getUnitPrice_To() {
        return this.unitPrice_To;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitPrice_From(Float unitPrice_From) {
        this.unitPrice_From = unitPrice_From;
    }

    public void setUnitPrice_To(Float unitPrice_To) {
        this.unitPrice_To = unitPrice_To;
    }

    public Float getNetAmount() {
        return this.netAmount;
    }

    public Float getNetAmount_From() {
        return this.netAmount_From;
    }

    public Float getNetAmount_To() {
        return this.netAmount_To;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public void setNetAmount_From(Float netAmount_From) {
        this.netAmount_From = netAmount_From;
    }

    public void setNetAmount_To(Float netAmount_To) {
        this.netAmount_To = netAmount_To;
    }

    public Float getTaxAmount() {
        return this.taxAmount;
    }

    public Float getTaxAmount_From() {
        return this.taxAmount_From;
    }

    public Float getTaxAmount_To() {
        return this.taxAmount_To;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTaxAmount_From(Float taxAmount_From) {
        this.taxAmount_From = taxAmount_From;
    }

    public void setTaxAmount_To(Float taxAmount_To) {
        this.taxAmount_To = taxAmount_To;
    }

    public Float getLineAmount() {
        return this.lineAmount;
    }

    public Float getLineAmount_From() {
        return this.lineAmount_From;
    }

    public Float getLineAmount_To() {
        return this.lineAmount_To;
    }

    public void setLineAmount(Float lineAmount) {
        this.lineAmount = lineAmount;
    }

    public void setLineAmount_From(Float lineAmount_From) {
        this.lineAmount_From = lineAmount_From;
    }

    public void setLineAmount_To(Float lineAmount_To) {
        this.lineAmount_To = lineAmount_To;
    }

    public Long getTaxId() {
        return this.taxId;
    }

    public Long getTaxId_From() {
        return this.taxId_From;
    }

    public Long getTaxId_To() {
        return this.taxId_To;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public void setTaxId_From(Long taxId_From) {
        this.taxId_From = taxId_From;
    }

    public void setTaxId_To(Long taxId_To) {
        this.taxId_To = taxId_To;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

}
