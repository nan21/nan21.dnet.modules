/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SalesInvoiceItemTaxDsFilter extends AbstractAuditableDsFilter {

    private Long salesInvoiceItemId;

    private Long salesInvoiceItemId_From;
    private Long salesInvoiceItemId_To;

    private Long taxId;

    private Long taxId_From;
    private Long taxId_To;

    private String tax;

    private Float baseAmount;

    private Float baseAmount_From;
    private Float baseAmount_To;

    private Float taxAmount;

    private Float taxAmount_From;
    private Float taxAmount_To;

    public Long getSalesInvoiceItemId() {
        return this.salesInvoiceItemId;
    }

    public Long getSalesInvoiceItemId_From() {
        return this.salesInvoiceItemId_From;
    }

    public Long getSalesInvoiceItemId_To() {
        return this.salesInvoiceItemId_To;
    }

    public void setSalesInvoiceItemId(Long salesInvoiceItemId) {
        this.salesInvoiceItemId = salesInvoiceItemId;
    }

    public void setSalesInvoiceItemId_From(Long salesInvoiceItemId_From) {
        this.salesInvoiceItemId_From = salesInvoiceItemId_From;
    }

    public void setSalesInvoiceItemId_To(Long salesInvoiceItemId_To) {
        this.salesInvoiceItemId_To = salesInvoiceItemId_To;
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

    public Float getBaseAmount() {
        return this.baseAmount;
    }

    public Float getBaseAmount_From() {
        return this.baseAmount_From;
    }

    public Float getBaseAmount_To() {
        return this.baseAmount_To;
    }

    public void setBaseAmount(Float baseAmount) {
        this.baseAmount = baseAmount;
    }

    public void setBaseAmount_From(Float baseAmount_From) {
        this.baseAmount_From = baseAmount_From;
    }

    public void setBaseAmount_To(Float baseAmount_To) {
        this.baseAmount_To = baseAmount_To;
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

}
