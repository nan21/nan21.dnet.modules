/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventPriority;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CalendarEventPriority.class, jpqlWhere = "  e.eventType = 'meeting' ", sort = { @SortField(field = CalendarEventPriorityMeetingLovDs.fNAME) })
public class CalendarEventPriorityMeetingLovDs extends
        AbstractTypeLov<CalendarEventPriority> {

    public static final String fEVENTTYPE = "eventType";

    @DsField()
    private String eventType;

    public CalendarEventPriorityMeetingLovDs() {
        super();
    }

    public CalendarEventPriorityMeetingLovDs(CalendarEventPriority e) {
        super(e);
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
