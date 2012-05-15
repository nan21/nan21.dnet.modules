/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.training.domain.entity.Course;

import net.nan21.dnet.module.hr.training.domain.entity.EmployeeCourse;

public interface IEmployeeCourseService extends IEntityService<EmployeeCourse> {

    public List<EmployeeCourse> findByEmployee(Employee employee);

    public List<EmployeeCourse> findByEmployeeId(Long employeeId);

    public List<EmployeeCourse> findByCourse(Course course);

    public List<EmployeeCourse> findByCourseId(Long courseId);

}
