/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PayAccountAcctDsFilter extends AbstractAuditableDsFilter {

    private Long payAccountId;

    private Long payAccountId_From;
    private Long payAccountId_To;

    private String payAccount;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long depositAccountId;

    private Long depositAccountId_From;
    private Long depositAccountId_To;

    private String depositAccount;

    private Long withdrawalAccountId;

    private Long withdrawalAccountId_From;
    private Long withdrawalAccountId_To;

    private String withdrawalAccount;

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

    public Long getAccSchemaId() {
        return this.accSchemaId;
    }

    public Long getAccSchemaId_From() {
        return this.accSchemaId_From;
    }

    public Long getAccSchemaId_To() {
        return this.accSchemaId_To;
    }

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
    }

    public void setAccSchemaId_From(Long accSchemaId_From) {
        this.accSchemaId_From = accSchemaId_From;
    }

    public void setAccSchemaId_To(Long accSchemaId_To) {
        this.accSchemaId_To = accSchemaId_To;
    }

    public String getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(String accSchema) {
        this.accSchema = accSchema;
    }

    public Long getDepositAccountId() {
        return this.depositAccountId;
    }

    public Long getDepositAccountId_From() {
        return this.depositAccountId_From;
    }

    public Long getDepositAccountId_To() {
        return this.depositAccountId_To;
    }

    public void setDepositAccountId(Long depositAccountId) {
        this.depositAccountId = depositAccountId;
    }

    public void setDepositAccountId_From(Long depositAccountId_From) {
        this.depositAccountId_From = depositAccountId_From;
    }

    public void setDepositAccountId_To(Long depositAccountId_To) {
        this.depositAccountId_To = depositAccountId_To;
    }

    public String getDepositAccount() {
        return this.depositAccount;
    }

    public void setDepositAccount(String depositAccount) {
        this.depositAccount = depositAccount;
    }

    public Long getWithdrawalAccountId() {
        return this.withdrawalAccountId;
    }

    public Long getWithdrawalAccountId_From() {
        return this.withdrawalAccountId_From;
    }

    public Long getWithdrawalAccountId_To() {
        return this.withdrawalAccountId_To;
    }

    public void setWithdrawalAccountId(Long withdrawalAccountId) {
        this.withdrawalAccountId = withdrawalAccountId;
    }

    public void setWithdrawalAccountId_From(Long withdrawalAccountId_From) {
        this.withdrawalAccountId_From = withdrawalAccountId_From;
    }

    public void setWithdrawalAccountId_To(Long withdrawalAccountId_To) {
        this.withdrawalAccountId_To = withdrawalAccountId_To;
    }

    public String getWithdrawalAccount() {
        return this.withdrawalAccount;
    }

    public void setWithdrawalAccount(String withdrawalAccount) {
        this.withdrawalAccount = withdrawalAccount;
    }

}
