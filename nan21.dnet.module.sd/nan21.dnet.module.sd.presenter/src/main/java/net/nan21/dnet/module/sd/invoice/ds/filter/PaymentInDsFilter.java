/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PaymentInDsFilter extends AbstractAuditableDsFilter {

    private String code;

    private Date docDate;

    private Date docDate_From;
    private Date docDate_To;

    private String docNo;

    private Long payFromId;

    private Long payFromId_From;
    private Long payFromId_To;

    private String payFrom;

    private String payFromName;

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    private Long toAccountId;

    private Long toAccountId_From;
    private Long toAccountId_To;

    private String toAccount;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currency;

    private Long paymentMethodId;

    private Long paymentMethodId_From;
    private Long paymentMethodId_To;

    private String paymentMethod;

    private String paymentMethodType;

    private Float amount;

    private Float amount_From;
    private Float amount_To;

    private Boolean confirmed;

    private Boolean posted;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public Date getDocDate_From() {
        return this.docDate_From;
    }

    public Date getDocDate_To() {
        return this.docDate_To;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setDocDate_From(Date docDate_From) {
        this.docDate_From = docDate_From;
    }

    public void setDocDate_To(Date docDate_To) {
        this.docDate_To = docDate_To;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Long getPayFromId() {
        return this.payFromId;
    }

    public Long getPayFromId_From() {
        return this.payFromId_From;
    }

    public Long getPayFromId_To() {
        return this.payFromId_To;
    }

    public void setPayFromId(Long payFromId) {
        this.payFromId = payFromId;
    }

    public void setPayFromId_From(Long payFromId_From) {
        this.payFromId_From = payFromId_From;
    }

    public void setPayFromId_To(Long payFromId_To) {
        this.payFromId_To = payFromId_To;
    }

    public String getPayFrom() {
        return this.payFrom;
    }

    public void setPayFrom(String payFrom) {
        this.payFrom = payFrom;
    }

    public String getPayFromName() {
        return this.payFromName;
    }

    public void setPayFromName(String payFromName) {
        this.payFromName = payFromName;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public Long getOrgId_From() {
        return this.orgId_From;
    }

    public Long getOrgId_To() {
        return this.orgId_To;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgId_From(Long orgId_From) {
        this.orgId_From = orgId_From;
    }

    public void setOrgId_To(Long orgId_To) {
        this.orgId_To = orgId_To;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getToAccountId() {
        return this.toAccountId;
    }

    public Long getToAccountId_From() {
        return this.toAccountId_From;
    }

    public Long getToAccountId_To() {
        return this.toAccountId_To;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public void setToAccountId_From(Long toAccountId_From) {
        this.toAccountId_From = toAccountId_From;
    }

    public void setToAccountId_To(Long toAccountId_To) {
        this.toAccountId_To = toAccountId_To;
    }

    public String getToAccount() {
        return this.toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public Long getCurrencyId_From() {
        return this.currencyId_From;
    }

    public Long getCurrencyId_To() {
        return this.currencyId_To;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyId_From(Long currencyId_From) {
        this.currencyId_From = currencyId_From;
    }

    public void setCurrencyId_To(Long currencyId_To) {
        this.currencyId_To = currencyId_To;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
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

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

}
