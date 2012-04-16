/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** CalendarEventStatus. */
@Entity
@Table(name = CalendarEventStatus.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = CalendarEventStatus.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "EVENTTYPE", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = CalendarEventStatus.NQ_FIND_BY_ID, query = "SELECT e FROM CalendarEventStatus e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CalendarEventStatus.NQ_FIND_BY_IDS, query = "SELECT e FROM CalendarEventStatus e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CalendarEventStatus.NQ_FIND_BY_TYPE_AND_NAME, query = "SELECT e FROM CalendarEventStatus e WHERE e.clientId = :pClientId and  e.eventType = :pEventType and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class CalendarEventStatus extends AbstractType {

    public static final String TABLE_NAME = "BP_CLNDR_EVENT_STATUS";
    public static final String SEQUENCE_NAME = "BP_CLNDR_EVENT_STATUS_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "CalendarEventStatus.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "CalendarEventStatus.findByIds";

    /**
     * Named query find by unique key: Type_and_name.
     */
    public static final String NQ_FIND_BY_TYPE_AND_NAME = "CalendarEventStatus.findByType_and_name";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EventType. */
    @Column(name = "EVENTTYPE", length = 16)
    private String eventType;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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
