/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.business.service.IEducationTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

public class EmployeeEducationDsConv extends
        AbstractDsConverter<EmployeeEducationDs, EmployeeEducation> implements
        IDsConverter<EmployeeEducationDs, EmployeeEducation> {

    @Override
    protected void modelToEntityReferences(EmployeeEducationDs ds,
            EmployeeEducation e, boolean isInsert) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((EducationType) this.em.find(EducationType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_EducationType(ds, e);
        }

    }

    protected void lookup_type_EducationType(EmployeeEducationDs ds,
            EmployeeEducation e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            EducationType x = null;
            try {
                x = ((IEducationTypeService) findEntityService(EducationType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `EducationType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
