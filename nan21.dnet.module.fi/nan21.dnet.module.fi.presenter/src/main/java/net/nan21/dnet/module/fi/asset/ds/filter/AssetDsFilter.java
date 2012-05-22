/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.filter;

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

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private String productName;

    private Float initialValue;

    private Float initialValue_From;
    private Float initialValue_To;

    private Float residualValue;

    private Float residualValue_From;
    private Float residualValue_To;

    private Float depreciationAmount;

    private Float depreciationAmount_From;
    private Float depreciationAmount_To;

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

}
