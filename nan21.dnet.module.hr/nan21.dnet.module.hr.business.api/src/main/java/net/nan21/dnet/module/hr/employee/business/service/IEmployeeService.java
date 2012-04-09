/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public interface IEmployeeService extends IEntityService<Employee> {

    public Employee findByCode(String code);

    public List<Employee> findByEmployer(Organization employer);

    public List<Employee> findByEmployerId(Long employerId);

    public List<Employee> findByCitizenship(Country citizenship);

    public List<Employee> findByCitizenshipId(Long citizenshipId);

    public List<Employee> findByType(EmploymentType type);

    public List<Employee> findByTypeId(Long typeId);

    public List<Employee> findByPosition(Position position);

    public List<Employee> findByPositionId(Long positionId);

    public List<Employee> findByJob(Job job);

    public List<Employee> findByJobId(Long jobId);

    public List<Employee> findByOrganization(Organization organization);

    public List<Employee> findByOrganizationId(Long organizationId);

    public List<Employee> findByGrade(Grade grade);

    public List<Employee> findByGradeId(Long gradeId);

    public List<Employee> findByPayroll(Payroll payroll);

    public List<Employee> findByPayrollId(Long payrollId);

    public List<Employee> findByContacts(EmployeeContact contacts);

    public List<Employee> findByContactsId(Long contactsId);

}
