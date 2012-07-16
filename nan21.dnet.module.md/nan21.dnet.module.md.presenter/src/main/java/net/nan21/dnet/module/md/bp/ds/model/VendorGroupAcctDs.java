/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

@Ds(entity = VendorGroupAcct.class)
public class VendorGroupAcctDs extends AbstractAuditableDs<VendorGroupAcct> {

    public static final String fVENDORGROUPID = "vendorGroupId";
    public static final String fVENDORGROUP = "vendorGroup";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fPURCHASEACCOUNTID = "purchaseAccountId";
    public static final String fPURCHASEACCOUNT = "purchaseAccount";
    public static final String fPURCHASEACCOUNTNAME = "purchaseAccountName";
    public static final String fPREPAYACCOUNTID = "prepayAccountId";
    public static final String fPREPAYACCOUNT = "prepayAccount";
    public static final String fPREPAYACCOUNTNAME = "prepayAccountName";

    @DsField(join = "left", path = "vendorGroup.id")
    private Long vendorGroupId;

    @DsField(join = "left", path = "vendorGroup.code")
    private String vendorGroup;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "purchaseAccount.id")
    private Long purchaseAccountId;

    @DsField(join = "left", path = "purchaseAccount.code")
    private String purchaseAccount;

    @DsField(join = "left", path = "purchaseAccount.name")
    private String purchaseAccountName;

    @DsField(join = "left", path = "prepayAccount.id")
    private Long prepayAccountId;

    @DsField(join = "left", path = "prepayAccount.code")
    private String prepayAccount;

    @DsField(join = "left", path = "prepayAccount.name")
    private String prepayAccountName;

    public VendorGroupAcctDs() {
        super();
    }

    public VendorGroupAcctDs(VendorGroupAcct e) {
        super(e);
    }

    public Long getVendorGroupId() {
        return this.vendorGroupId;
    }

    public void setVendorGroupId(Long vendorGroupId) {
        this.vendorGroupId = vendorGroupId;
    }

    public String getVendorGroup() {
        return this.vendorGroup;
    }

    public void setVendorGroup(String vendorGroup) {
        this.vendorGroup = vendorGroup;
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

    public Long getPrepayAccountId() {
        return this.prepayAccountId;
    }

    public void setPrepayAccountId(Long prepayAccountId) {
        this.prepayAccountId = prepayAccountId;
    }

    public String getPrepayAccount() {
        return this.prepayAccount;
    }

    public void setPrepayAccount(String prepayAccount) {
        this.prepayAccount = prepayAccount;
    }

    public String getPrepayAccountName() {
        return this.prepayAccountName;
    }

    public void setPrepayAccountName(String prepayAccountName) {
        this.prepayAccountName = prepayAccountName;
    }

}
