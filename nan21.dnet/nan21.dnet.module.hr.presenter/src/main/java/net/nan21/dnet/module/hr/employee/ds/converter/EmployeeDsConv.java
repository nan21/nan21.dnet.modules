/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.business.service.IEmploymentTypeService;
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
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public class EmployeeDsConv extends AbstractDsConverter<EmployeeDs, Employee>
        implements IDsConverter<EmployeeDs, Employee> {

    protected void modelToEntityReferences(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getEmployerId() != null) {
            if (e.getEmployer() == null
                    || !e.getEmployer().getId().equals(ds.getEmployerId())) {
                e.setEmployer((Organization) this.em.find(Organization.class,
                        ds.getEmployerId()));
            }
        } else {
            this.lookup_employer_Organization(ds, e);
        }
        if (ds.getCitizenshipId() != null) {
            if (e.getCitizenship() == null
                    || !e.getCitizenship().getId()
                            .equals(ds.getCitizenshipId())) {
                e.setCitizenship((Country) this.em.find(Country.class,
                        ds.getCitizenshipId()));
            }
        } else {
            this.lookup_citizenship_Country(ds, e);
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
        if (ds.getOrganizationId() != null) {
            if (e.getOrganization() == null
                    || !e.getOrganization().getId()
                            .equals(ds.getOrganizationId())) {
                e.setOrganization((Organization) this.em.find(
                        Organization.class, ds.getOrganizationId()));
            }
        } else {
            this.lookup_organization_Organization(ds, e);
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

    protected void lookup_employer_Organization(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getEmployerCode() != null && !ds.getEmployerCode().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getClientId(), ds.getEmployerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `employerCode` = "
                                + ds.getEmployerCode() + "  ");
            }
            e.setEmployer(x);

        } else {
            e.setEmployer(null);
        }
    }

    protected void lookup_citizenship_Country(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getCitizenshipCode() != null
                && !ds.getCitizenshipCode().equals("")) {
            Country x = null;
            try {
                x = ((ICountryService) findEntityService(Country.class))
                        .findByCode(ds.getClientId(), ds.getCitizenshipCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Country` reference:  `citizenshipCode` = "
                                + ds.getCitizenshipCode() + "  ");
            }
            e.setCitizenship(x);

        } else {
            e.setCitizenship(null);
        }
    }

    protected void lookup_type_EmploymentType(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            EmploymentType x = null;
            try {
                x = ((IEmploymentTypeService) findEntityService(EmploymentType.class))
                        .findByName(ds.getClientId(), ds.getType());
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

    protected void lookup_position_Position(EmployeeDs ds, Employee e)
            throws Exception {
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

    protected void lookup_job_Job(EmployeeDs ds, Employee e) throws Exception {
        if (ds.getJobCode() != null && !ds.getJobCode().equals("")) {
            Job x = null;
            try {
                x = ((IJobService) findEntityService(Job.class)).findByCode(
                        ds.getClientId(), ds.getJobCode());
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

    protected void lookup_organization_Organization(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getOrganizationCode() != null
                && !ds.getOrganizationCode().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getClientId(), ds.getOrganizationCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `organizationCode` = "
                                + ds.getOrganizationCode() + "  ");
            }
            e.setOrganization(x);

        } else {
            e.setOrganization(null);
        }
    }

    protected void lookup_grade_Grade(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getGradeCode() != null && !ds.getGradeCode().equals("")) {
            Grade x = null;
            try {
                x = ((IGradeService) findEntityService(Grade.class))
                        .findByCode(ds.getClientId(), ds.getGradeCode());
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

    protected void lookup_payroll_Payroll(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getPayroll() != null && !ds.getPayroll().equals("")) {
            Payroll x = null;
            try {
                x = ((IPayrollService) findEntityService(Payroll.class))
                        .findByName(ds.getClientId(), ds.getPayroll());
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
