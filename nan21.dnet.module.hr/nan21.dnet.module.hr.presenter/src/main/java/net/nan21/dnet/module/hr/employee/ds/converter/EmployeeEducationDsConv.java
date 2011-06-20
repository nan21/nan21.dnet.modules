/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.service.IEducationTypeService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

public class EmployeeEducationDsConv extends
        AbstractDsConverter<EmployeeEducationDs, EmployeeEducation> implements
        IDsConverter<EmployeeEducationDs, EmployeeEducation> {

    protected void modelToEntityAttributes(EmployeeEducationDs ds,
            EmployeeEducation e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setFromDate(ds.getFromDate());
        e.setToDate(ds.getToDate());
        e.setInstitute(ds.getInstitute());
        e.setDegree(ds.getDegree());
        e.setNotes(ds.getNotes());
    }

    protected void modelToEntityReferences(EmployeeEducationDs ds,
            EmployeeEducation e) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.getReference(Employee.class,
                        ds.getEmployeeId()));
            }
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((EducationType) this.em.getReference(
                        EducationType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_EducationType(ds, e);
        }
    }

    protected void lookup_type_EducationType(EmployeeEducationDs ds,
            EmployeeEducation e) throws Exception {
        EducationType x = null;
        try {
            x = ((IEducationTypeService) getService(IEducationTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    @Override
    public void entityToModel(EmployeeEducation e, EmployeeEducationDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setFromDate(e.getFromDate());
        ds.setToDate(e.getToDate());
        ds.setInstitute(e.getInstitute());
        ds.setDegree(e.getDegree());
        ds.setNotes(e.getNotes());
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
