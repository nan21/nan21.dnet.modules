/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs;

import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs;
import net.nan21.dnet.core.api.session.Session;

public class ActProcessDefinitionLovDsQueryBuilder
        extends
        QueryBuilderWithJpql<ActProcessDefinitionLovDs, ActProcessDefinitionLovDs, EmptyParam> {

    @Override
    public void setFilter(ActProcessDefinitionLovDs filter) {
        filter.setClientId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
