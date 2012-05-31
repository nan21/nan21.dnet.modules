/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** GradeRateValue. */
@Entity
@Table(name = GradeRateValue.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = GradeRateValue.NQ_FIND_BY_ID, query = "SELECT e FROM GradeRateValue e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = GradeRateValue.NQ_FIND_BY_IDS, query = "SELECT e FROM GradeRateValue e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class GradeRateValue extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_GRD_RATE_VAL";
    public static final String SEQUENCE_NAME = "HR_GRD_RATE_VAL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "GradeRateValue.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "GradeRateValue.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** FixValue. */
    @Column(name = "RATE_FIX_VALUE", scale = 2)
    private Float fixValue;

    /** MinValue. */
    @Column(name = "RATE_MIN_VALUE", scale = 2)
    private Float minValue;

    /** MaxValue. */
    @Column(name = "RATE_MAX_VALUE", scale = 2)
    private Float maxValue;

    /** ValidFrom. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDFROM")
    private Date validFrom;

    /** ValidTo. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDTO")
    private Date validTo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GradeRate.class)
    @JoinColumn(name = "GRADERATE_ID", referencedColumnName = "ID")
    private GradeRate gradeRate;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
    @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
    private Grade grade;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
