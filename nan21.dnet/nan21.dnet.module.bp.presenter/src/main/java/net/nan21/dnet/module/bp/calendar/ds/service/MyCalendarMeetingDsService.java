/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.service;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.AbstractDsService;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEvent;
import net.nan21.dnet.module.bp.calendar.ds.filter.MyCalendarMeetingDsFilter;

import net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarMeetingDs;
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
