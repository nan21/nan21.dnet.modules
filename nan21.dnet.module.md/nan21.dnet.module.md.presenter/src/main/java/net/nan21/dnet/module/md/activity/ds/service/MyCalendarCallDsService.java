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
import net.nan21.dnet.module.md.activity.ds.filter.MyCalendarCallDsFilter;

import net.nan21.dnet.module.md.activity.ds.model.MyCalendarCallDs;
import net.nan21.dnet.core.api.session.Session;

public class MyCalendarCallDsService
        extends
        AbstractDsService<MyCalendarCallDs, MyCalendarCallDsFilter, EmptyParam, CalendarEvent>
        implements
        IDsService<MyCalendarCallDs, MyCalendarCallDsFilter, EmptyParam> {

    @Override
    public void preInsert(MyCalendarCallDs ds, EmptyParam params) {
        ds.setEventType("call");
    }
}
