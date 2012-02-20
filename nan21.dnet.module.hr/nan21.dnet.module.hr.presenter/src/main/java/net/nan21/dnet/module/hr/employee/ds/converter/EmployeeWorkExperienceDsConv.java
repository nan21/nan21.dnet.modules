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

    @Override
    protected void modelToEntityReferences(EmployeeWorkExperienceDs ds,
            EmployeeWorkExperience e, boolean isInsert) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }

    }

}
