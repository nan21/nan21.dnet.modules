/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.training.business.service.ICourseTypeService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.CourseDs;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

public class CourseDsConv extends AbstractDsConverter<CourseDs, Course>
        implements IDsConverter<CourseDs, Course> {

    @Override
    protected void modelToEntityReferences(CourseDs ds, Course e,
            boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((CourseType) this.em.find(CourseType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_CourseType(ds, e);
        }

    }

    protected void lookup_type_CourseType(CourseDs ds, Course e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            CourseType x = null;
            try {
                x = ((ICourseTypeService) findEntityService(CourseType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CourseType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
