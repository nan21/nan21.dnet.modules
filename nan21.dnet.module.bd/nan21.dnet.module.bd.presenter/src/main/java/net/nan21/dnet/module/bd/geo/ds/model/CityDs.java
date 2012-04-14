/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = City.class, sort = { @SortField(field = CityDs.fNAME) })
public class CityDs extends AbstractTypeDs<City> {

    public static final String fCOUNTRYID = "countryId";
    public static final String fCOUNTRYCODE = "countryCode";
    public static final String fREGIONID = "regionId";
    public static final String fREGIONCODE = "regionCode";

    @DsField(join = "left", path = "country.id")
    private Long countryId;

    @DsField(join = "left", path = "country.code")
    private String countryCode;

    @DsField(join = "left", path = "region.id")
    private Long regionId;

    @DsField(join = "left", path = "region.code")
    private String regionCode;

    public CityDs() {
        super();
    }

    public CityDs(City e) {
        super(e);
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getRegionId() {
        return this.regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

}
