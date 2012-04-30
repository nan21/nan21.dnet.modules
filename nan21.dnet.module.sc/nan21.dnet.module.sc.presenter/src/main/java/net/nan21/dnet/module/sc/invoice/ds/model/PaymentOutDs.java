/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PaymentOut.class)
public class PaymentOutDs extends AbstractAuditableDs<PaymentOut> {

    public static final String fCODE = "code";
    public static final String fDOCDATE = "docDate";
    public static final String fPAYTOID = "payToId";
    public static final String fPAYTO = "payTo";
    public static final String fPAYTONAME = "payToName";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fPAYMENTMETHODID = "paymentMethodId";
    public static final String fPAYMENTMETHOD = "paymentMethod";
    public static final String fAMOUNT = "amount";
    public static final String fCONFIRMED = "confirmed";
    public static final String fPOSTED = "posted";

    @DsField()
    private String code;

    @DsField()
    private Date docDate;

    @DsField(join = "left", path = "bpartner.id")
    private Long payToId;

    @DsField(join = "left", path = "bpartner.code")
    private String payTo;

    @DsField(join = "left", path = "bpartner.name")
    private String payToName;

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField(join = "left", path = "paymentMethod.id")
    private Long paymentMethodId;

    @DsField(join = "left", path = "paymentMethod.name")
    private String paymentMethod;

    @DsField()
    private Float amount;

    @DsField()
    private Boolean confirmed;

    @DsField()
    private Boolean posted;

    public PaymentOutDs() {
        super();
    }

    public PaymentOutDs(PaymentOut e) {
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

    public Long getPayToId() {
        return this.payToId;
    }

    public void setPayToId(Long payToId) {
        this.payToId = payToId;
    }

    public String getPayTo() {
        return this.payTo;
    }

    public void setPayTo(String payTo) {
        this.payTo = payTo;
    }

    public String getPayToName() {
        return this.payToName;
    }

    public void setPayToName(String payToName) {
        this.payToName = payToName;
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
