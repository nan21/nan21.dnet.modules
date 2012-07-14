/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAccountGroupAcct.class)
public class ProductAccountGroupAcctDs extends
        AbstractAuditableDs<ProductAccountGroupAcct> {

    public static final String fGROUPID = "groupId";
    public static final String fGROUP = "group";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fEXPENSEACCOUNTID = "expenseAccountId";
    public static final String fEXPENSEACCOUNT = "expenseAccount";
    public static final String fEXPENSEACCOUNTNAME = "expenseAccountName";
    public static final String fREVENUEACCOUNTID = "revenueAccountId";
    public static final String fREVENUEACCOUNT = "revenueAccount";
    public static final String fREVENUEACCOUNTNAME = "revenueAccountName";

    @DsField(join = "left", path = "group.id")
    private Long groupId;

    @DsField(join = "left", path = "group.code")
    private String group;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "expenseAccount.id")
    private Long expenseAccountId;

    @DsField(join = "left", path = "expenseAccount.code")
    private String expenseAccount;

    @DsField(join = "left", path = "expenseAccount.name")
    private String expenseAccountName;

    @DsField(join = "left", path = "revenueAccount.id")
    private Long revenueAccountId;

    @DsField(join = "left", path = "revenueAccount.code")
    private String revenueAccount;

    @DsField(join = "left", path = "revenueAccount.name")
    private String revenueAccountName;

    public ProductAccountGroupAcctDs() {
        super();
    }

    public ProductAccountGroupAcctDs(ProductAccountGroupAcct e) {
        super(e);
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
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

    public void setExpenseAccountId(Long expenseAccountId) {
        this.expenseAccountId = expenseAccountId;
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

    public void setRevenueAccountId(Long revenueAccountId) {
        this.revenueAccountId = revenueAccountId;
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
