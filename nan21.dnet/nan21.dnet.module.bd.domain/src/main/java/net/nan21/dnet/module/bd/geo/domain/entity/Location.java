/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Location. */
@Entity
@Table(name = Location.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = Location.NQ_FIND_BY_ID, query = "SELECT e FROM Location e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Location.NQ_FIND_BY_IDS, query = "SELECT e FROM Location e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Location implements Serializable, IModelWithId, IModelWithClientId {

    public static final String TABLE_NAME = "BD_GEO_LOCATION";
    public static final String SEQUENCE_NAME = "BD_GEO_LOCATION_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Location.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Location.findByIds";

    /** RegionName. */
    @Column(name = "REGIONNAME", length = 255)
    private String regionName;

    /** CityName. */
    @Column(name = "CITYNAME", length = 255)
    private String cityName;

    /** Adress. */
    @Column(name = "ADRESS", length = 400)
    private String adress;

    /** Zip. */
    @Column(name = "ZIP", length = 32)
    private String zip;

    /** Notes. */
    @Column(name = "NOTES", length = 4000)
    private String notes;

    /** Active. */
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Adress used for shipping.*/
    @Column(name = "FORSHIPPING", nullable = false)
    @NotNull
    private Boolean forShipping;

    /** Adress used for invoicing.*/
    @Column(name = "FORBILLING", nullable = false)
    @NotNull
    private Boolean forBilling;

    /** Adress used for post-mails.*/
    @Column(name = "FORMAILING", nullable = false)
    @NotNull
    private Boolean forMailing;

    /** TargetUuid. */
    @Column(name = "TARGETUUID", length = 36)
    private String targetUuid;

    /** TargetType. */
    @Column(name = "TARGETTYPE", length = 255)
    private String targetType;

    /**
     * Identifies the client(tenant) which owns this record.
     */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /**
     * Timestamp when this record was created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /**
     * Timestamp when this record was last modified.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /**
     * User who created this record.
     */
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /**
     * User who last modified this record.
     */
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** 
     * Record version number used by the persistence framework.
     */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /**
     * System generated UID. Useful for data import-export and data-replication
     */
    @Column(name = "UUID", length = 36)
    private String uuid;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    private Country country;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Region.class)
    @JoinColumn(name = "REGION_ID", referencedColumnName = "ID")
    private Region region;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    @JoinColumn(name = "CITY_ID", referencedColumnName = "ID")
    private City city;

    /* ============== getters - setters ================== */

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

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public Boolean getForShipping() {
        return this.forShipping;
    }

    public void setForShipping(Boolean forShipping) {
        this.forShipping = forShipping;
    }

    public Boolean getForBilling() {
        return this.forBilling;
    }

    public void setForBilling(Boolean forBilling) {
        this.forBilling = forBilling;
    }

    public Boolean getForMailing() {
        return this.forMailing;
    }

    public void setForMailing(Boolean forMailing) {
        this.forMailing = forMailing;
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

    @Transient
    public String getAsString() {
        return this.adress + " " + this.cityName;
    }

    public void setAsString(String asString) {

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void aboutToInsert(DescriptorEvent event) {

        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.uuid == null || this.uuid.equals("")) {
            event.updateAttributeWithObject("uuid", UUID.randomUUID()
                    .toString().toUpperCase());
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
        if (this.forShipping == null) {
            event.updateAttributeWithObject("forShipping", false);
        }
        if (this.forBilling == null) {
            event.updateAttributeWithObject("forBilling", false);
        }
        if (this.forMailing == null) {
            event.updateAttributeWithObject("forMailing", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
