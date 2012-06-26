/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActTaskInstanceHistoryDsFilter;

import net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDs;
import net.nan21.dnet.core.api.session.Session;

public class ActTaskInstanceHistoryDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActTaskInstanceHistoryDs, ActTaskInstanceHistoryDsFilter, EmptyParam> {

    @Override
    public void setFilter(ActTaskInstanceHistoryDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
