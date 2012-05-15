/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.ds.service;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.AbstractDsService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;
import net.nan21.dnet.module.md.activity.ds.filter.MyCalendarMeetingDsFilter;

import net.nan21.dnet.module.md.activity.ds.model.MyCalendarMeetingDs;
import net.nan21.dnet.core.api.session.Session;

public class MyCalendarMeetingDsService
        extends
        AbstractDsService<MyCalendarMeetingDs, MyCalendarMeetingDsFilter, EmptyParam, CalendarEvent>
        implements
        IDsService<MyCalendarMeetingDs, MyCalendarMeetingDsFilter, EmptyParam> {

    @Override
    public void preInsert(MyCalendarMeetingDs ds, EmptyParam params) {
        ds.setEventType("meeting");
    }
}
