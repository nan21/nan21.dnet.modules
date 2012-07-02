/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.fi.asset.domain.entity.Amortization;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Amortization.class)
public class AmortizationDs extends AbstractAuditableDs<Amortization> {

    public static final String fASSETID = "assetId";
    public static final String fASSET = "asset";
    public static final String fASSETNAME = "assetName";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fASSETCATEGORYID = "assetCategoryId";
    public static final String fASSETCATEGORY = "assetCategory";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fAMOUNT = "amount";
    public static final String fPERCENTAGE = "percentage";
    public static final String fPERIODTYPE = "periodType";
    public static final String fPOSTINGDATE = "postingDate";

    @DsField(join = "left", path = "asset.id")
    private Long assetId;

    @DsField(join = "left", path = "asset.code")
    private String asset;

    @DsField(join = "left", path = "asset.name")
    private String assetName;

    @DsField(join = "left", path = "asset.org.id")
    private Long orgId;

    @DsField(join = "left", path = "asset.org.code")
    private String org;

    @DsField(join = "left", path = "asset.category.id")
    private Long assetCategoryId;

    @DsField(join = "left", path = "asset.category.code")
    private String assetCategory;

    @DsField(join = "left", path = "asset.currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "asset.currency.code")
    private String currency;

    @DsField()
    private Float amount;

    @DsField()
    private Float percentage;

    @DsField(join = "left", path = "asset.periodType")
    private String periodType;

    @DsField()
    private Date postingDate;

    public AmortizationDs() {
        super();
    }

    public AmortizationDs(Amortization e) {
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

    public String getAssetName() {
        return this.assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getAssetCategoryId() {
        return this.assetCategoryId;
    }

    public void setAssetCategoryId(Long assetCategoryId) {
        this.assetCategoryId = assetCategoryId;
    }

    public String getAssetCategory() {
        return this.assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    public Long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public String getPeriodType() {
        return this.periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Date getPostingDate() {
        return this.postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

}
