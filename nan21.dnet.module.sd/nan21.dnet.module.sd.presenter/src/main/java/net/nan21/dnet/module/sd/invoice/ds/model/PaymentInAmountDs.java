/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentInAmount.class)
public class PaymentInAmountDs extends AbstractAuditableDs<PaymentInAmount> {

    public static final String fPAYMENTID = "paymentId";
    public static final String fTXAMOUNTID = "txAmountId";
    public static final String fINVOICECODE = "invoiceCode";
    public static final String fINVOICEDOCNO = "invoiceDocNo";
    public static final String fINVOICEDOCDATE = "invoiceDocDate";
    public static final String fEXPECTEDAMOUNT = "expectedAmount";
    public static final String fPAYEDAMOUNT = "payedAmount";
    public static final String fDUEAMOUNT = "dueAmount";
    public static final String fAMOUNT = "amount";

    @DsField(join = "left", path = "payment.id")
    private Long paymentId;

    @DsField(join = "left", path = "txAmount.id")
    private Long txAmountId;

    @DsField(join = "left", path = "txAmount.invoice.code")
    private String invoiceCode;

    @DsField(join = "left", path = "txAmount.invoice.docNo")
    private String invoiceDocNo;

    @DsField(join = "left", path = "txAmount.invoice.docDate")
    private Date invoiceDocDate;

    @DsField(join = "left", path = "txAmount.amount")
    private Float expectedAmount;

    @DsField(join = "left", path = "txAmount.payedAmount")
    private Float payedAmount;

    @DsField(join = "left", path = "txAmount.dueAmount")
    private Float dueAmount;

    @DsField()
    private Float amount;

    public PaymentInAmountDs() {
        super();
    }

    public PaymentInAmountDs(PaymentInAmount e) {
        super(e);
    }

    public Long getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getTxAmountId() {
        return this.txAmountId;
    }

    public void setTxAmountId(Long txAmountId) {
        this.txAmountId = txAmountId;
    }

    public String getInvoiceCode() {
        return this.invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceDocNo() {
        return this.invoiceDocNo;
    }

    public void setInvoiceDocNo(String invoiceDocNo) {
        this.invoiceDocNo = invoiceDocNo;
    }

    public Date getInvoiceDocDate() {
        return this.invoiceDocDate;
    }

    public void setInvoiceDocDate(Date invoiceDocDate) {
        this.invoiceDocDate = invoiceDocDate;
    }

    public Float getExpectedAmount() {
        return this.expectedAmount;
    }

    public void setExpectedAmount(Float expectedAmount) {
        this.expectedAmount = expectedAmount;
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

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
