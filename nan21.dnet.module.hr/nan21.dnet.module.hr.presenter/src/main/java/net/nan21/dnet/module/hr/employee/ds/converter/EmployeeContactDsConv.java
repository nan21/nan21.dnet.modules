/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.service.IEmployeeContactRelationshipService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

public class EmployeeContactDsConv extends
        AbstractDsConverter<EmployeeContactDs, EmployeeContact> implements
        IDsConverter<EmployeeContactDs, EmployeeContact> {

    protected void modelToEntityAttributes(EmployeeContactDs ds,
            EmployeeContact e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setFirstName(ds.getFirstName());
        e.setLastName(ds.getLastName());
        e.setBirthdate(ds.getBirthdate());
        e.setGender(ds.getGender());
        e.setIsDependent(ds.getIsDependent());
    }

    protected void modelToEntityReferences(EmployeeContactDs ds,
            EmployeeContact e) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.getReference(Employee.class,
                        ds.getEmployeeId()));
            }
        }
        if (ds.getRelationshipId() != null) {
            if (e.getRelationship() == null
                    || !e.getRelationship().getId()
                            .equals(ds.getRelationshipId())) {
                e.setRelationship((EmployeeContactRelationship) this.em
                        .getReference(EmployeeContactRelationship.class,
                                ds.getRelationshipId()));
            }
        } else {
            this.lookup_relationship_EmployeeContactRelationship(ds, e);
        }
    }

    protected void lookup_relationship_EmployeeContactRelationship(
            EmployeeContactDs ds, EmployeeContact e) throws Exception {
        EmployeeContactRelationship x = null;
        try {
            x = ((IEmployeeContactRelationshipService) getService(IEmployeeContactRelationshipService.class))
                    .findByName(ds.getClientId(), ds.getRelationship());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setRelationship(x);
    }

    @Override
    public void entityToModel(EmployeeContact e, EmployeeContactDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setFirstName(e.getFirstName());
        ds.setLastName(e.getLastName());
        ds.setBirthdate(e.getBirthdate());
        ds.setGender(e.getGender());
        ds.setIsDependent(e.getIsDependent());
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
        ds.setRelationshipId(((e.getRelationship() != null)) ? e
                .getRelationship().getId() : null);
        ds.setRelationship(((e.getRelationship() != null)) ? e
                .getRelationship().getName() : null);
    }

}
