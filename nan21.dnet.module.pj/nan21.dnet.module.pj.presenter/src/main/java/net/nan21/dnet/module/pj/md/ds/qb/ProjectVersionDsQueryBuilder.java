/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.pj.md.ds.filter.ProjectVersionDsFilter;
import net.nan21.dnet.module.pj.md.ds.param.ProjectVersionDsParam;

import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs;
import net.nan21.dnet.core.api.session.Session;

public class ProjectVersionDsQueryBuilder
        extends
        QueryBuilderWithJpql<ProjectVersionDs, ProjectVersionDsFilter, ProjectVersionDsParam> {

    @Override
    public void setFilter(ProjectVersionDsFilter filter) {
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params.getHideReleased() != null
                && this.params.getHideReleased() == true) {
            addFilterCondition("  e.releaseDate is null ");
        }

        if (this.params.getHideDue() != null
                && this.params.getHideDue() == true) {
            addFilterCondition("  e.releaseDate is not null ");
        }

    }

}
