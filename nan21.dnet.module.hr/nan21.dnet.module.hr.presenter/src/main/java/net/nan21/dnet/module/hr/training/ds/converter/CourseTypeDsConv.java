/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.module.hr.training.domain.service.ICourseCategoryService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.CourseTypeDs;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

public class CourseTypeDsConv extends
        AbstractDsConverter<CourseTypeDs, CourseType> implements
        IDsConverter<CourseTypeDs, CourseType> {

    protected void modelToEntityAttributes(CourseTypeDs ds, CourseType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(CourseTypeDs ds, CourseType e)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((CourseCategory) this.em.getReference(
                        CourseCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_CourseCategory(ds, e);
        }
    }

    protected void lookup_category_CourseCategory(CourseTypeDs ds, CourseType e)
            throws Exception {
        CourseCategory x = null;
        try {
            x = ((ICourseCategoryService) getService(ICourseCategoryService.class))
                    .findByName(ds.getClientId(), ds.getCategory());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCategory(x);
    }

    @Override
    public void entityToModel(CourseType e, CourseTypeDs ds) throws Exception {
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
