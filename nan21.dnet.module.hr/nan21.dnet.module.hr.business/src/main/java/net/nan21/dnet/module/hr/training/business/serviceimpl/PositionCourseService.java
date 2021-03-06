/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.training.business.service.IPositionCourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.training.domain.entity.PositionCourse;

public class PositionCourseService extends
        AbstractEntityService<PositionCourse> implements IPositionCourseService {

    public PositionCourseService() {
        super();
    }

    public PositionCourseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PositionCourse> getEntityClass() {
        return PositionCourse.class;
    }

    public List<PositionCourse> findByPosition(Position position) {
        return this.findByPositionId(position.getId());
    }

    public List<PositionCourse> findByPositionId(Long positionId) {
        return (List<PositionCourse>) this.em
                .createQuery(
                        "select e from PositionCourse e where e.clientId = :pClientId and e.position.id = :pPositionId",
                        PositionCourse.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPositionId", positionId).getResultList();
    }

    public List<PositionCourse> findByCourse(Course course) {
        return this.findByCourseId(course.getId());
    }

    public List<PositionCourse> findByCourseId(Long courseId) {
        return (List<PositionCourse>) this.em
                .createQuery(
                        "select e from PositionCourse e where e.clientId = :pClientId and e.course.id = :pCourseId",
                        PositionCourse.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCourseId", courseId).getResultList();
    }

}
