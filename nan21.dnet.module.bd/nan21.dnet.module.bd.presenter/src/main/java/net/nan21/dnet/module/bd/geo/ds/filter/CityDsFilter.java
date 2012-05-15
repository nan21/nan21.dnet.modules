/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class CityDsFilter extends AbstractTypeDsFilter {

    private Long countryId;

    private Long countryId_From;
    private Long countryId_To;

    private String countryCode;

    private Long regionId;

    private Long regionId_From;
    private Long regionId_To;

    private String regionCode;

    public Long getCountryId() {
        return this.countryId;
    }

    public Long getCountryId_From() {
        return this.countryId_From;
    }

    public Long getCountryId_To() {
        return this.countryId_To;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setCountryId_From(Long countryId_From) {
        this.countryId_From = countryId_From;
    }

    public void setCountryId_To(Long countryId_To) {
        this.countryId_To = countryId_To;
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

    public Long getRegionId_From() {
        return this.regionId_From;
    }

    public Long getRegionId_To() {
        return this.regionId_To;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public void setRegionId_From(Long regionId_From) {
        this.regionId_From = regionId_From;
    }

    public void setRegionId_To(Long regionId_To) {
        this.regionId_To = regionId_To;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

}
