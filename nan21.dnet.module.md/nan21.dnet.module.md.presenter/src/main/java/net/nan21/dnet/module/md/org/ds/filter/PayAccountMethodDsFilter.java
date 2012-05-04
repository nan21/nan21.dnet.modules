/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PayAccountMethodDsFilter extends AbstractAuditableDsFilter {

    private Long payAccountId;

    private Long payAccountId_From;
    private Long payAccountId_To;

    private String payAccount;

    private String payAccountType;

    private Long payMethodId;

    private Long payMethodId_From;
    private Long payMethodId_To;

    private String payMethod;

    private Boolean allowPayIn;

    private Boolean allowPayOut;

    public Long getPayAccountId() {
        return this.payAccountId;
    }

    public Long getPayAccountId_From() {
        return this.payAccountId_From;
    }

    public Long getPayAccountId_To() {
        return this.payAccountId_To;
    }

    public void setPayAccountId(Long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public void setPayAccountId_From(Long payAccountId_From) {
        this.payAccountId_From = payAccountId_From;
    }

    public void setPayAccountId_To(Long payAccountId_To) {
        this.payAccountId_To = payAccountId_To;
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

    public Long getPayMethodId_From() {
        return this.payMethodId_From;
    }

    public Long getPayMethodId_To() {
        return this.payMethodId_To;
    }

    public void setPayMethodId(Long payMethodId) {
        this.payMethodId = payMethodId;
    }

    public void setPayMethodId_From(Long payMethodId_From) {
        this.payMethodId_From = payMethodId_From;
    }

    public void setPayMethodId_To(Long payMethodId_To) {
        this.payMethodId_To = payMethodId_To;
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
