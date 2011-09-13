/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.business.service.IPositionService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.training.business.service.ICourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs;
import net.nan21.dnet.module.hr.training.domain.entity.PositionCourse;

public class PositionCourseDsConv extends
        AbstractDsConverter<PositionCourseDs, PositionCourse> implements
        IDsConverter<PositionCourseDs, PositionCourse> {

    protected void modelToEntityAttributes(PositionCourseDs ds, PositionCourse e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setMandatory(ds.getMandatory());
        e.setValidFor(ds.getValidFor());
    }

    protected void modelToEntityReferences(PositionCourseDs ds, PositionCourse e)
            throws Exception {

        if (ds.getPositionId() != null) {
            if (e.getPosition() == null
                    || !e.getPosition().getId().equals(ds.getPositionId())) {
                e.setPosition((Position) this.em.find(Position.class,
                        ds.getPositionId()));
            }
        } else {
            this.lookup_position_Position(ds, e);
        }
        if (ds.getCourseId() != null) {
            if (e.getCourse() == null
                    || !e.getCourse().getId().equals(ds.getCourseId())) {
                e.setCourse((Course) this.em.find(Course.class,
                        ds.getCourseId()));
            }
        } else {
            this.lookup_course_Course(ds, e);
        }
    }

    protected void lookup_position_Position(PositionCourseDs ds,
            PositionCourse e) throws Exception {
        if (ds.getPositionCode() != null && !ds.getPositionCode().equals("")) {
            Position x = null;
            try {
                x = ((IPositionService) getService(IPositionService.class))
                        .findByCode(ds.getClientId(), ds.getPositionCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Position` reference:  `positionCode` = "
                                + ds.getPositionCode() + "  ");
            }
            e.setPosition(x);
        } else {
            e.setPosition(null);
        }
    }

    protected void lookup_course_Course(PositionCourseDs ds, PositionCourse e)
            throws Exception {
        if (ds.getCourseCode() != null && !ds.getCourseCode().equals("")) {
            Course x = null;
            try {
                x = ((ICourseService) getService(ICourseService.class))
                        .findByCode(ds.getClientId(), ds.getCourseCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Course` reference:  `courseCode` = "
                                + ds.getCourseCode() + "  ");
            }
            e.setCourse(x);
        } else {
            e.setCourse(null);
        }
    }

    @Override
    public void entityToModel(PositionCourse e, PositionCourseDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setMandatory(e.getMandatory());
        ds.setValidFor(e.getValidFor());
        ds.setPositionId(((e.getPosition() != null)) ? e.getPosition().getId()
                : null);
        ds.setPositionCode(((e.getPosition() != null)) ? e.getPosition()
                .getCode() : null);
        ds.setPositionName(((e.getPosition() != null)) ? e.getPosition()
                .getName() : null);
        ds.setCourseId(((e.getCourse() != null)) ? e.getCourse().getId() : null);
        ds.setCourseCode(((e.getCourse() != null)) ? e.getCourse().getCode()
                : null);
        ds.setCourseName(((e.getCourse() != null)) ? e.getCourse().getName()
                : null);
    }

}
