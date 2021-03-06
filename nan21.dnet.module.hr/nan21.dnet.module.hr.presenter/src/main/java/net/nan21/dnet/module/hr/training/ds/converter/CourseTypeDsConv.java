/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.training.business.service.ICourseCategoryService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.CourseTypeDs;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

public class CourseTypeDsConv extends
        AbstractDsConverter<CourseTypeDs, CourseType> implements
        IDsConverter<CourseTypeDs, CourseType> {

    @Override
    protected void modelToEntityReferences(CourseTypeDs ds, CourseType e,
            boolean isInsert) throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((CourseCategory) this.em.find(
                        CourseCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_CourseCategory(ds, e);
        }

    }

    protected void lookup_category_CourseCategory(CourseTypeDs ds, CourseType e)
            throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            CourseCategory x = null;
            try {
                x = ((ICourseCategoryService) findEntityService(CourseCategory.class))
                        .findByName(ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CourseCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
