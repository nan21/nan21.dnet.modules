/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PaymentDsFilter extends AbstractAuditableDsFilter {

    private String code;

    private String docNo;

    private Date docDate;

    private Date docDate_From;
    private Date docDate_To;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currency;

    private Long paymentMethodId;

    private Long paymentMethodId_From;
    private Long paymentMethodId_To;

    private String paymentMethod;

    private Long fromOrgId;

    private Long fromOrgId_From;
    private Long fromOrgId_To;

    private String fromOrg;

    private Long toOrgId;

    private Long toOrgId_From;
    private Long toOrgId_To;

    private String toOrg;

    private Long fromAccountId;

    private Long fromAccountId_From;
    private Long fromAccountId_To;

    private String fromAccount;

    private Long toAccountId;

    private Long toAccountId_From;
    private Long toAccountId_To;

    private String toAccount;

    private Long businessPartnerId;

    private Long businessPartnerId_From;
    private Long businessPartnerId_To;

    private String businessPartner;

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

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
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

    public Long getFromOrgId() {
        return this.fromOrgId;
    }

    public Long getFromOrgId_From() {
        return this.fromOrgId_From;
    }

    public Long getFromOrgId_To() {
        return this.fromOrgId_To;
    }

    public void setFromOrgId(Long fromOrgId) {
        this.fromOrgId = fromOrgId;
    }

    public void setFromOrgId_From(Long fromOrgId_From) {
        this.fromOrgId_From = fromOrgId_From;
    }

    public void setFromOrgId_To(Long fromOrgId_To) {
        this.fromOrgId_To = fromOrgId_To;
    }

    public String getFromOrg() {
        return this.fromOrg;
    }

    public void setFromOrg(String fromOrg) {
        this.fromOrg = fromOrg;
    }

    public Long getToOrgId() {
        return this.toOrgId;
    }

    public Long getToOrgId_From() {
        return this.toOrgId_From;
    }

    public Long getToOrgId_To() {
        return this.toOrgId_To;
    }

    public void setToOrgId(Long toOrgId) {
        this.toOrgId = toOrgId;
    }

    public void setToOrgId_From(Long toOrgId_From) {
        this.toOrgId_From = toOrgId_From;
    }

    public void setToOrgId_To(Long toOrgId_To) {
        this.toOrgId_To = toOrgId_To;
    }

    public String getToOrg() {
        return this.toOrg;
    }

    public void setToOrg(String toOrg) {
        this.toOrg = toOrg;
    }

    public Long getFromAccountId() {
        return this.fromAccountId;
    }

    public Long getFromAccountId_From() {
        return this.fromAccountId_From;
    }

    public Long getFromAccountId_To() {
        return this.fromAccountId_To;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public void setFromAccountId_From(Long fromAccountId_From) {
        this.fromAccountId_From = fromAccountId_From;
    }

    public void setFromAccountId_To(Long fromAccountId_To) {
        this.fromAccountId_To = fromAccountId_To;
    }

    public String getFromAccount() {
        return this.fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
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

    public Long getBusinessPartnerId() {
        return this.businessPartnerId;
    }

    public Long getBusinessPartnerId_From() {
        return this.businessPartnerId_From;
    }

    public Long getBusinessPartnerId_To() {
        return this.businessPartnerId_To;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public void setBusinessPartnerId_From(Long businessPartnerId_From) {
        this.businessPartnerId_From = businessPartnerId_From;
    }

    public void setBusinessPartnerId_To(Long businessPartnerId_To) {
        this.businessPartnerId_To = businessPartnerId_To;
    }

    public String getBusinessPartner() {
        return this.businessPartner;
    }

    public void setBusinessPartner(String businessPartner) {
        this.businessPartner = businessPartner;
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
