/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceReasonService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceTypeService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceDs;
import net.nan21.dnet.module.hr.time.domain.entity.Absence;

public class AbsenceDsConv extends AbstractDsConverter<AbsenceDs, Absence>
        implements IDsConverter<AbsenceDs, Absence> {

    @Override
    protected void modelToEntityReferences(AbsenceDs ds, Absence e,
            boolean isInsert) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        } else {
            this.lookup_employee_Employee(ds, e);
        }

        if (ds.getReasonId() != null) {
            if (e.getReason() == null
                    || !e.getReason().getId().equals(ds.getReasonId())) {
                e.setReason((AbsenceReason) this.em.find(AbsenceReason.class,
                        ds.getReasonId()));
            }
        } else {
            this.lookup_reason_AbsenceReason(ds, e);
        }

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AbsenceType) this.em.find(AbsenceType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AbsenceType(ds, e);
        }

    }

    protected void lookup_employee_Employee(AbsenceDs ds, Absence e)
            throws Exception {
        if (ds.getEmployeeCode() != null && !ds.getEmployeeCode().equals("")) {
            Employee x = null;
            try {
                x = ((IEmployeeService) findEntityService(Employee.class))
                        .findByCode(ds.getEmployeeCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Employee` reference:  `employeeCode` = "
                                + ds.getEmployeeCode() + "  ");
            }
            e.setEmployee(x);

        } else {
            e.setEmployee(null);
        }
    }

    protected void lookup_reason_AbsenceReason(AbsenceDs ds, Absence e)
            throws Exception {
        if (ds.getReason() != null && !ds.getReason().equals("")) {
            AbsenceReason x = null;
            try {
                x = ((IAbsenceReasonService) findEntityService(AbsenceReason.class))
                        .findByName(ds.getReason());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AbsenceReason` reference:  `reason` = "
                                + ds.getReason() + "  ");
            }
            e.setReason(x);

        } else {
            e.setReason(null);
        }
    }

    protected void lookup_type_AbsenceType(AbsenceDs ds, Absence e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AbsenceType x = null;
            try {
                x = ((IAbsenceTypeService) findEntityService(AbsenceType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AbsenceType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
