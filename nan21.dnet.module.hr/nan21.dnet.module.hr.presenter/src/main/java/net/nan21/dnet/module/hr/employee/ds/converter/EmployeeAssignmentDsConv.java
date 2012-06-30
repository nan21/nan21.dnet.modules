/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.business.service.IEmploymentTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.business.service.IGradeService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.business.service.IJobService;
import net.nan21.dnet.module.hr.job.business.service.IPositionService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;

public class EmployeeAssignmentDsConv extends
        AbstractDsConverter<EmployeeAssignmentDs, EmployeeAssignment> implements
        IDsConverter<EmployeeAssignmentDs, EmployeeAssignment> {

    @Override
    protected void modelToEntityReferences(EmployeeAssignmentDs ds,
            EmployeeAssignment e, boolean isInsert) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        } else {
            this.lookup_employee_Employee(ds, e);
        }

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((EmploymentType) this.em.find(EmploymentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_EmploymentType(ds, e);
        }

        if (ds.getPositionId() != null) {
            if (e.getPosition() == null
                    || !e.getPosition().getId().equals(ds.getPositionId())) {
                e.setPosition((Position) this.em.find(Position.class,
                        ds.getPositionId()));
            }
        } else {
            this.lookup_position_Position(ds, e);
        }

        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.find(Job.class, ds.getJobId()));
            }
        } else {
            this.lookup_job_Job(ds, e);
        }

        if (ds.getOrgId() != null) {
            if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
                e.setOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_org_Organization(ds, e);
        }

        if (ds.getGradeId() != null) {
            if (e.getGrade() == null
                    || !e.getGrade().getId().equals(ds.getGradeId())) {
                e.setGrade((Grade) this.em.find(Grade.class, ds.getGradeId()));
            }
        } else {
            this.lookup_grade_Grade(ds, e);
        }

        if (ds.getPayrollId() != null) {
            if (e.getPayroll() == null
                    || !e.getPayroll().getId().equals(ds.getPayrollId())) {
                e.setPayroll((Payroll) this.em.find(Payroll.class,
                        ds.getPayrollId()));
            }
        } else {
            this.lookup_payroll_Payroll(ds, e);
        }

    }

    protected void lookup_employee_Employee(EmployeeAssignmentDs ds,
            EmployeeAssignment e) throws Exception {
        if (ds.getEmployerCode() != null && !ds.getEmployerCode().equals("")) {
            Employee x = null;
            try {
                x = ((IEmployeeService) findEntityService(Employee.class))
                        .findByCode(ds.getEmployerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Employee` reference:  `employerCode` = "
                                + ds.getEmployerCode() + "  ");
            }
            e.setEmployee(x);

        } else {
            e.setEmployee(null);
        }
    }

    protected void lookup_type_EmploymentType(EmployeeAssignmentDs ds,
            EmployeeAssignment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            EmploymentType x = null;
            try {
                x = ((IEmploymentTypeService) findEntityService(EmploymentType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `EmploymentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_position_Position(EmployeeAssignmentDs ds,
            EmployeeAssignment e) throws Exception {
        if (ds.getPositionCode() != null && !ds.getPositionCode().equals("")) {
            Position x = null;
            try {
                x = ((IPositionService) findEntityService(Position.class))
                        .findByCode(ds.getPositionCode());
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

    protected void lookup_job_Job(EmployeeAssignmentDs ds, EmployeeAssignment e)
            throws Exception {
        if (ds.getJobCode() != null && !ds.getJobCode().equals("")) {
            Job x = null;
            try {
                x = ((IJobService) findEntityService(Job.class)).findByCode(ds
                        .getJobCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Job` reference:  `jobCode` = "
                                + ds.getJobCode() + "  ");
            }
            e.setJob(x);

        } else {
            e.setJob(null);
        }
    }

    protected void lookup_org_Organization(EmployeeAssignmentDs ds,
            EmployeeAssignment e) throws Exception {
        if (ds.getOrg() != null && !ds.getOrg().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getOrg());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `org` = "
                                + ds.getOrg() + "  ");
            }
            e.setOrg(x);

        } else {
            e.setOrg(null);
        }
    }

    protected void lookup_grade_Grade(EmployeeAssignmentDs ds,
            EmployeeAssignment e) throws Exception {
        if (ds.getGradeCode() != null && !ds.getGradeCode().equals("")) {
            Grade x = null;
            try {
                x = ((IGradeService) findEntityService(Grade.class))
                        .findByCode(ds.getGradeCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Grade` reference:  `gradeCode` = "
                                + ds.getGradeCode() + "  ");
            }
            e.setGrade(x);

        } else {
            e.setGrade(null);
        }
    }

    protected void lookup_payroll_Payroll(EmployeeAssignmentDs ds,
            EmployeeAssignment e) throws Exception {
        if (ds.getPayroll() != null && !ds.getPayroll().equals("")) {
            Payroll x = null;
            try {
                x = ((IPayrollService) findEntityService(Payroll.class))
                        .findByName(ds.getPayroll());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Payroll` reference:  `payroll` = "
                                + ds.getPayroll() + "  ");
            }
            e.setPayroll(x);

        } else {
            e.setPayroll(null);
        }
    }

}
