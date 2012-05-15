/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProjectCategory.class, sort = { @SortField(field = ProjectCategoryDs.fNAME) })
public class ProjectCategoryDs extends AbstractTypeDs<ProjectCategory> {

    public ProjectCategoryDs() {
        super();
    }

    public ProjectCategoryDs(ProjectCategory e) {
        super(e);
    }

}
