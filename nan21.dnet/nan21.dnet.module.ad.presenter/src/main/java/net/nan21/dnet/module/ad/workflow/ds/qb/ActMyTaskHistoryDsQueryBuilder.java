/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActMyTaskHistoryDsFilter;

import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskHistoryDs;
import net.nan21.dnet.core.api.session.Session;

public class ActMyTaskHistoryDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActMyTaskHistoryDs, ActMyTaskHistoryDsFilter, EmptyParam> {

    @Override
    public void setFilter(ActMyTaskHistoryDsFilter filter) {
        filter.setOwner(Session.user.get().getUsername());
        this.filter = filter;
    }

}
