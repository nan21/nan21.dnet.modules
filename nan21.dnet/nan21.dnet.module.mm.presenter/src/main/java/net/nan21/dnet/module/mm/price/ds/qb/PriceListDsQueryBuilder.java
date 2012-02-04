/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.mm.price.ds.param.PriceListDsParam;

import net.nan21.dnet.module.mm.price.ds.model.PriceListDs;
import net.nan21.dnet.core.api.session.Session;

public class PriceListDsQueryBuilder extends
        QueryBuilderWithJpql<PriceListDs, PriceListDsParam> {

    @Override
    public void setFilter(PriceListDs filter) {
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params != null && this.params.getValidAt() != null) {
            addFilterCondition("  :validAt between e.validFrom and e.validTo");
            addCustomFilterItem("validAt", this.params.getValidAt());
        }

    }

}
