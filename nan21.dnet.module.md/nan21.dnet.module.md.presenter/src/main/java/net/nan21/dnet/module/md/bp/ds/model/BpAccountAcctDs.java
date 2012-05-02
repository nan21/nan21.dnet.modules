/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = BpAccountAcct.class)
public class BpAccountAcctDs extends AbstractAuditableDs<BpAccountAcct> {

    public static final String fBPACCOUNTID = "bpAccountId";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fCUSTSALESACCOUNTID = "custSalesAccountId";
    public static final String fCUSTSALESACCOUNT = "custSalesAccount";
    public static final String fCUSTPREPAYACCOUNTID = "custPrepayAccountId";
    public static final String fCUSTPREPAYACCOUNT = "custPrepayAccount";
    public static final String fVENDORPURCHASEACCOUNTID = "vendorPurchaseAccountId";
    public static final String fVENDORPURCHASEACCOUNT = "vendorPurchaseAccount";
    public static final String fVENDORPREPAYACCOUNTID = "vendorPrepayAccountId";
    public static final String fVENDORPREPAYACCOUNT = "vendorPrepayAccount";

    @DsField(join = "left", path = "bpAccount.id")
    private Long bpAccountId;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "custSalesAccount.id")
    private Long custSalesAccountId;

    @DsField(join = "left", path = "custSalesAccount.code")
    private String custSalesAccount;

    @DsField(join = "left", path = "custPrepayAccount.id")
    private Long custPrepayAccountId;

    @DsField(join = "left", path = "custPrepayAccount.code")
    private String custPrepayAccount;

    @DsField(join = "left", path = "vendorPurchaseAccount.id")
    private Long vendorPurchaseAccountId;

    @DsField(join = "left", path = "vendorPurchaseAccount.code")
    private String vendorPurchaseAccount;

    @DsField(join = "left", path = "vendorPrepayAccount.id")
    private Long vendorPrepayAccountId;

    @DsField(join = "left", path = "vendorPrepayAccount.code")
    private String vendorPrepayAccount;

    public BpAccountAcctDs() {
        super();
    }

    public BpAccountAcctDs(BpAccountAcct e) {
        super(e);
    }

    public Long getBpAccountId() {
        return this.bpAccountId;
    }

    public void setBpAccountId(Long bpAccountId) {
        this.bpAccountId = bpAccountId;
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

    public Long getCustSalesAccountId() {
        return this.custSalesAccountId;
    }

    public void setCustSalesAccountId(Long custSalesAccountId) {
        this.custSalesAccountId = custSalesAccountId;
    }

    public String getCustSalesAccount() {
        return this.custSalesAccount;
    }

    public void setCustSalesAccount(String custSalesAccount) {
        this.custSalesAccount = custSalesAccount;
    }

    public Long getCustPrepayAccountId() {
        return this.custPrepayAccountId;
    }

    public void setCustPrepayAccountId(Long custPrepayAccountId) {
        this.custPrepayAccountId = custPrepayAccountId;
    }

    public String getCustPrepayAccount() {
        return this.custPrepayAccount;
    }

    public void setCustPrepayAccount(String custPrepayAccount) {
        this.custPrepayAccount = custPrepayAccount;
    }

    public Long getVendorPurchaseAccountId() {
        return this.vendorPurchaseAccountId;
    }

    public void setVendorPurchaseAccountId(Long vendorPurchaseAccountId) {
        this.vendorPurchaseAccountId = vendorPurchaseAccountId;
    }

    public String getVendorPurchaseAccount() {
        return this.vendorPurchaseAccount;
    }

    public void setVendorPurchaseAccount(String vendorPurchaseAccount) {
        this.vendorPurchaseAccount = vendorPurchaseAccount;
    }

    public Long getVendorPrepayAccountId() {
        return this.vendorPrepayAccountId;
    }

    public void setVendorPrepayAccountId(Long vendorPrepayAccountId) {
        this.vendorPrepayAccountId = vendorPrepayAccountId;
    }

    public String getVendorPrepayAccount() {
        return this.vendorPrepayAccount;
    }

    public void setVendorPrepayAccount(String vendorPrepayAccount) {
        this.vendorPrepayAccount = vendorPrepayAccount;
    }

}
