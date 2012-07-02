/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AssetAcctDsFilter extends AbstractAuditableDsFilter {

    private Long assetId;

    private Long assetId_From;
    private Long assetId_To;

    private String asset;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long deprecAccountId;

    private Long deprecAccountId_From;
    private Long deprecAccountId_To;

    private String deprecAccount;

    private Long acmlDeprecAccountId;

    private Long acmlDeprecAccountId_From;
    private Long acmlDeprecAccountId_To;

    private String acmlDeprecAccount;

    public Long getAssetId() {
        return this.assetId;
    }

    public Long getAssetId_From() {
        return this.assetId_From;
    }

    public Long getAssetId_To() {
        return this.assetId_To;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public void setAssetId_From(Long assetId_From) {
        this.assetId_From = assetId_From;
    }

    public void setAssetId_To(Long assetId_To) {
        this.assetId_To = assetId_To;
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

    public Long getDeprecAccountId() {
        return this.deprecAccountId;
    }

    public Long getDeprecAccountId_From() {
        return this.deprecAccountId_From;
    }

    public Long getDeprecAccountId_To() {
        return this.deprecAccountId_To;
    }

    public void setDeprecAccountId(Long deprecAccountId) {
        this.deprecAccountId = deprecAccountId;
    }

    public void setDeprecAccountId_From(Long deprecAccountId_From) {
        this.deprecAccountId_From = deprecAccountId_From;
    }

    public void setDeprecAccountId_To(Long deprecAccountId_To) {
        this.deprecAccountId_To = deprecAccountId_To;
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

    public Long getAcmlDeprecAccountId_From() {
        return this.acmlDeprecAccountId_From;
    }

    public Long getAcmlDeprecAccountId_To() {
        return this.acmlDeprecAccountId_To;
    }

    public void setAcmlDeprecAccountId(Long acmlDeprecAccountId) {
        this.acmlDeprecAccountId = acmlDeprecAccountId;
    }

    public void setAcmlDeprecAccountId_From(Long acmlDeprecAccountId_From) {
        this.acmlDeprecAccountId_From = acmlDeprecAccountId_From;
    }

    public void setAcmlDeprecAccountId_To(Long acmlDeprecAccountId_To) {
        this.acmlDeprecAccountId_To = acmlDeprecAccountId_To;
    }

    public String getAcmlDeprecAccount() {
        return this.acmlDeprecAccount;
    }

    public void setAcmlDeprecAccount(String acmlDeprecAccount) {
        this.acmlDeprecAccount = acmlDeprecAccount;
    }

}
