/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;

public interface IEmployeeAssignmentService extends
        IEntityService<EmployeeAssignment> {

    public List<EmployeeAssignment> findByEmployee(Employee employee);

    public List<EmployeeAssignment> findByEmployeeId(Long employeeId);

    public List<EmployeeAssignment> findByType(EmploymentType type);

    public List<EmployeeAssignment> findByTypeId(Long typeId);

    public List<EmployeeAssignment> findByPosition(Position position);

    public List<EmployeeAssignment> findByPositionId(Long positionId);

    public List<EmployeeAssignment> findByJob(Job job);

    public List<EmployeeAssignment> findByJobId(Long jobId);

    public List<EmployeeAssignment> findByOrg(Organization org);

    public List<EmployeeAssignment> findByOrgId(Long orgId);

    public List<EmployeeAssignment> findByGrade(Grade grade);

    public List<EmployeeAssignment> findByGradeId(Long gradeId);

    public List<EmployeeAssignment> findByPayroll(Payroll payroll);

    public List<EmployeeAssignment> findByPayrollId(Long payrollId);

}
