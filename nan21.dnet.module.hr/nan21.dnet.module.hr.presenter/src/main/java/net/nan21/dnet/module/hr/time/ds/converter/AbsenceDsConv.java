/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(AbsenceDs ds, Absence e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setEventDate(ds.getEventDate());
        e.setHours(ds.getHours());
        e.setNotes(ds.getNotes());
        e.setPosted(ds.getPosted());
    }

    protected void modelToEntityReferences(AbsenceDs ds, Absence e)
            throws Exception {

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
                x = ((IEmployeeService) getService(IEmployeeService.class))
                        .findByCode(ds.getClientId(), ds.getEmployeeCode());
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
                x = ((IAbsenceReasonService) getService(IAbsenceReasonService.class))
                        .findByName(ds.getClientId(), ds.getReason());
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
                x = ((IAbsenceTypeService) getService(IAbsenceTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
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

    @Override
    public void entityToModel(Absence e, AbsenceDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setEventDate(e.getEventDate());
        ds.setHours(e.getHours());
        ds.setNotes(e.getNotes());
        ds.setPosted(e.getPosted());
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
        ds.setEmployeeCode(((e.getEmployee() != null)) ? e.getEmployee()
                .getCode() : null);
        ds.setEmployee(((e.getEmployee() != null)) ? e.getEmployee().getName()
                : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setReasonId(((e.getReason() != null)) ? e.getReason().getId() : null);
        ds.setReason(((e.getReason() != null)) ? e.getReason().getName() : null);
    }

}
