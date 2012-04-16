/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PayScaleRateValue. */
@Entity
@Table(name = PayScaleRateValue.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PayScaleRateValue.NQ_FIND_BY_ID, query = "SELECT e FROM PayScaleRateValue e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayScaleRateValue.NQ_FIND_BY_IDS, query = "SELECT e FROM PayScaleRateValue e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PayScaleRateValue extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_PAY_SCALE_RATE_VAL";
    public static final String SEQUENCE_NAME = "HR_PAY_SCALE_RATE_VAL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PayScaleRateValue.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PayScaleRateValue.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Value. */
    @Column(name = "VALUE", scale = 2)
    private Float value;

    /** ValidFrom. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDFROM")
    private Date validFrom;

    /** ValidTo. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDTO")
    private Date validTo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScaleRate.class)
    @JoinColumn(name = "SCALERATE_ID", referencedColumnName = "ID")
    private PayScaleRate scaleRate;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScalePoint.class)
    @JoinColumn(name = "SCALEPOINT_ID", referencedColumnName = "ID")
    private PayScalePoint scalePoint;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
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

    public PayScaleRate getScaleRate() {
        return this.scaleRate;
    }

    public void setScaleRate(PayScaleRate scaleRate) {
        this.scaleRate = scaleRate;
    }

    public PayScalePoint getScalePoint() {
        return this.scalePoint;
    }

    public void setScalePoint(PayScalePoint scalePoint) {
        this.scalePoint = scalePoint;
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
