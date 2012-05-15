/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Country.class, sort = { @SortField(field = CountryDs.fNAME) })
public class CountryDs extends AbstractTypeWithCodeDs<Country> {

    public static final String fISO2 = "iso2";
    public static final String fISO3 = "iso3";
    public static final String fHASREGIONS = "hasRegions";
    public static final String fCURRENCY = "currency";
    public static final String fLANGUAGE = "language";

    @DsField()
    private String iso2;

    @DsField()
    private String iso3;

    @DsField()
    private Boolean hasRegions;

    @DsField(path = "defaultCurrency")
    private String currency;

    @DsField(path = "defaultLanguage")
    private String language;

    public CountryDs() {
        super();
    }

    public CountryDs(Country e) {
        super(e);
    }

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
