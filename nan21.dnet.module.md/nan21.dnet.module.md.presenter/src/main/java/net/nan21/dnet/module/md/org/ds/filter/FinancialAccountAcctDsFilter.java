/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class FinancialAccountAcctDsFilter extends AbstractAuditableDsFilter {

    private Long financialAccountId;

    private Long financialAccountId_From;
    private Long financialAccountId_To;

    private String financialAccount;

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
