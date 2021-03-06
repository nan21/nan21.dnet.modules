/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetAcct;

@Ds(entity = AssetAcct.class)
public class AssetAcctDs extends AbstractAuditableDs<AssetAcct> {

    public static final String fASSETID = "assetId";
    public static final String fASSET = "asset";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fDEPRECACCOUNTID = "deprecAccountId";
    public static final String fDEPRECACCOUNT = "deprecAccount";
    public static final String fACMLDEPRECACCOUNTID = "acmlDeprecAccountId";
    public static final String fACMLDEPRECACCOUNT = "acmlDeprecAccount";

    @DsField(join = "left", path = "asset.id")
    private Long assetId;

    @DsField(join = "left", path = "asset.code")
    private String asset;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "deprecAccount.id")
    private Long deprecAccountId;

    @DsField(join = "left", path = "deprecAccount.code")
    private String deprecAccount;

    @DsField(join = "left", path = "acmlDeprecAccount.id")
    private Long acmlDeprecAccountId;

    @DsField(join = "left", path = "acmlDeprecAccount.code")
    private String acmlDeprecAccount;

    public AssetAcctDs() {
        super();
    }

    public AssetAcctDs(AssetAcct e) {
        super(e);
    }

    public Long getAssetId() {
        return this.assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAsset() {
        return this.asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
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

    public Long getDeprecAccountId() {
        return this.deprecAccountId;
    }

    public void setDeprecAccountId(Long deprecAccountId) {
        this.deprecAccountId = deprecAccountId;
    }

    public String getDeprecAccount() {
        return this.deprecAccount;
    }

    public void setDeprecAccount(String deprecAccount) {
        this.deprecAccount = deprecAccount;
    }

    public Long getAcmlDeprecAccountId() {
        return this.acmlDeprecAccountId;
    }

    public void setAcmlDeprecAccountId(Long acmlDeprecAccountId) {
        this.acmlDeprecAccountId = acmlDeprecAccountId;
    }

    public String getAcmlDeprecAccount() {
        return this.acmlDeprecAccount;
    }

    public void setAcmlDeprecAccount(String acmlDeprecAccount) {
        this.acmlDeprecAccount = acmlDeprecAccount;
    }

}
