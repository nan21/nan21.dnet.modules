/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentIn.class)
public class PaymentInDs extends AbstractAuditableDs<PaymentIn> {

    public static final String fCODE = "code";
    public static final String fDOCDATE = "docDate";
    public static final String fDOCNO = "docNo";
    public static final String fPAYFROMID = "payFromId";
    public static final String fPAYFROM = "payFrom";
    public static final String fPAYFROMNAME = "payFromName";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fTOACCOUNTID = "toAccountId";
    public static final String fTOACCOUNT = "toAccount";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";
    public static final String fPAYMENTMETHODTYPE = "paymentMethodType";
    public static final String fAMOUNT = "amount";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";

    @DsField()
    private String code;

    @DsField()
    private Date docDate;

    @DsField()
    private String docNo;

    @DsField(join = "left", path = "bpartner.id")
    private Long payFromId;

    @DsField(join = "left", path = "bpartner.code")
    private String payFrom;

    @DsField(join = "left", path = "bpartner.name")
    private String payFromName;

    @DsField(join = "left", path = "toOrg.id")
    private Long orgId;

    @DsField(join = "left", path = "toOrg.code")
    private String org;

    @DsField(join = "left", path = "toAccount.id")
    private Long toAccountId;

    @DsField(join = "left", path = "toAccount.name")
    private String toAccount;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField(join = "left", path = "paymentMethod.id")
    private Long paymentMethodId;

    @DsField(join = "left", path = "paymentMethod.name")
    private String paymentMethod;

    @DsField(join = "left", path = "paymentMethod.type")
    private String paymentMethodType;

    @DsField()
    private Float amount;

    @DsField()
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    public PaymentInDs() {
        super();
    }

    public PaymentInDs(PaymentIn e) {
        super(e);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
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

    public void setPayFromId(Long payFromId) {
        this.payFromId = payFromId;
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

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
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

    public String getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
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
