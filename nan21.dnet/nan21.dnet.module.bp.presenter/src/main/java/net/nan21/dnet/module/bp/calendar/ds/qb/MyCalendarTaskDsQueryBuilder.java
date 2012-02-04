/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.bp.calendar.ds.filter.MyCalendarTaskDsFilter;

import net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarTaskDs;
import net.nan21.dnet.core.api.session.Session;

public class MyCalendarTaskDsQueryBuilder
        extends
        QueryBuilderWithJpql<MyCalendarTaskDs, MyCalendarTaskDsFilter, EmptyParam> {

    @Override
    public void setFilter(MyCalendarTaskDsFilter filter) {
        filter.setCreatedBy(Session.user.get().getUsername());
        this.filter = filter;
    }

}
