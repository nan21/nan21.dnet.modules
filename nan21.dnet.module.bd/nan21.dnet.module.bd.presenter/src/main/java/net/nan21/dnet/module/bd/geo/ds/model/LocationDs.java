/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Location.class)
public class LocationDs extends AbstractDsModel<Location> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
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
    private Long id;

    @DsField()
    private String uuid;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(fetch = false, path = "className")
    private String entityFQN;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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
