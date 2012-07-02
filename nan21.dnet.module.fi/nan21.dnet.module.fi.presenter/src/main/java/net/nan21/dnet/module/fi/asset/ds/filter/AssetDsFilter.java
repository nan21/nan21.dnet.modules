/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class AssetDsFilter extends AbstractTypeWithCodeDsFilter {

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

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String productName;

    private Boolean withDepreciation;

    private String method;

    private String calculation;

    private String periodType;

    private Integer periodValue;

    private Integer periodValue_From;
    private Integer periodValue_To;

    private Integer periodPercenatge;

    private Integer periodPercenatge_From;
    private Integer periodPercenatge_To;

    private Date deprecStartDate;

    private Date deprecStartDate_From;
    private Date deprecStartDate_To;

    private Date deprecEndDate;

    private Date deprecEndDate_From;
    private Date deprecEndDate_To;

    private Date purchaseDate;

    private Date purchaseDate_From;
    private Date purchaseDate_To;

    private Float initialValue;

    private Float initialValue_From;
    private Float initialValue_To;

    private Float residualValue;

    private Float residualValue_From;
    private Float residualValue_To;

    private Float depreciationAmount;

    private Float depreciationAmount_From;
    private Float depreciationAmount_To;

    private Float initialDeprecAmount;

    private Float initialDeprecAmount_From;
    private Float initialDeprecAmount_To;

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

    public Long getProductId() {
        return this.productId;
    }

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean getWithDepreciation() {
        return this.withDepreciation;
    }

    public void setWithDepreciation(Boolean withDepreciation) {
        this.withDepreciation = withDepreciation;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCalculation() {
        return this.calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getPeriodType() {
        return this.periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Integer getPeriodValue() {
        return this.periodValue;
    }

    public Integer getPeriodValue_From() {
        return this.periodValue_From;
    }

    public Integer getPeriodValue_To() {
        return this.periodValue_To;
    }

    public void setPeriodValue(Integer periodValue) {
        this.periodValue = periodValue;
    }

    public void setPeriodValue_From(Integer periodValue_From) {
        this.periodValue_From = periodValue_From;
    }

    public void setPeriodValue_To(Integer periodValue_To) {
        this.periodValue_To = periodValue_To;
    }

    public Integer getPeriodPercenatge() {
        return this.periodPercenatge;
    }

    public Integer getPeriodPercenatge_From() {
        return this.periodPercenatge_From;
    }

    public Integer getPeriodPercenatge_To() {
        return this.periodPercenatge_To;
    }

    public void setPeriodPercenatge(Integer periodPercenatge) {
        this.periodPercenatge = periodPercenatge;
    }

    public void setPeriodPercenatge_From(Integer periodPercenatge_From) {
        this.periodPercenatge_From = periodPercenatge_From;
    }

    public void setPeriodPercenatge_To(Integer periodPercenatge_To) {
        this.periodPercenatge_To = periodPercenatge_To;
    }

    public Date getDeprecStartDate() {
        return this.deprecStartDate;
    }

    public Date getDeprecStartDate_From() {
        return this.deprecStartDate_From;
    }

    public Date getDeprecStartDate_To() {
        return this.deprecStartDate_To;
    }

    public void setDeprecStartDate(Date deprecStartDate) {
        this.deprecStartDate = deprecStartDate;
    }

    public void setDeprecStartDate_From(Date deprecStartDate_From) {
        this.deprecStartDate_From = deprecStartDate_From;
    }

    public void setDeprecStartDate_To(Date deprecStartDate_To) {
        this.deprecStartDate_To = deprecStartDate_To;
    }

    public Date getDeprecEndDate() {
        return this.deprecEndDate;
    }

    public Date getDeprecEndDate_From() {
        return this.deprecEndDate_From;
    }

    public Date getDeprecEndDate_To() {
        return this.deprecEndDate_To;
    }

    public void setDeprecEndDate(Date deprecEndDate) {
        this.deprecEndDate = deprecEndDate;
    }

    public void setDeprecEndDate_From(Date deprecEndDate_From) {
        this.deprecEndDate_From = deprecEndDate_From;
    }

    public void setDeprecEndDate_To(Date deprecEndDate_To) {
        this.deprecEndDate_To = deprecEndDate_To;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public Date getPurchaseDate_From() {
        return this.purchaseDate_From;
    }

    public Date getPurchaseDate_To() {
        return this.purchaseDate_To;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseDate_From(Date purchaseDate_From) {
        this.purchaseDate_From = purchaseDate_From;
    }

    public void setPurchaseDate_To(Date purchaseDate_To) {
        this.purchaseDate_To = purchaseDate_To;
    }

    public Float getInitialValue() {
        return this.initialValue;
    }

    public Float getInitialValue_From() {
        return this.initialValue_From;
    }

    public Float getInitialValue_To() {
        return this.initialValue_To;
    }

    public void setInitialValue(Float initialValue) {
        this.initialValue = initialValue;
    }

    public void setInitialValue_From(Float initialValue_From) {
        this.initialValue_From = initialValue_From;
    }

    public void setInitialValue_To(Float initialValue_To) {
        this.initialValue_To = initialValue_To;
    }

    public Float getResidualValue() {
        return this.residualValue;
    }

    public Float getResidualValue_From() {
        return this.residualValue_From;
    }

    public Float getResidualValue_To() {
        return this.residualValue_To;
    }

    public void setResidualValue(Float residualValue) {
        this.residualValue = residualValue;
    }

    public void setResidualValue_From(Float residualValue_From) {
        this.residualValue_From = residualValue_From;
    }

    public void setResidualValue_To(Float residualValue_To) {
        this.residualValue_To = residualValue_To;
    }

    public Float getDepreciationAmount() {
        return this.depreciationAmount;
    }

    public Float getDepreciationAmount_From() {
        return this.depreciationAmount_From;
    }

    public Float getDepreciationAmount_To() {
        return this.depreciationAmount_To;
    }

    public void setDepreciationAmount(Float depreciationAmount) {
        this.depreciationAmount = depreciationAmount;
    }

    public void setDepreciationAmount_From(Float depreciationAmount_From) {
        this.depreciationAmount_From = depreciationAmount_From;
    }

    public void setDepreciationAmount_To(Float depreciationAmount_To) {
        this.depreciationAmount_To = depreciationAmount_To;
    }

    public Float getInitialDeprecAmount() {
        return this.initialDeprecAmount;
    }

    public Float getInitialDeprecAmount_From() {
        return this.initialDeprecAmount_From;
    }

    public Float getInitialDeprecAmount_To() {
        return this.initialDeprecAmount_To;
    }

    public void setInitialDeprecAmount(Float initialDeprecAmount) {
        this.initialDeprecAmount = initialDeprecAmount;
    }

    public void setInitialDeprecAmount_From(Float initialDeprecAmount_From) {
        this.initialDeprecAmount_From = initialDeprecAmount_From;
    }

    public void setInitialDeprecAmount_To(Float initialDeprecAmount_To) {
        this.initialDeprecAmount_To = initialDeprecAmount_To;
    }

}
