/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AmortizationItemDsFilter extends AbstractAuditableDsFilter {

    private Long assetId;

    private Long assetId_From;
    private Long assetId_To;

    private String asset;

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    private Long currencyId;

    private Long currencyId_From;
    private Long currencyId_To;

    private String currency;

    private Float amount;

    private Float amount_From;
    private Float amount_To;

    private Float percentage;

    private Float percentage_From;
    private Float percentage_To;

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

    public Long getOrgId() {
        return this.orgId;
    }

    public Long getOrgId_From() {
        return this.orgId_From;
    }

    public Long getOrgId_To() {
        return this.orgId_To;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgId_From(Long orgId_From) {
        this.orgId_From = orgId_From;
    }

    public void setOrgId_To(Long orgId_To) {
        this.orgId_To = orgId_To;
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

    public Long getCategoryId_From() {
        return this.categoryId_From;
    }

    public Long getCategoryId_To() {
        return this.categoryId_To;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryId_From(Long categoryId_From) {
        this.categoryId_From = categoryId_From;
    }

    public void setCategoryId_To(Long categoryId_To) {
        this.categoryId_To = categoryId_To;
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

    public Long getCurrencyId_From() {
        return this.currencyId_From;
    }

    public Long getCurrencyId_To() {
        return this.currencyId_To;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyId_From(Long currencyId_From) {
        this.currencyId_From = currencyId_From;
    }

    public void setCurrencyId_To(Long currencyId_To) {
        this.currencyId_To = currencyId_To;
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

    public Float getAmount_From() {
        return this.amount_From;
    }

    public Float getAmount_To() {
        return this.amount_To;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setAmount_From(Float amount_From) {
        this.amount_From = amount_From;
    }

    public void setAmount_To(Float amount_To) {
        this.amount_To = amount_To;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public Float getPercentage_From() {
        return this.percentage_From;
    }

    public Float getPercentage_To() {
        return this.percentage_To;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public void setPercentage_From(Float percentage_From) {
        this.percentage_From = percentage_From;
    }

    public void setPercentage_To(Float percentage_To) {
        this.percentage_To = percentage_To;
    }

}
