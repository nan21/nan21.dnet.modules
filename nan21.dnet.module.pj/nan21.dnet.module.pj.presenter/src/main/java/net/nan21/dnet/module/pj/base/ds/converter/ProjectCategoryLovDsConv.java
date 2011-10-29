/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ProjectCategoryLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;

public class ProjectCategoryLovDsConv extends
        AbstractDsConverter<ProjectCategoryLovDs, ProjectCategory> implements
        IDsConverter<ProjectCategoryLovDs, ProjectCategory> {

    protected void modelToEntityAttributes(ProjectCategoryLovDs ds,
            ProjectCategory e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProjectCategoryLovDs ds,
            ProjectCategory e) throws Exception {
    }

    @Override
    public void entityToModel(ProjectCategory e, ProjectCategoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
