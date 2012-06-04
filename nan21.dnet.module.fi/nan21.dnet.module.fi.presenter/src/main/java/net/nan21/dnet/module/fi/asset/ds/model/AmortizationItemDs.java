/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.fi.asset.domain.entity.AmortizationItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AmortizationItem.class)
public class AmortizationItemDs extends AbstractAuditableDs<AmortizationItem> {

    public static final String fASSETID = "assetId";
    public static final String fASSET = "asset";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fCATEGORYID = "categoryId";
    public static final String fCATEGORY = "category";
    public static final String fCURRENCYID = "currencyId";
    public static final String fCURRENCY = "currency";
    public static final String fAMOUNT = "amount";
    public static final String fPERCENTAGE = "percentage";

    @DsField(join = "left", path = "asset.id")
    private Long assetId;

    @DsField(join = "left", path = "asset.code")
    private String asset;

    @DsField(join = "left", path = "asset.org.id")
    private Long orgId;

    @DsField(join = "left", path = "asset.org.code")
    private String org;

    @DsField(join = "left", path = "asset.category.id")
    private Long categoryId;

    @DsField(join = "left", path = "asset.category.code")
    private String category;

    @DsField(join = "left", path = "currency.id")
    private Long currencyId;

    @DsField(join = "left", path = "currency.code")
    private String currency;

    @DsField()
    private Float amount;

    @DsField()
    private Float percentage;

    public AmortizationItemDs() {
        super();
    }

    public AmortizationItemDs(AmortizationItem e) {
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

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
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

}
