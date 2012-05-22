/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SalesTxAmount.class)
public class SalesTxAmountDs extends AbstractAuditableDs<SalesTxAmount> {

    public static final String fINVOICEID = "invoiceId";
    public static final String fORDERID = "orderId";
    public static final String fDUEDATE = "dueDate";
    public static final String fAMOUNT = "amount";
    public static final String fPAYEDAMOUNT = "payedAmount";
    public static final String fDUEAMOUNT = "dueAmount";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";

    @DsField(noUpdate = true, join = "left", path = "invoice.id")
    private Long invoiceId;

    @DsField(noUpdate = true, join = "left", path = "order.id")
    private Long orderId;

    @DsField()
    private Date dueDate;

    @DsField()
    private Float amount;

    @DsField()
    private Float payedAmount;

    @DsField()
    private Float dueAmount;

    @DsField(join = "left", path = "paymentMethod.id")
    private Long paymentMethodId;

    @DsField(join = "left", path = "paymentMethod.name")
    private String paymentMethod;

    public SalesTxAmountDs() {
        super();
    }

    public SalesTxAmountDs(SalesTxAmount e) {
        super(e);
    }

    public Long getInvoiceId() {
        return this.invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPayedAmount() {
        return this.payedAmount;
    }

    public void setPayedAmount(Float payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Float getDueAmount() {
        return this.dueAmount;
    }

    public void setDueAmount(Float dueAmount) {
        this.dueAmount = dueAmount;
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

}
