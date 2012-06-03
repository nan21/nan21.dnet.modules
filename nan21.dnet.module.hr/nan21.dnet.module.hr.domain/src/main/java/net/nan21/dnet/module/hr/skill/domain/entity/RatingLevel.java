/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** RatingLevel. */
@Entity
@Table(name = RatingLevel.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = RatingLevel.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "RATINGSCALE_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = RatingLevel.NQ_FIND_BY_ID, query = "SELECT e FROM RatingLevel e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = RatingLevel.NQ_FIND_BY_IDS, query = "SELECT e FROM RatingLevel e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = RatingLevel.NQ_FIND_BY_NAME, query = "SELECT e FROM RatingLevel e WHERE e.clientId = :pClientId and  e.ratingScale = :pRatingScale and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM RatingLevel e WHERE e.clientId = :pClientId and  e.ratingScale.id = :pRatingScaleId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class RatingLevel extends AbstractType {

    public static final String TABLE_NAME = "HR_RATE_LVL";
    public static final String SEQUENCE_NAME = "HR_RATE_LVL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "RatingLevel.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "RatingLevel.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "RatingLevel.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "RatingLevel.findByName_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Value. */
    @Column(name = "VALUE", nullable = false)
    @NotNull
    private Integer value;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RatingScale.class)
    @JoinColumn(name = "RATINGSCALE_ID", referencedColumnName = "ID")
    private RatingScale ratingScale;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public RatingScale getRatingScale() {
        return this.ratingScale;
    }

    public void setRatingScale(RatingScale ratingScale) {
        if (ratingScale != null) {
            this.__validate_client_context__(ratingScale.getClientId());
        }
        this.ratingScale = ratingScale;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
