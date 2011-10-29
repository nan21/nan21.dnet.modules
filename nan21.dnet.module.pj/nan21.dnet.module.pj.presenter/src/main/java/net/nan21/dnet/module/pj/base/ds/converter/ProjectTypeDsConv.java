/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(ProjectTypeDs ds, ProjectType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProjectTypeDs ds, ProjectType e)
            throws Exception {

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
                x = ((IProjectCategoryService) getService(IProjectCategoryService.class))
                        .findByName(ds.getClientId(), ds.getCategory());
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

    @Override
    public void entityToModel(ProjectType e, ProjectTypeDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCategoryId(((e.getCategory() != null)) ? e.getCategory().getId()
                : null);
        ds.setCategory(((e.getCategory() != null)) ? e.getCategory().getName()
                : null);
    }

}
