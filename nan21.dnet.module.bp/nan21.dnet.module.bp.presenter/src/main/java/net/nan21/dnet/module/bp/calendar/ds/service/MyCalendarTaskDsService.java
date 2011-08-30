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

import net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarTaskDs;
import net.nan21.dnet.core.api.session.Session;

public class MyCalendarTaskDsService extends
        AbstractDsService<MyCalendarTaskDs, EmptyParam, CalendarEvent>
        implements IDsService<MyCalendarTaskDs, EmptyParam> {

    @Override
    public void preInsert(MyCalendarTaskDs ds) {

        ds.setEventType("task");
    }
}
