/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.training.business.service.IEmployeeCourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.training.domain.entity.EmployeeCourse;

public class EmployeeCourseService extends
        AbstractEntityService<EmployeeCourse> implements IEmployeeCourseService {

    public EmployeeCourseService() {
        super();
    }

    public EmployeeCourseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeCourse> getEntityClass() {
        return EmployeeCourse.class;
    }

    public List<EmployeeCourse> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeCourse> findByEmployeeId(Long employeeId) {
        return (List<EmployeeCourse>) this.em
                .createQuery(
                        "select e from EmployeeCourse e where e.clientId = :pClientId and  e.employee.id = :pEmployeeId",
                        EmployeeCourse.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeCourse> findByCourse(Course course) {
        return this.findByCourseId(course.getId());
    }

    public List<EmployeeCourse> findByCourseId(Long courseId) {
        return (List<EmployeeCourse>) this.em
                .createQuery(
                        "select e from EmployeeCourse e where e.clientId = :pClientId and  e.course.id = :pCourseId",
                        EmployeeCourse.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCourseId", courseId).getResultList();
    }

}
