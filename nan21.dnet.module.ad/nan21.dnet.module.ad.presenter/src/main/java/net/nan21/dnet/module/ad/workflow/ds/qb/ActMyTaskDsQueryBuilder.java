/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActMyTaskDsFilter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

import net.nan21.dnet.core.api.session.Session;

public class ActMyTaskDsQueryBuilder extends
        QueryBuilderWithJpql<ActMyTaskDs, ActMyTaskDsFilter, EmptyParam> {

    @Override
    public void setFilter(ActMyTaskDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        filter.setOwner(Session.user.get().getUsername());
        this.filter = filter;
    }

}
