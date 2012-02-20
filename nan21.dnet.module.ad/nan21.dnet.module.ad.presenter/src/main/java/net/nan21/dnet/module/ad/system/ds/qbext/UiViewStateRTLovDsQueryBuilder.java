/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.qbext;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.system.ds.filter.UiViewStateRTLovDsFilter;
import net.nan21.dnet.module.ad.system.ds.param.UiViewStateRTLovDsParam;

import net.nan21.dnet.module.ad.system.ds.model.UiViewStateRTLovDs;
import net.nan21.dnet.core.api.session.Session;

public class UiViewStateRTLovDsQueryBuilder
        extends
        QueryBuilderWithJpql<UiViewStateRTLovDs, UiViewStateRTLovDsFilter, UiViewStateRTLovDsParam> {

	@Override
	protected void beforeBuildWhere() throws Exception {
		String username = Session.user.get().getUsername();
		if (this.params.getHideMine() != null
                && this.params.getHideMine() == true) {
            addFilterCondition("  e.createdBy <> :sessionUser ");
            addCustomFilterItem("sessionUser", username);
        }

		if (this.params.getHideOthers() != null
                && this.params.getHideOthers() == true) {
            addFilterCondition("  e.createdBy = :sessionUser ");
            addCustomFilterItem("sessionUser", username);
        }
	}
}
