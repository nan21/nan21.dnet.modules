/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CalendarEventPriority.class, jpqlWhere = "  e.eventType = 'task' ", sort = { @SortField(field = CalendarEventPriorityTaskLovDs.fNAME) })
public class CalendarEventPriorityTaskLovDs extends
        AbstractTypeLov<CalendarEventPriority> {

    public static final String fEVENTTYPE = "eventType";

    @DsField()
    private String eventType;

    public CalendarEventPriorityTaskLovDs() {
        super();
    }

    public CalendarEventPriorityTaskLovDs(CalendarEventPriority e) {
        super(e);
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
