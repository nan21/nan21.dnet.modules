/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesInvoiceTax.class)
public class SalesInvoiceTaxDs extends AbstractAuditableDs<SalesInvoiceTax> {

    public static final String fSALESINVOICEID = "salesInvoiceId";
    public static final String fTAXID = "taxId";
    public static final String fTAX = "tax";
    public static final String fBASEAMOUNT = "baseAmount";
    public static final String fTAXAMOUNT = "taxAmount";

    @DsField(join = "left", path = "salesInvoice.id")
    private Long salesInvoiceId;

    @DsField(join = "left", path = "tax.id")
    private Long taxId;

    @DsField(join = "left", path = "tax.name")
    private String tax;

    @DsField()
    private Float baseAmount;

    @DsField()
    private Float taxAmount;

    public SalesInvoiceTaxDs() {
        super();
    }

    public SalesInvoiceTaxDs(SalesInvoiceTax e) {
        super(e);
    }

    public Long getSalesInvoiceId() {
        return this.salesInvoiceId;
    }

    public void setSalesInvoiceId(Long salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
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

    public Float getBaseAmount() {
        return this.baseAmount;
    }

    public void setBaseAmount(Float baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Float getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

}
