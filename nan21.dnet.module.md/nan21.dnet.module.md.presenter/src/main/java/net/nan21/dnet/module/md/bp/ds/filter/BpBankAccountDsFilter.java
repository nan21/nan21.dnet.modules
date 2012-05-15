/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class BpBankAccountDsFilter extends AbstractAuditableDsFilter {

    private Long bpartnerId;

    private Long bpartnerId_From;
    private Long bpartnerId_To;

    private String bpartnerCode;

    private Long bankId;

    private Long bankId_From;
    private Long bankId_To;

    private String bankCode;

    private String bankBranch;

    private String accountNo;

    private Boolean ibanAccount;

    private Boolean active;

    private String notes;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currencyCode;

    public Long getBpartnerId() {
        return this.bpartnerId;
    }

    public Long getBpartnerId_From() {
        return this.bpartnerId_From;
    }

    public Long getBpartnerId_To() {
        return this.bpartnerId_To;
    }

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
    }

    public void setBpartnerId_From(Long bpartnerId_From) {
        this.bpartnerId_From = bpartnerId_From;
    }

    public void setBpartnerId_To(Long bpartnerId_To) {
        this.bpartnerId_To = bpartnerId_To;
    }

    public String getBpartnerCode() {
        return this.bpartnerCode;
    }

    public void setBpartnerCode(String bpartnerCode) {
        this.bpartnerCode = bpartnerCode;
    }

    public Long getBankId() {
        return this.bankId;
    }

    public Long getBankId_From() {
        return this.bankId_From;
    }

    public Long getBankId_To() {
        return this.bankId_To;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public void setBankId_From(Long bankId_From) {
        this.bankId_From = bankId_From;
    }

    public void setBankId_To(Long bankId_To) {
        this.bankId_To = bankId_To;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankBranch() {
        return this.bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Boolean getIbanAccount() {
        return this.ibanAccount;
    }

    public void setIbanAccount(Boolean ibanAccount) {
        this.ibanAccount = ibanAccount;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
