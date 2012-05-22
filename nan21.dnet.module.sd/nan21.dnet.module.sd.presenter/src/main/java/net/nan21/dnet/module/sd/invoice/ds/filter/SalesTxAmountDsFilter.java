/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class SalesTxAmountDsFilter extends AbstractAuditableDsFilter {

    private Long invoiceId;

    private Long invoiceId_From;
    private Long invoiceId_To;

    private Long orderId;

    private Long orderId_From;
    private Long orderId_To;

    private Date dueDate;

    private Date dueDate_From;
    private Date dueDate_To;

    private Float amount;

    private Float amount_From;
    private Float amount_To;

    private Float payedAmount;

    private Float payedAmount_From;
    private Float payedAmount_To;

    private Float dueAmount;

    private Float dueAmount_From;
    private Float dueAmount_To;

    private Long paymentMethodId;

    private Long paymentMethodId_From;
    private Long paymentMethodId_To;

    private String paymentMethod;

    public Long getInvoiceId() {
        return this.invoiceId;
    }

    public Long getInvoiceId_From() {
        return this.invoiceId_From;
    }

    public Long getInvoiceId_To() {
        return this.invoiceId_To;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setInvoiceId_From(Long invoiceId_From) {
        this.invoiceId_From = invoiceId_From;
    }

    public void setInvoiceId_To(Long invoiceId_To) {
        this.invoiceId_To = invoiceId_To;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public Long getOrderId_From() {
        return this.orderId_From;
    }

    public Long getOrderId_To() {
        return this.orderId_To;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderId_From(Long orderId_From) {
        this.orderId_From = orderId_From;
    }

    public void setOrderId_To(Long orderId_To) {
        this.orderId_To = orderId_To;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public Date getDueDate_From() {
        return this.dueDate_From;
    }

    public Date getDueDate_To() {
        return this.dueDate_To;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDueDate_From(Date dueDate_From) {
        this.dueDate_From = dueDate_From;
    }

    public void setDueDate_To(Date dueDate_To) {
        this.dueDate_To = dueDate_To;
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

    public Long getPaymentMethodId() {
        return this.paymentMethodId;
    }

    public Long getPaymentMethodId_From() {
        return this.paymentMethodId_From;
    }

    public Long getPaymentMethodId_To() {
        return this.paymentMethodId_To;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public void setPaymentMethodId_From(Long paymentMethodId_From) {
        this.paymentMethodId_From = paymentMethodId_From;
    }

    public void setPaymentMethodId_To(Long paymentMethodId_To) {
        this.paymentMethodId_To = paymentMethodId_To;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
