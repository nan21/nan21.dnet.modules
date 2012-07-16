/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;

@Ds(entity = Location.class)
public class LocationDs extends AbstractAuditableDs<Location> {

    public static final String fREGIONNAME = "regionName";
    public static final String fCITYNAME = "cityName";
    public static final String fADRESS = "adress";
    public static final String fNOTES = "notes";
    public static final String fACTIVE = "active";
    public static final String fCOUNTRYID = "countryId";
    public static final String fCOUNTRYCODE = "countryCode";
    public static final String fREGIONID = "regionId";
    public static final String fREGIONCODE = "regionCode";
    public static final String fCITYID = "cityId";
    public static final String fSHIPPING = "shipping";
    public static final String fBILLING = "billing";
    public static final String fMAILING = "mailing";
    public static final String fTARGETUUID = "targetUuid";
    public static final String fTARGETTYPE = "targetType";

    @DsField()
    private String regionName;

    @DsField()
    private String cityName;

    @DsField()
    private String adress;

    @DsField()
    private String notes;

    @DsField()
    private Boolean active;

    @DsField(join = "left", path = "country.id")
    private Long countryId;

    @DsField(join = "left", path = "country.code")
    private String countryCode;

    @DsField(join = "left", path = "region.id")
    private Long regionId;

    @DsField(join = "left", path = "region.code")
    private String regionCode;

    @DsField(join = "left", path = "city.id")
    private Long cityId;

    @DsField(path = "forShipping")
    private Boolean shipping;

    @DsField(path = "forBilling")
    private Boolean billing;

    @DsField(path = "forMailing")
    private Boolean mailing;

    @DsField()
    private String targetUuid;

    @DsField()
    private String targetType;

    public LocationDs() {
        super();
    }

    public LocationDs(Location e) {
        super(e);
    }

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

    public Long getCityId() {
        return this.cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
