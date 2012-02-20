/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.qbext;

import net.nan21.dnet.module.ad.usr.ds.filter.MenuRtLovDsFilter;
import net.nan21.dnet.module.ad.usr.ds.model.MenuRtLovDs;
 
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;

public class MenuRtLovDsQueryBuilder extends
        QueryBuilderWithJpql<MenuRtLovDs, MenuRtLovDsFilter, EmptyParam> {

	@Override
	protected void beforeBuildWhere() throws Exception {
		 
		if (!Session.profile.get().isAdministrator()) {
			
			addFilterCondition("  e.id in ( select p.id from  Menu p, IN (p.roles) c where c.name in :pRoles )  ");
			this.addCustomFilterItem("pRoles", Session.profile.get().getRoles());
			
		}
	}
}
