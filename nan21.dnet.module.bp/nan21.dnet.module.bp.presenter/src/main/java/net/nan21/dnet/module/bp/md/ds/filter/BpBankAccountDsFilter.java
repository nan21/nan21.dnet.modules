/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class BpBankAccountDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

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
