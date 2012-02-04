/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.pj.md.ds.filter.IssueDsFilter;
import net.nan21.dnet.module.pj.md.ds.param.IssueDsParam;

import net.nan21.dnet.module.pj.md.ds.model.IssueDs;
import net.nan21.dnet.core.api.session.Session;

public class IssueDsQueryBuilder extends
        QueryBuilderWithJpql<IssueDs, IssueDsFilter, IssueDsParam> {

    @Override
    public void setFilter(IssueDsFilter filter) {
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params != null && this.params.getAffectedVersionId() != null) {
            addFilterCondition("  e.id in ( select p.id from  Issue p, IN (p.affectedVersions) c where c.id = :affectedVersionId )  ");
            addCustomFilterItem("affectedVersionId",
                    this.params.getAffectedVersionId());
        }

        if (this.params != null && this.params.getAffectedComponentId() != null) {
            addFilterCondition("  e.id in ( select p.id from  Issue p, IN (p.affectedComponents) c where c.id = :affectedComponentId )  ");
            addCustomFilterItem("affectedComponentId",
                    this.params.getAffectedComponentId());
        }

    }

}
