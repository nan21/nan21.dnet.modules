/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActDeploymentDsFilter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDs;
import net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ActDeploymentDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActDeploymentDs, ActDeploymentDsFilter, ActDeploymentDsParam> {

    @Override
    public void setFilter(ActDeploymentDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params != null && this.params.getFrom() != null) {
            addFilterCondition("  e.deployTime >= :from ");
            addCustomFilterItem("from", this.params.getFrom());
        }

        if (this.params != null && this.params.getTo() != null) {
            addFilterCondition("  e.deployTime <= :to ");
            addCustomFilterItem("to", this.params.getTo());
        }

    }

}
