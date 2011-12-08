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
                x = ((IPositionService) findEntityService(Position.class))
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
                x = ((ICourseService) findEntityService(Course.class))
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

}
