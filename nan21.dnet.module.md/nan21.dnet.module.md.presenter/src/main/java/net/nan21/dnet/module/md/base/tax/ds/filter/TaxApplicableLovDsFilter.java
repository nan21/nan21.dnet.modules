/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeLovFilter;

public class TaxApplicableLovDsFilter extends AbstractTypeLovFilter {

    private Float rate;

    private Float rate_From;
    private Float rate_To;

    private Boolean summary;

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

}
