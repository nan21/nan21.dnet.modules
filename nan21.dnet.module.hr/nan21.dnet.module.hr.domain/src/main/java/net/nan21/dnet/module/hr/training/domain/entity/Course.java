/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.domain.entity;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.core.domain.session.Session;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Course. */
@Entity
@Table(name = "HR_COURSE", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CODE", columnNames = { "CLIENTID", "CODE" }),
        @UniqueConstraint(name = "UK_NAME", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "Course.findById", query = "SELECT e FROM Course e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Course.findByIds", query = "SELECT e FROM Course e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Course.findByCode", query = "SELECT e FROM Course e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Course.findByName", query = "SELECT e FROM Course e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Course implements Serializable, IModelWithId, IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Course.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Course.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Course.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Course.findByName";

    /** IntendedAudience. */
    @Column(name = "INTENDEDAUDIENCE")
    private String intendedAudience;

    /** Requirements. */
    @Column(name = "REQUIREMENTS")
    private String requirements;

    /** DeliveredCompetences. */
    @Column(name = "DELIVEREDCOMPETENCES")
    private String deliveredCompetences;

    /** Name. */
    @Column(name = "NAME", nullable = false)
    @NotBlank
    private String name;

    /** Code. */
    @Column(name = "CODE", nullable = false)
    @NotBlank
    private String code;

    /** Flag which indicates if this record is used.*/
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Notes about this record. */
    @Column(name = "NOTES")
    private String notes;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false)
    @NotBlank
    private String modifiedBy;
    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;
    @Id
    @GeneratedValue
    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CourseType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private CourseType type;

    /* ============== getters - setters ================== */

    public String getIntendedAudience() {
        return this.intendedAudience;
    }

    public void setIntendedAudience(String intendedAudience) {
        this.intendedAudience = intendedAudience;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDeliveredCompetences() {
        return this.deliveredCompetences;
    }

    public void setDeliveredCompetences(String deliveredCompetences) {
        this.deliveredCompetences = deliveredCompetences;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public CourseType getType() {
        return this.type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void aboutToInsert(DescriptorEvent event) {
        this.createdAt = new Date();
        event.updateAttributeWithObject("createdAt", this.createdAt);
        this.modifiedAt = new Date();
        event.updateAttributeWithObject("modifiedAt", this.modifiedAt);
        this.createdBy = Session.user.get().getUsername();
        event.updateAttributeWithObject("createdBy", this.createdBy);

        this.modifiedBy = Session.user.get().getUsername();
        event.updateAttributeWithObject("modifiedBy", this.modifiedBy);

        this.clientId = Session.user.get().getClientId();
        event.updateAttributeWithObject("clientId", this.clientId);

        if (this.active == null) {
            event.updateAttributeWithObject("active", true);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        this.modifiedAt = new Date();
        event.updateAttributeWithObject("modifiedAt", this.modifiedAt);
        this.modifiedBy = Session.user.get().getUsername();
        event.updateAttributeWithObject("modifiedBy", this.modifiedBy);
    }

}