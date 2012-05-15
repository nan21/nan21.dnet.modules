/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public class EmployeeService extends AbstractEntityService<Employee> implements
        IEmployeeService {

    public EmployeeService() {
        super();
    }

    public EmployeeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    public Employee findByCode(String code) {
        return (Employee) this.em.createNamedQuery(Employee.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public List<Employee> findByEmployer(Organization employer) {
        return this.findByEmployerId(employer.getId());
    }

    public List<Employee> findByEmployerId(Long employerId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.employer.id = :pEmployerId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEmployerId", employerId).getResultList();
    }

    public List<Employee> findByCitizenship(Country citizenship) {
        return this.findByCitizenshipId(citizenship.getId());
    }

    public List<Employee> findByCitizenshipId(Long citizenshipId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.citizenship.id = :pCitizenshipId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCitizenshipId", citizenshipId).getResultList();
    }

    public List<Employee> findByType(EmploymentType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Employee> findByTypeId(Long typeId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<Employee> findByPosition(Position position) {
        return this.findByPositionId(position.getId());
    }

    public List<Employee> findByPositionId(Long positionId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.position.id = :pPositionId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPositionId", positionId).getResultList();
    }

    public List<Employee> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<Employee> findByJobId(Long jobId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.job.id = :pJobId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).getResultList();
    }

    public List<Employee> findByOrganization(Organization organization) {
        return this.findByOrganizationId(organization.getId());
    }

    public List<Employee> findByOrganizationId(Long organizationId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.organization.id = :pOrganizationId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrganizationId", organizationId)
                .getResultList();
    }

    public List<Employee> findByGrade(Grade grade) {
        return this.findByGradeId(grade.getId());
    }

    public List<Employee> findByGradeId(Long gradeId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.grade.id = :pGradeId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGradeId", gradeId).getResultList();
    }

    public List<Employee> findByPayroll(Payroll payroll) {
        return this.findByPayrollId(payroll.getId());
    }

    public List<Employee> findByPayrollId(Long payrollId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select e from Employee e where e.clientId = :pClientId and e.payroll.id = :pPayrollId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayrollId", payrollId).getResultList();
    }

    public List<Employee> findByContacts(EmployeeContact contacts) {
        return this.findByContactsId(contacts.getId());
    }

    public List<Employee> findByContactsId(Long contactsId) {
        return (List<Employee>) this.em
                .createQuery(
                        "select distinct e from Employee e , IN (e.contacts) c where e.clientId = :pClientId and c.id = :pContactsId",
                        Employee.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pContactsId", contactsId).getResultList();
    }

}
