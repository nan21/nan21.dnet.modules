/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PaymentItemAccItemDsFilter extends AbstractAuditableDsFilter {

    private Long paymentId;

    private Long paymentId_From;
    private Long paymentId_To;

    private Long accItemId;

    private Long accItemId_From;
    private Long accItemId_To;

    private String accItem;

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

    public Long getAccItemId() {
        return this.accItemId;
    }

    public Long getAccItemId_From() {
        return this.accItemId_From;
    }

    public Long getAccItemId_To() {
        return this.accItemId_To;
    }

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
    }

    public void setAccItemId_From(Long accItemId_From) {
        this.accItemId_From = accItemId_From;
    }

    public void setAccItemId_To(Long accItemId_To) {
        this.accItemId_To = accItemId_To;
    }

    public String getAccItem() {
        return this.accItem;
    }

    public void setAccItem(String accItem) {
        this.accItem = accItem;
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
