/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxAcct;

@Ds(entity = TaxAcct.class)
public class TaxAcctDs extends AbstractAuditableDs<TaxAcct> {

    public static final String fTAXID = "taxId";
    public static final String fTAX = "tax";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fSALESACCOUNTID = "salesAccountId";
    public static final String fSALESACCOUNT = "salesAccount";
    public static final String fSALESACCOUNTNAME = "salesAccountName";
    public static final String fPURCHASEACCOUNTID = "purchaseAccountId";
    public static final String fPURCHASEACCOUNT = "purchaseAccount";
    public static final String fPURCHASEACCOUNTNAME = "purchaseAccountName";
    public static final String fNONDEDUCTACCOUNTID = "nonDeductAccountId";
    public static final String fNONDEDUCTACCOUNT = "nonDeductAccount";
    public static final String fNONDEDUCTACCOUNTNAME = "nonDeductAccountName";

    @DsField(join = "left", path = "tax.id")
    private Long taxId;

    @DsField(join = "left", path = "tax.name")
    private String tax;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "salesAccount.id")
    private Long salesAccountId;

    @DsField(join = "left", path = "salesAccount.code")
    private String salesAccount;

    @DsField(join = "left", path = "salesAccount.name")
    private String salesAccountName;

    @DsField(join = "left", path = "purchaseAccount.id")
    private Long purchaseAccountId;

    @DsField(join = "left", path = "purchaseAccount.code")
    private String purchaseAccount;

    @DsField(join = "left", path = "purchaseAccount.name")
    private String purchaseAccountName;

    @DsField(join = "left", path = "nonDeductAccount.id")
    private Long nonDeductAccountId;

    @DsField(join = "left", path = "nonDeductAccount.code")
    private String nonDeductAccount;

    @DsField(join = "left", path = "nonDeductAccount.name")
    private String nonDeductAccountName;

    public TaxAcctDs() {
        super();
    }

    public TaxAcctDs(TaxAcct e) {
        super(e);
    }

    public Long getTaxId() {
        return this.taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
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

    public Long getSalesAccountId() {
        return this.salesAccountId;
    }

    public void setSalesAccountId(Long salesAccountId) {
        this.salesAccountId = salesAccountId;
    }

    public String getSalesAccount() {
        return this.salesAccount;
    }

    public void setSalesAccount(String salesAccount) {
        this.salesAccount = salesAccount;
    }

    public String getSalesAccountName() {
        return this.salesAccountName;
    }

    public void setSalesAccountName(String salesAccountName) {
        this.salesAccountName = salesAccountName;
    }

    public Long getPurchaseAccountId() {
        return this.purchaseAccountId;
    }

    public void setPurchaseAccountId(Long purchaseAccountId) {
        this.purchaseAccountId = purchaseAccountId;
    }

    public String getPurchaseAccount() {
        return this.purchaseAccount;
    }

    public void setPurchaseAccount(String purchaseAccount) {
        this.purchaseAccount = purchaseAccount;
    }

    public String getPurchaseAccountName() {
        return this.purchaseAccountName;
    }

    public void setPurchaseAccountName(String purchaseAccountName) {
        this.purchaseAccountName = purchaseAccountName;
    }

    public Long getNonDeductAccountId() {
        return this.nonDeductAccountId;
    }

    public void setNonDeductAccountId(Long nonDeductAccountId) {
        this.nonDeductAccountId = nonDeductAccountId;
    }

    public String getNonDeductAccount() {
        return this.nonDeductAccount;
    }

    public void setNonDeductAccount(String nonDeductAccount) {
        this.nonDeductAccount = nonDeductAccount;
    }

    public String getNonDeductAccountName() {
        return this.nonDeductAccountName;
    }

    public void setNonDeductAccountName(String nonDeductAccountName) {
        this.nonDeductAccountName = nonDeductAccountName;
    }

}
