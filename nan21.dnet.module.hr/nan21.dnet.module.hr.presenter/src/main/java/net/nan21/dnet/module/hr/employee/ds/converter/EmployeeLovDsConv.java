/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDs;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public class EmployeeLovDsConv extends
        AbstractDsConverter<EmployeeLovDs, Employee> implements
        IDsConverter<EmployeeLovDs, Employee> {

    protected void modelToEntityAttributes(EmployeeLovDs ds, Employee e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setFirstName(ds.getFirstName());
        e.setLastName(ds.getLastName());
        e.setName(ds.getName());
        e.setCode(ds.getCode());
    }

    protected void modelToEntityReferences(EmployeeLovDs ds, Employee e)
            throws Exception {
    }

    @Override
    public void entityToModel(Employee e, EmployeeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setFirstName(e.getFirstName());
        ds.setLastName(e.getLastName());
        ds.setName(e.getName());
        ds.setCode(e.getCode());
    }

}
