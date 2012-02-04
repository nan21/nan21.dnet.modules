/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class LocationDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
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
