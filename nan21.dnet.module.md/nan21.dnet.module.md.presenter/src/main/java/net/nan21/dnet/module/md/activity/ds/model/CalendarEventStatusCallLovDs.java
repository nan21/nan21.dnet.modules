/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;

@Ds(entity = CalendarEventStatus.class, jpqlWhere = "  e.eventType = 'call'  ", sort = { @SortField(field = CalendarEventStatusCallLovDs.fNAME) })
public class CalendarEventStatusCallLovDs extends
        AbstractTypeLov<CalendarEventStatus> {

    public static final String fEVENTTYPE = "eventType";

    @DsField()
    private String eventType;

    public CalendarEventStatusCallLovDs() {
        super();
    }

    public CalendarEventStatusCallLovDs(CalendarEventStatus e) {
        super(e);
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
