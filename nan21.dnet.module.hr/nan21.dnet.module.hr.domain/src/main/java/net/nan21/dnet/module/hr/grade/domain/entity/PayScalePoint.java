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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** PayScalePoint. */
@Entity
@Table(name = PayScalePoint.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = PayScalePoint.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PAYSCALE_ID", "CODE" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PayScalePoint.NQ_FIND_BY_ID, query = "SELECT e FROM PayScalePoint e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayScalePoint.NQ_FIND_BY_IDS, query = "SELECT e FROM PayScalePoint e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayScalePoint.NQ_FIND_BY_SCALE_CODE, query = "SELECT e FROM PayScalePoint e WHERE e.clientId = :pClientId and  e.payScale = :pPayScale and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "PayScalePoint.findByScale_code_PRIMITIVE", query = "SELECT e FROM PayScalePoint e WHERE e.clientId = :pClientId and  e.payScale.id = :pPayScaleId and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PayScalePoint extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_PAY_SCALE_POINT";
    public static final String SEQUENCE_NAME = "HR_PAY_SCALE_POINT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PayScalePoint.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PayScalePoint.findByIds";

    /**
     * Named query find by unique key: Scale_code.
     */
    public static final String NQ_FIND_BY_SCALE_CODE = "PayScalePoint.findByScale_code";

    /**
     * Named query find by unique key: Scale_code using the ID field for references.
     */
    public static final String NQ_FIND_BY_SCALE_CODE_PRIMITIVE = "PayScalePoint.findByScale_code_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO")
    private Integer sequenceNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayScale.class)
    @JoinColumn(name = "PAYSCALE_ID", referencedColumnName = "ID")
    private PayScale payScale;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public PayScale getPayScale() {
        return this.payScale;
    }

    public void setPayScale(PayScale payScale) {
        this.payScale = payScale;
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
