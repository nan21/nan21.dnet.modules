/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeWorkExperienceDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeWorkExperience;

public class EmployeeWorkExperienceDsConv extends
        AbstractDsConverter<EmployeeWorkExperienceDs, EmployeeWorkExperience>
        implements
        IDsConverter<EmployeeWorkExperienceDs, EmployeeWorkExperience> {

    protected void modelToEntityAttributes(EmployeeWorkExperienceDs ds,
            EmployeeWorkExperience e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setFromDate(ds.getFromDate());
        e.setToDate(ds.getToDate());
        e.setInstitute(ds.getInstitute());
        e.setNotes(ds.getNotes());
    }

    protected void modelToEntityReferences(EmployeeWorkExperienceDs ds,
            EmployeeWorkExperience e) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }
    }

    @Override
    public void entityToModel(EmployeeWorkExperience e,
            EmployeeWorkExperienceDs ds) throws Exception {
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
        ds.setNotes(e.getNotes());
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
    }

}
