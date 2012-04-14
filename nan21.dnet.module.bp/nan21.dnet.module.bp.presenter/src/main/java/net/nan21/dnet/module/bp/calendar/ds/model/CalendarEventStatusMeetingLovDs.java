/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventStatus;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CalendarEventStatus.class, jpqlWhere = "  e.eventType = 'meeting' ", sort = { @SortField(field = CalendarEventStatusMeetingLovDs.fNAME) })
public class CalendarEventStatusMeetingLovDs extends
        AbstractTypeLov<CalendarEventStatus> {

    public static final String fEVENTTYPE = "eventType";

    @DsField()
    private String eventType;

    public CalendarEventStatusMeetingLovDs() {
        super();
    }

    public CalendarEventStatusMeetingLovDs(CalendarEventStatus e) {
        super(e);
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
