/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.domain.entity;

import java.util.Date;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Region. */
@Entity
@Table(name = Region.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Region.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "COUNTRY_ID", "CODE" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Region.NQ_FIND_BY_ID, query = "SELECT e FROM Region e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Region.NQ_FIND_BY_IDS, query = "SELECT e FROM Region e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Region.NQ_FIND_BY_CODEANDCOUNTRY, query = "SELECT e FROM Region e WHERE e.clientId = :pClientId and  e.country = :pCountry and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Region.findByCodeAndCountry_PRIMITIVE", query = "SELECT e FROM Region e WHERE e.clientId = :pClientId and  e.country.id = :pCountryId and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Region extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "BD_GEO_REGION";
    public static final String SEQUENCE_NAME = "BD_GEO_REGION_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Region.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Region.findByIds";

    /**
     * Named query find by unique key: CodeAndCountry.
     */
    public static final String NQ_FIND_BY_CODEANDCOUNTRY = "Region.findByCodeAndCountry";

    /**
     * Named query find by unique key: CodeAndCountry using the ID field for references.
     */
    public static final String NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE = "Region.findByCodeAndCountry_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Iso. */
    @Column(name = "ISO", length = 32)
    private String iso;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    private Country country;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIso() {
        return this.iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
