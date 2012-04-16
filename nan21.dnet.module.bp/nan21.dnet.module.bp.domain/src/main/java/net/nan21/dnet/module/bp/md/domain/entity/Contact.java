/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.domain.entity;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Business partner contacts. */
@Entity
@Table(name = Contact.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Contact.NQ_FIND_BY_ID, query = "SELECT e FROM Contact e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Contact.NQ_FIND_BY_IDS, query = "SELECT e FROM Contact e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Contact extends AbstractAuditable {

    public static final String TABLE_NAME = "BP_CONTACT";
    public static final String SEQUENCE_NAME = "BP_CONTACT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Contact.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Contact.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** FirstName. */
    @Column(name = "FIRSTNAME", length = 255)
    private String firstName;

    /** LastName. */
    @Column(name = "LASTNAME", nullable = false, length = 255)
    @NotBlank
    private String lastName;

    /** Active. */
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Gender. */
    @Column(name = "GENDER", length = 16)
    private String gender;

    /** Birthdate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDATE")
    private Date birthdate;

    /** Position. */
    @Column(name = "POSITION", length = 255)
    private String position;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getName() {
        return this.lastName + " " + this.firstName;
    }

    public void setName(String name) {

    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        this.bpartner = bpartner;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {

        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
