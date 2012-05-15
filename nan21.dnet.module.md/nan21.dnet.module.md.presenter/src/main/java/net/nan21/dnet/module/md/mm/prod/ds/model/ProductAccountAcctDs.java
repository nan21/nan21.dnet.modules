/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAccountAcct.class)
public class ProductAccountAcctDs extends
        AbstractAuditableDs<ProductAccountAcct> {

    public static final String fPRODACCOUNTID = "prodAccountId";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fEXPENSEACCOUNTID = "expenseAccountId";
    public static final String fEXPENSEACCOUNT = "expenseAccount";
    public static final String fREVENUEACCOUNTID = "revenueAccountId";
    public static final String fREVENUEACCOUNT = "revenueAccount";

    @DsField(join = "left", path = "prodAccount.id")
    private Long prodAccountId;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "expenseAccount.id")
    private Long expenseAccountId;

    @DsField(join = "left", path = "expenseAccount.code")
    private String expenseAccount;

    @DsField(join = "left", path = "revenueAccount.id")
    private Long revenueAccountId;

    @DsField(join = "left", path = "revenueAccount.code")
    private String revenueAccount;

    public ProductAccountAcctDs() {
        super();
    }

    public ProductAccountAcctDs(ProductAccountAcct e) {
        super(e);
    }

    public Long getProdAccountId() {
        return this.prodAccountId;
    }

    public void setProdAccountId(Long prodAccountId) {
        this.prodAccountId = prodAccountId;
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

}
