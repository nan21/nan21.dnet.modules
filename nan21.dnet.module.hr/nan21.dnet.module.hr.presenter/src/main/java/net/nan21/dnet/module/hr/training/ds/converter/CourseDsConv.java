/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(CourseDs ds, Course e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setIntendedAudience(ds.getIntendedAudience());
        e.setDeliveredCompetences(ds.getDeliveredCompetences());
        e.setRequirements(ds.getRequirements());
    }

    protected void modelToEntityReferences(CourseDs ds, Course e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((CourseType) this.em.getReference(CourseType.class,
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
                x = ((ICourseTypeService) getService(ICourseTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CourseType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        }
    }

    @Override
    public void entityToModel(Course e, CourseDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setIntendedAudience(e.getIntendedAudience());
        ds.setDeliveredCompetences(e.getDeliveredCompetences());
        ds.setRequirements(e.getRequirements());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
