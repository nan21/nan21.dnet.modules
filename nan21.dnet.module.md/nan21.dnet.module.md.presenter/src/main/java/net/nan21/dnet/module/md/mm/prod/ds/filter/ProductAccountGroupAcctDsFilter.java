/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ProductAccountGroupAcctDsFilter extends AbstractAuditableDsFilter {

    private Long groupId;

    private Long groupId_From;
    private Long groupId_To;

    private String group;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long expenseAccountId;

    private Long expenseAccountId_From;
    private Long expenseAccountId_To;

    private String expenseAccount;

    private String expenseAccountName;

    private Long revenueAccountId;

    private Long revenueAccountId_From;
    private Long revenueAccountId_To;

    private String revenueAccount;

    private String revenueAccountName;

    public Long getGroupId() {
        return this.groupId;
    }

    public Long getGroupId_From() {
        return this.groupId_From;
    }

    public Long getGroupId_To() {
        return this.groupId_To;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupId_From(Long groupId_From) {
        this.groupId_From = groupId_From;
    }

    public void setGroupId_To(Long groupId_To) {
        this.groupId_To = groupId_To;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public Long getExpenseAccountId() {
        return this.expenseAccountId;
    }

    public Long getExpenseAccountId_From() {
        return this.expenseAccountId_From;
    }

    public Long getExpenseAccountId_To() {
        return this.expenseAccountId_To;
    }

    public void setExpenseAccountId(Long expenseAccountId) {
        this.expenseAccountId = expenseAccountId;
    }

    public void setExpenseAccountId_From(Long expenseAccountId_From) {
        this.expenseAccountId_From = expenseAccountId_From;
    }

    public void setExpenseAccountId_To(Long expenseAccountId_To) {
        this.expenseAccountId_To = expenseAccountId_To;
    }

    public String getExpenseAccount() {
        return this.expenseAccount;
    }

    public void setExpenseAccount(String expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public String getExpenseAccountName() {
        return this.expenseAccountName;
    }

    public void setExpenseAccountName(String expenseAccountName) {
        this.expenseAccountName = expenseAccountName;
    }

    public Long getRevenueAccountId() {
        return this.revenueAccountId;
    }

    public Long getRevenueAccountId_From() {
        return this.revenueAccountId_From;
    }

    public Long getRevenueAccountId_To() {
        return this.revenueAccountId_To;
    }

    public void setRevenueAccountId(Long revenueAccountId) {
        this.revenueAccountId = revenueAccountId;
    }

    public void setRevenueAccountId_From(Long revenueAccountId_From) {
        this.revenueAccountId_From = revenueAccountId_From;
    }

    public void setRevenueAccountId_To(Long revenueAccountId_To) {
        this.revenueAccountId_To = revenueAccountId_To;
    }

    public String getRevenueAccount() {
        return this.revenueAccount;
    }

    public void setRevenueAccount(String revenueAccount) {
        this.revenueAccount = revenueAccount;
    }

    public String getRevenueAccountName() {
        return this.revenueAccountName;
    }

    public void setRevenueAccountName(String revenueAccountName) {
        this.revenueAccountName = revenueAccountName;
    }

}
