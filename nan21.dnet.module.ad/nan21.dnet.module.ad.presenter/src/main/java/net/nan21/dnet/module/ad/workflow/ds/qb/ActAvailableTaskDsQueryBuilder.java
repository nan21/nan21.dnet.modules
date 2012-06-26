/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActAvailableTaskDsFilter;

import net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs;
import net.nan21.dnet.core.api.session.Session;

public class ActAvailableTaskDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActAvailableTaskDs, ActAvailableTaskDsFilter, EmptyParam> {

    @Override
    public void setFilter(ActAvailableTaskDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
