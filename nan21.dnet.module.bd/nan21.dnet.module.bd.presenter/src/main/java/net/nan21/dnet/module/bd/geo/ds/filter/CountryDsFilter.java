/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class CountryDsFilter extends AbstractTypeWithCodeDsFilter {

    private String iso2;

    private String iso3;

    private Boolean hasRegions;

    private String currency;

    private String language;

    public String getIso2() {
        return this.iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return this.iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Boolean getHasRegions() {
        return this.hasRegions;
    }

    public void setHasRegions(Boolean hasRegions) {
        this.hasRegions = hasRegions;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
