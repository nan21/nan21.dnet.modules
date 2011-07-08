/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.training.business.service.ICourseService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

public class CourseService extends AbstractEntityService<Course> implements
        ICourseService {

    public CourseService() {
        super();
    }

    public CourseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Course> getEntityClass() {
        return Course.class;
    }

    public Course findByCode(Long clientId, String code) {
        return (Course) this.em.createNamedQuery(Course.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Course findByName(Long clientId, String name) {
        return (Course) this.em.createNamedQuery(Course.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Course> findByType(CourseType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Course> findByTypeId(Long typeId) {
        return (List<Course>) this.em
                .createQuery(
                        "select e from Course e where e.type.id = :pTypeId",
                        Course.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

}
