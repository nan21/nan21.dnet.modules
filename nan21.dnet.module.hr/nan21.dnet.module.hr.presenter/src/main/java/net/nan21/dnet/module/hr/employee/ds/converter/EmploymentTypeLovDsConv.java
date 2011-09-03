/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;

public class EmploymentTypeLovDsConv extends
        AbstractDsConverter<EmploymentTypeLovDs, EmploymentType> implements
        IDsConverter<EmploymentTypeLovDs, EmploymentType> {

    protected void modelToEntityAttributes(EmploymentTypeLovDs ds,
            EmploymentType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(EmploymentTypeLovDs ds,
            EmploymentType e) throws Exception {
    }

    @Override
    public void entityToModel(EmploymentType e, EmploymentTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
