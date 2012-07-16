/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActProcessInstanceDsFilter;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs;
import net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam;

import net.nan21.dnet.core.api.session.Session;

public class ActProcessInstanceDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActProcessInstanceDs, ActProcessInstanceDsFilter, ActProcessInstanceDsParam> {

    @Override
    public void setFilter(ActProcessInstanceDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params != null && this.params.getFrom() != null) {
            addFilterCondition("  e.startTime >= :from ");
            addCustomFilterItem("from", this.params.getFrom());
        }

        if (this.params != null && this.params.getTo() != null) {
            addFilterCondition("  e.startTime <= :to ");
            addCustomFilterItem("to", this.params.getTo());
        }

    }

}
