/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs;

import net.nan21.dnet.core.api.session.Session;

public class ActDeploymentLovDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActDeploymentLovDs, ActDeploymentLovDs, EmptyParam> {

    @Override
    public void setFilter(ActDeploymentLovDs filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
