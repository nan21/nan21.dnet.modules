/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IProjectCategoryService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ProjectTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

public class ProjectTypeDsConv extends
        AbstractDsConverter<ProjectTypeDs, ProjectType> implements
        IDsConverter<ProjectTypeDs, ProjectType> {

    @Override
    protected void modelToEntityReferences(ProjectTypeDs ds, ProjectType e,
            boolean isInsert) throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ProjectCategory) this.em.find(
                        ProjectCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ProjectCategory(ds, e);
        }

    }

    protected void lookup_category_ProjectCategory(ProjectTypeDs ds,
            ProjectType e) throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            ProjectCategory x = null;
            try {
                x = ((IProjectCategoryService) findEntityService(ProjectCategory.class))
                        .findByName(ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProjectCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
