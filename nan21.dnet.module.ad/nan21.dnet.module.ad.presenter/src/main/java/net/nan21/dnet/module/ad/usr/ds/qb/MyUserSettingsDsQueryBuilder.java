/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDs;

import net.nan21.dnet.core.api.session.Session;

public class MyUserSettingsDsQueryBuilder extends
        QueryBuilderWithJpql<MyUserSettingsDs, MyUserSettingsDs, EmptyParam> {

    @Override
    public void setFilter(MyUserSettingsDs filter) {
        filter.setCode(Session.user.get().getUsername());
        this.filter = filter;
    }

}
