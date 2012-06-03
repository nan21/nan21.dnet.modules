/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.domain.entity;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Location. */
@Entity
@Table(name = Location.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Location.NQ_FIND_BY_ID, query = "SELECT e FROM Location e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Location.NQ_FIND_BY_IDS, query = "SELECT e FROM Location e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Location extends AbstractAuditable {

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

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        if (country != null) {
            this.__validate_client_context__(country.getClientId());
        }
        this.country = country;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        if (region != null) {
            this.__validate_client_context__(region.getClientId());
        }
        this.region = region;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        if (city != null) {
            this.__validate_client_context__(city.getClientId());
        }
        this.city = city;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
        if (this.getForShipping() == null) {
            event.updateAttributeWithObject("forShipping", false);
        }
        if (this.getForBilling() == null) {
            event.updateAttributeWithObject("forBilling", false);
        }
        if (this.getForMailing() == null) {
            event.updateAttributeWithObject("forMailing", false);
        }
    }

}
