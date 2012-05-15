/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeContactRelationshipService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

public class EmployeeContactDsConv extends
        AbstractDsConverter<EmployeeContactDs, EmployeeContact> implements
        IDsConverter<EmployeeContactDs, EmployeeContact> {

    @Override
    protected void modelToEntityReferences(EmployeeContactDs ds,
            EmployeeContact e, boolean isInsert) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }

        if (ds.getRelationshipId() != null) {
            if (e.getRelationship() == null
                    || !e.getRelationship().getId()
                            .equals(ds.getRelationshipId())) {
                e.setRelationship((EmployeeContactRelationship) this.em.find(
                        EmployeeContactRelationship.class,
                        ds.getRelationshipId()));
            }
        } else {
            this.lookup_relationship_EmployeeContactRelationship(ds, e);
        }

    }

    protected void lookup_relationship_EmployeeContactRelationship(
            EmployeeContactDs ds, EmployeeContact e) throws Exception {
        if (ds.getRelationship() != null && !ds.getRelationship().equals("")) {
            EmployeeContactRelationship x = null;
            try {
                x = ((IEmployeeContactRelationshipService) findEntityService(EmployeeContactRelationship.class))
                        .findByName(ds.getRelationship());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `EmployeeContactRelationship` reference:  `relationship` = "
                                + ds.getRelationship() + "  ");
            }
            e.setRelationship(x);

        } else {
            e.setRelationship(null);
        }
    }

}
