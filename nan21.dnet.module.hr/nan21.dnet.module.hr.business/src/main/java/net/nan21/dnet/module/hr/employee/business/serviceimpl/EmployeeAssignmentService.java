/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeAssignmentService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;

public class EmployeeAssignmentService extends
        AbstractEntityService<EmployeeAssignment> implements
        IEmployeeAssignmentService {

    public EmployeeAssignmentService() {
        super();
    }

    public EmployeeAssignmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeAssignment> getEntityClass() {
        return EmployeeAssignment.class;
    }

    public List<EmployeeAssignment> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeAssignment> findByEmployeeId(Long employeeId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeAssignment> findByType(EmploymentType type) {
        return this.findByTypeId(type.getId());
    }

    public List<EmployeeAssignment> findByTypeId(Long typeId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<EmployeeAssignment> findByPosition(Position position) {
        return this.findByPositionId(position.getId());
    }

    public List<EmployeeAssignment> findByPositionId(Long positionId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.position.id = :pPositionId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPositionId", positionId).getResultList();
    }

    public List<EmployeeAssignment> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<EmployeeAssignment> findByJobId(Long jobId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.job.id = :pJobId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).getResultList();
    }

    public List<EmployeeAssignment> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<EmployeeAssignment> findByOrgId(Long orgId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<EmployeeAssignment> findByGrade(Grade grade) {
        return this.findByGradeId(grade.getId());
    }

    public List<EmployeeAssignment> findByGradeId(Long gradeId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.grade.id = :pGradeId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGradeId", gradeId).getResultList();
    }

    public List<EmployeeAssignment> findByPayroll(Payroll payroll) {
        return this.findByPayrollId(payroll.getId());
    }

    public List<EmployeeAssignment> findByPayrollId(Long payrollId) {
        return (List<EmployeeAssignment>) this.em
                .createQuery(
                        "select e from EmployeeAssignment e where e.clientId = :pClientId and e.payroll.id = :pPayrollId",
                        EmployeeAssignment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayrollId", payrollId).getResultList();
    }

}
