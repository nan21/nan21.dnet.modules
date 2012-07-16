/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.client.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.client.ds.model.MyClientDs;

import net.nan21.dnet.core.api.session.Session;

public class MyClientDsQueryBuilder extends
        QueryBuilderWithJpql<MyClientDs, MyClientDs, EmptyParam> {

    @Override
    public void setFilter(MyClientDs filter) {
        filter.setId(Session.user.get().getClientId());
        this.filter = filter;
    }

}
