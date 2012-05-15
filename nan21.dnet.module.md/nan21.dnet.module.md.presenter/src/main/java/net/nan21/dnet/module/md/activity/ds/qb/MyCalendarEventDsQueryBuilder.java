/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.md.activity.ds.filter.MyCalendarEventDsFilter;

import net.nan21.dnet.module.md.activity.ds.model.MyCalendarEventDs;
import net.nan21.dnet.core.api.session.Session;

public class MyCalendarEventDsQueryBuilder
        extends
        QueryBuilderWithJpql<MyCalendarEventDs, MyCalendarEventDsFilter, EmptyParam> {

    @Override
    public void setFilter(MyCalendarEventDsFilter filter) {
        filter.setCreatedBy(Session.user.get().getUsername());
        this.filter = filter;
    }

}
