/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.org.domain.entity.PayAccountMethod;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayAccountMethod.class)
public class PayAccountMethodDs extends AbstractAuditableDs<PayAccountMethod> {

    public static final String fPAYACCOUNTID = "payAccountId";
    public static final String fPAYACCOUNT = "payAccount";
    public static final String fPAYACCOUNTTYPE = "payAccountType";
    public static final String fPAYMETHODID = "payMethodId";
    public static final String fPAYMETHOD = "payMethod";
    public static final String fALLOWPAYIN = "allowPayIn";
    public static final String fALLOWPAYOUT = "allowPayOut";

    @DsField(join = "left", path = "payAccount.id")
    private Long payAccountId;

    @DsField(join = "left", path = "payAccount.name")
    private String payAccount;

    @DsField(join = "left", path = "payAccount.type")
    private String payAccountType;

    @DsField(join = "left", path = "payMethod.id")
    private Long payMethodId;

    @DsField(join = "left", path = "payMethod.name")
    private String payMethod;

    @DsField()
    private Boolean allowPayIn;

    @DsField()
    private Boolean allowPayOut;

    public PayAccountMethodDs() {
        super();
    }

    public PayAccountMethodDs(PayAccountMethod e) {
        super(e);
    }

    public Long getPayAccountId() {
        return this.payAccountId;
    }

    public void setPayAccountId(Long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public String getPayAccount() {
        return this.payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayAccountType() {
        return this.payAccountType;
    }

    public void setPayAccountType(String payAccountType) {
        this.payAccountType = payAccountType;
    }

    public Long getPayMethodId() {
        return this.payMethodId;
    }

    public void setPayMethodId(Long payMethodId) {
        this.payMethodId = payMethodId;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Boolean getAllowPayIn() {
        return this.allowPayIn;
    }

    public void setAllowPayIn(Boolean allowPayIn) {
        this.allowPayIn = allowPayIn;
    }

    public Boolean getAllowPayOut() {
        return this.allowPayOut;
    }

    public void setAllowPayOut(Boolean allowPayOut) {
        this.allowPayOut = allowPayOut;
    }

}
