/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Tax.class, sort = { @SortField(field = TaxDs.fNAME) })
public class TaxDs extends AbstractTypeDs<Tax> {

    public static final String fRATE = "rate";
    public static final String fSUMMARY = "summary";
    public static final String fCATEGORYID = "categoryId";
    public static final String fCATEGORY = "category";
    public static final String fPARENTTAXID = "parentTaxId";
    public static final String fPARENTTAX = "parentTax";

    @DsField()
    private Float rate;

    @DsField()
    private Boolean summary;

    @DsField(join = "left", path = "category.id")
    private Long categoryId;

    @DsField(join = "left", path = "category.name")
    private String category;

    @DsField(join = "left", path = "parentTax.id")
    private Long parentTaxId;

    @DsField(join = "left", path = "parentTax.name")
    private String parentTax;

    public TaxDs() {
        super();
    }

    public TaxDs(Tax e) {
        super(e);
    }

    public Float getRate() {
        return this.rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
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

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public void setParentTaxId(Long parentTaxId) {
        this.parentTaxId = parentTaxId;
    }

    public String getParentTax() {
        return this.parentTax;
    }

    public void setParentTax(String parentTax) {
        this.parentTax = parentTax;
    }

}
