/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PaymentInAmountDsFilter extends AbstractAuditableDsFilter {

    private Long paymentId;

    private Long paymentId_From;
    private Long paymentId_To;

    private Long txAmountId;

    private Long txAmountId_From;
    private Long txAmountId_To;

    private String invoiceCode;

    private String invoiceDocNo;

    private Date invoiceDocDate;

    private Date invoiceDocDate_From;
    private Date invoiceDocDate_To;

    private Float expectedAmount;

    private Float expectedAmount_From;
    private Float expectedAmount_To;

    private Float payedAmount;

    private Float payedAmount_From;
    private Float payedAmount_To;

    private Float dueAmount;

    private Float dueAmount_From;
    private Float dueAmount_To;

    private Float amount;

    private Float amount_From;
    private Float amount_To;

    public Long getPaymentId() {
        return this.paymentId;
    }

    public Long getPaymentId_From() {
        return this.paymentId_From;
    }

    public Long getPaymentId_To() {
        return this.paymentId_To;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentId_From(Long paymentId_From) {
        this.paymentId_From = paymentId_From;
    }

    public void setPaymentId_To(Long paymentId_To) {
        this.paymentId_To = paymentId_To;
    }

    public Long getTxAmountId() {
        return this.txAmountId;
    }

    public Long getTxAmountId_From() {
        return this.txAmountId_From;
    }

    public Long getTxAmountId_To() {
        return this.txAmountId_To;
    }

    public void setTxAmountId(Long txAmountId) {
        this.txAmountId = txAmountId;
    }

    public void setTxAmountId_From(Long txAmountId_From) {
        this.txAmountId_From = txAmountId_From;
    }

    public void setTxAmountId_To(Long txAmountId_To) {
        this.txAmountId_To = txAmountId_To;
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

    public Date getInvoiceDocDate_From() {
        return this.invoiceDocDate_From;
    }

    public Date getInvoiceDocDate_To() {
        return this.invoiceDocDate_To;
    }

    public void setInvoiceDocDate(Date invoiceDocDate) {
        this.invoiceDocDate = invoiceDocDate;
    }

    public void setInvoiceDocDate_From(Date invoiceDocDate_From) {
        this.invoiceDocDate_From = invoiceDocDate_From;
    }

    public void setInvoiceDocDate_To(Date invoiceDocDate_To) {
        this.invoiceDocDate_To = invoiceDocDate_To;
    }

    public Float getExpectedAmount() {
        return this.expectedAmount;
    }

    public Float getExpectedAmount_From() {
        return this.expectedAmount_From;
    }

    public Float getExpectedAmount_To() {
        return this.expectedAmount_To;
    }

    public void setExpectedAmount(Float expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public void setExpectedAmount_From(Float expectedAmount_From) {
        this.expectedAmount_From = expectedAmount_From;
    }

    public void setExpectedAmount_To(Float expectedAmount_To) {
        this.expectedAmount_To = expectedAmount_To;
    }

    public Float getPayedAmount() {
        return this.payedAmount;
    }

    public Float getPayedAmount_From() {
        return this.payedAmount_From;
    }

    public Float getPayedAmount_To() {
        return this.payedAmount_To;
    }

    public void setPayedAmount(Float payedAmount) {
        this.payedAmount = payedAmount;
    }

    public void setPayedAmount_From(Float payedAmount_From) {
        this.payedAmount_From = payedAmount_From;
    }

    public void setPayedAmount_To(Float payedAmount_To) {
        this.payedAmount_To = payedAmount_To;
    }

    public Float getDueAmount() {
        return this.dueAmount;
    }

    public Float getDueAmount_From() {
        return this.dueAmount_From;
    }

    public Float getDueAmount_To() {
        return this.dueAmount_To;
    }

    public void setDueAmount(Float dueAmount) {
        this.dueAmount = dueAmount;
    }

    public void setDueAmount_From(Float dueAmount_From) {
        this.dueAmount_From = dueAmount_From;
    }

    public void setDueAmount_To(Float dueAmount_To) {
        this.dueAmount_To = dueAmount_To;
    }

    public Float getAmount() {
        return this.amount;
    }

    public Float getAmount_From() {
        return this.amount_From;
    }

    public Float getAmount_To() {
        return this.amount_To;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setAmount_From(Float amount_From) {
        this.amount_From = amount_From;
    }

    public void setAmount_To(Float amount_To) {
        this.amount_To = amount_To;
    }

}
