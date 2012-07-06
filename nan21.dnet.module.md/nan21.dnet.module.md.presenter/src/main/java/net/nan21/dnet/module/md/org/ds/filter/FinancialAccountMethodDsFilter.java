/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class FinancialAccountMethodDsFilter extends AbstractAuditableDsFilter {

    private Long financialAccountId;

    private Long financialAccountId_From;
    private Long financialAccountId_To;

    private String financialAccount;

    private String financialAccountType;

    private Long payMethodId;

    private Long payMethodId_From;
    private Long payMethodId_To;

    private String payMethod;

    private Boolean allowPayIn;

    private Boolean allowPayOut;

    public Long getFinancialAccountId() {
        return this.financialAccountId;
    }

    public Long getFinancialAccountId_From() {
        return this.financialAccountId_From;
    }

    public Long getFinancialAccountId_To() {
        return this.financialAccountId_To;
    }

    public void setFinancialAccountId(Long financialAccountId) {
        this.financialAccountId = financialAccountId;
    }

    public void setFinancialAccountId_From(Long financialAccountId_From) {
        this.financialAccountId_From = financialAccountId_From;
    }

    public void setFinancialAccountId_To(Long financialAccountId_To) {
        this.financialAccountId_To = financialAccountId_To;
    }

    public String getFinancialAccount() {
        return this.financialAccount;
    }

    public void setFinancialAccount(String financialAccount) {
        this.financialAccount = financialAccount;
    }

    public String getFinancialAccountType() {
        return this.financialAccountType;
    }

    public void setFinancialAccountType(String financialAccountType) {
        this.financialAccountType = financialAccountType;
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
