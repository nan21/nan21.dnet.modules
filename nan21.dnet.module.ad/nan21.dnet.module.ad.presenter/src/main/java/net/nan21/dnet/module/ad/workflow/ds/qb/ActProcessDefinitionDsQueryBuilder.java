/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.workflow.ds.filter.ActProcessDefinitionDsFilter;
import net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionDsParam;

import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs;
import net.nan21.dnet.core.api.session.Session;

public class ActProcessDefinitionDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActProcessDefinitionDs, ActProcessDefinitionDsFilter, ActProcessDefinitionDsParam> {

    @Override
    public void setFilter(ActProcessDefinitionDsFilter filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
