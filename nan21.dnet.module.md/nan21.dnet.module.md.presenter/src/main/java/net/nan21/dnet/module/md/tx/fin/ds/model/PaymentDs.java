/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Payment.class)
public class PaymentDs extends AbstractAuditableDs<Payment> {

    public static final String fCODE = "code";
    public static final String fDOCNO = "docNo";
    public static final String fDOCDATE = "docDate";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";
    public static final String fFROMORGID = "fromOrgId";
    public static final String fFROMORG = "fromOrg";
    public static final String fTOORGID = "toOrgId";
    public static final String fTOORG = "toOrg";
    public static final String fFROMACCOUNTID = "fromAccountId";
    public static final String fFROMACCOUNT = "fromAccount";
    public static final String fTOACCOUNTID = "toAccountId";
    public static final String fTOACCOUNT = "toAccount";
    public static final String fBUSINESSPARTNERID = "businessPartnerId";
    public static final String fBUSINESSPARTNER = "businessPartner";
    public static final String fAMOUNT = "amount";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";

    @DsField()
    private String code;

    @DsField()
    private String docNo;

    @DsField()
    private Date docDate;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField(join = "left", path = "paymentMethod.id")
    private Long paymentMethodId;

    @DsField(join = "left", path = "paymentMethod.name")
    private String paymentMethod;

    @DsField(join = "left", path = "fromOrg.id")
    private Long fromOrgId;

    @DsField(join = "left", path = "fromOrg.code")
    private String fromOrg;

    @DsField(join = "left", path = "toOrg.id")
    private Long toOrgId;

    @DsField(join = "left", path = "toOrg.code")
    private String toOrg;

    @DsField(join = "left", path = "fromAccount.id")
    private Long fromAccountId;

    @DsField(join = "left", path = "fromAccount.name")
    private String fromAccount;

    @DsField(join = "left", path = "toAccount.id")
    private Long toAccountId;

    @DsField(join = "left", path = "toAccount.name")
    private String toAccount;

    @DsField(join = "left", path = "bpartner.id")
    private Long businessPartnerId;

    @DsField(join = "left", path = "bpartner.name")
    private String businessPartner;

    @DsField()
    private Float amount;

    @DsField()
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    public PaymentDs() {
        super();
    }

    public PaymentDs(Payment e) {
        super(e);
    }

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

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
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

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
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

    public void setFromOrgId(Long fromOrgId) {
        this.fromOrgId = fromOrgId;
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

    public void setToOrgId(Long toOrgId) {
        this.toOrgId = toOrgId;
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

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
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

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
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

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
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

    public void setAmount(Float amount) {
        this.amount = amount;
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
