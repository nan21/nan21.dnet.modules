/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItemTax;

@Ds(entity = PurchaseInvoiceItemTax.class)
public class PurchaseInvoiceItemTaxDs extends
        AbstractAuditableDs<PurchaseInvoiceItemTax> {

    public static final String fPURCHASEINVOICEITEMID = "purchaseInvoiceItemId";
    public static final String fTAXID = "taxId";
    public static final String fTAX = "tax";
    public static final String fBASEAMOUNT = "baseAmount";
    public static final String fTAXAMOUNT = "taxAmount";

    @DsField(join = "left", path = "purchaseInvoiceItem.id")
    private Long purchaseInvoiceItemId;

    @DsField(join = "left", path = "tax.id")
    private Long taxId;

    @DsField(join = "left", path = "tax.name")
    private String tax;

    @DsField()
    private Float baseAmount;

    @DsField()
    private Float taxAmount;

    public PurchaseInvoiceItemTaxDs() {
        super();
    }

    public PurchaseInvoiceItemTaxDs(PurchaseInvoiceItemTax e) {
        super(e);
    }

    public Long getPurchaseInvoiceItemId() {
        return this.purchaseInvoiceItemId;
    }

    public void setPurchaseInvoiceItemId(Long purchaseInvoiceItemId) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
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
