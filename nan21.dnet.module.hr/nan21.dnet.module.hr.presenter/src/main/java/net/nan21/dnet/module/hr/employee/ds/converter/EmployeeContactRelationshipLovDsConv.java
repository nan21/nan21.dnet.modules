/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactRelationshipLovDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

public class EmployeeContactRelationshipLovDsConv
        extends
        AbstractDsConverter<EmployeeContactRelationshipLovDs, EmployeeContactRelationship>
        implements
        IDsConverter<EmployeeContactRelationshipLovDs, EmployeeContactRelationship> {

    protected void modelToEntityAttributes(EmployeeContactRelationshipLovDs ds,
            EmployeeContactRelationship e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(EmployeeContactRelationshipLovDs ds,
            EmployeeContactRelationship e) throws Exception {
    }

    @Override
    public void entityToModel(EmployeeContactRelationship e,
            EmployeeContactRelationshipLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
