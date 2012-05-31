/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PositionRequirement. */
@Entity
@Table(name = PositionRequirement.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PositionRequirement.NQ_FIND_BY_ID, query = "SELECT e FROM PositionRequirement e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PositionRequirement.NQ_FIND_BY_IDS, query = "SELECT e FROM PositionRequirement e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PositionRequirement extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_POS_RQM";
    public static final String SEQUENCE_NAME = "HR_POS_RQM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PositionRequirement.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PositionRequirement.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Notes. */
    @Column(name = "NOTES", length = 4000)
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkRequirement.class)
    @JoinColumn(name = "REQUIREMENT_ID", referencedColumnName = "ID")
    private WorkRequirement requirement;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public WorkRequirement getRequirement() {
        return this.requirement;
    }

    public void setRequirement(WorkRequirement requirement) {
        this.requirement = requirement;
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
