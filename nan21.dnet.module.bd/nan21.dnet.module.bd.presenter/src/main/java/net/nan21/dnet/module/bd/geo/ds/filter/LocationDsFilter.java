/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class LocationDsFilter extends AbstractAuditableDsFilter {

    private String regionName;

    private String cityName;

    private String adress;

    private String notes;

    private Boolean active;

    private Long countryId;

    private Long countryId_From;
    private Long countryId_To;

    private String countryCode;

    private Long regionId;

    private Long regionId_From;
    private Long regionId_To;

    private String regionCode;

    private Long cityId;

    private Long cityId_From;
    private Long cityId_To;

    private Boolean shipping;

    private Boolean billing;

    private Boolean mailing;

    private String targetUuid;

    private String targetType;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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

    public Long getCityId() {
        return this.cityId;
    }

    public Long getCityId_From() {
        return this.cityId_From;
    }

    public Long getCityId_To() {
        return this.cityId_To;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setCityId_From(Long cityId_From) {
        this.cityId_From = cityId_From;
    }

    public void setCityId_To(Long cityId_To) {
        this.cityId_To = cityId_To;
    }

    public Boolean getShipping() {
        return this.shipping;
    }

    public void setShipping(Boolean shipping) {
        this.shipping = shipping;
    }

    public Boolean getBilling() {
        return this.billing;
    }

    public void setBilling(Boolean billing) {
        this.billing = billing;
    }

    public Boolean getMailing() {
        return this.mailing;
    }

    public void setMailing(Boolean mailing) {
        this.mailing = mailing;
    }

    public String getTargetUuid() {
        return this.targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

}
