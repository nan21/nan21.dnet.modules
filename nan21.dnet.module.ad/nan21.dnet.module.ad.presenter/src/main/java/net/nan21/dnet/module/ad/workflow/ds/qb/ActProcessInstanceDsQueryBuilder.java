/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam;

import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs;
import net.nan21.dnet.core.api.session.Session;

public class ActProcessInstanceDsQueryBuilder extends
        QueryBuilderWithJpql<ActProcessInstanceDs, ActProcessInstanceDsParam> {

    @Override
    public void setFilter(ActProcessInstanceDs filter) {
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params.getFrom() != null) {
            addFilterCondition("  e.startTime >= :from ");
            addCustomFilterItem("from", this.params.getFrom());
        }

        if (this.params.getTo() != null) {
            addFilterCondition("  e.startTime <= :to ");
            addCustomFilterItem("to", this.params.getTo());
        }

    }

}