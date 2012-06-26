/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActProcessInstanceHistoryDsFilter;
import net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceHistoryDsParam;

import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDs;
import net.nan21.dnet.core.api.session.Session;

public class ActProcessInstanceHistoryDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActProcessInstanceHistoryDs, ActProcessInstanceHistoryDsFilter, ActProcessInstanceHistoryDsParam> {

    @Override
    public void setFilter(ActProcessInstanceHistoryDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
