/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.domain.entity;

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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.core.domain.session.Session;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** GradeRateValue. */
@Entity
@Table(name = "HR_GRADE_RATE_VAL")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "GradeRateValue.findById", query = "SELECT e FROM GradeRateValue e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "GradeRateValue.findByIds", query = "SELECT e FROM GradeRateValue e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class GradeRateValue implements Serializable, IModelWithId,
        IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "GradeRateValue.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "GradeRateValue.findByIds";

    /** FixValue. */
    @Column(name = "RATE_FIX_VALUE", precision = 2)
    private Float fixValue;

    /** MinValue. */
    @Column(name = "RATE_MIN_VALUE", precision = 2)
    private Float minValue;

    /** MaxValue. */
    @Column(name = "RATE_MAX_VALUE", precision = 2)
    private Float maxValue;

    /** ValidFrom. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDFROM")
    private Date validFrom;

    /** ValidTo. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDTO")
    private Date validTo;

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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GradeRate.class)
    @JoinColumn(name = "GRADERATE_ID", referencedColumnName = "ID")
    private GradeRate gradeRate;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
    @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
    private Grade grade;

    /* ============== getters - setters ================== */

    public Float getFixValue() {
        return this.fixValue;
    }

    public void setFixValue(Float fixValue) {
        this.fixValue = fixValue;
    }

    public Float getMinValue() {
        return this.minValue;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public Float getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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

    public GradeRate getGradeRate() {
        return this.gradeRate;
    }

    public void setGradeRate(GradeRate gradeRate) {
        this.gradeRate = gradeRate;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
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

    }

    public void aboutToUpdate(DescriptorEvent event) {
        this.modifiedAt = new Date();
        event.updateAttributeWithObject("modifiedAt", this.modifiedAt);
        this.modifiedBy = Session.user.get().getUsername();
        event.updateAttributeWithObject("modifiedBy", this.modifiedBy);
    }

}
