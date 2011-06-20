/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

public class ElementTypeLovDsConv extends
        AbstractDsConverter<ElementTypeLovDs, ElementType> implements
        IDsConverter<ElementTypeLovDs, ElementType> {

    protected void modelToEntityAttributes(ElementTypeLovDs ds, ElementType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ElementTypeLovDs ds, ElementType e)
            throws Exception {
    }

    @Override
    public void entityToModel(ElementType e, ElementTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
