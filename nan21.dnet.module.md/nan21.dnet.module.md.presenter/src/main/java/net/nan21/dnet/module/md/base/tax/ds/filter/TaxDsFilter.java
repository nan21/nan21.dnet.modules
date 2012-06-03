/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class TaxDsFilter extends AbstractTypeDsFilter {

    private Float rate;

    private Float rate_From;
    private Float rate_To;

    private Boolean summary;

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    private Long parentTaxId;

    private Long parentTaxId_From;
    private Long parentTaxId_To;

    private String parentTax;

    public Float getRate() {
        return this.rate;
    }

    public Float getRate_From() {
        return this.rate_From;
    }

    public Float getRate_To() {
        return this.rate_To;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void setRate_From(Float rate_From) {
        this.rate_From = rate_From;
    }

    public void setRate_To(Float rate_To) {
        this.rate_To = rate_To;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
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

    public Long getParentTaxId() {
        return this.parentTaxId;
    }

    public Long getParentTaxId_From() {
        return this.parentTaxId_From;
    }

    public Long getParentTaxId_To() {
        return this.parentTaxId_To;
    }

    public void setParentTaxId(Long parentTaxId) {
        this.parentTaxId = parentTaxId;
    }

    public void setParentTaxId_From(Long parentTaxId_From) {
        this.parentTaxId_From = parentTaxId_From;
    }

    public void setParentTaxId_To(Long parentTaxId_To) {
        this.parentTaxId_To = parentTaxId_To;
    }

    public String getParentTax() {
        return this.parentTax;
    }

    public void setParentTax(String parentTax) {
        this.parentTax = parentTax;
    }

}
