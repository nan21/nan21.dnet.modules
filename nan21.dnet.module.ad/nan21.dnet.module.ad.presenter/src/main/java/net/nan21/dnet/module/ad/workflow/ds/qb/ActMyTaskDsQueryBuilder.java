/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;

import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

public class ActMyTaskDsQueryBuilder extends
        QueryBuilderWithJpql<ActMyTaskDs, EmptyParam> {

    @Override
    public void setFilter(ActMyTaskDs filter) {
        filter.setOwner(Session.user.get().getUsername());
        this.filter = filter;
    }

}
