/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementLovDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

public class ElementLovDsConv extends
        AbstractDsConverter<ElementLovDs, Element> implements
        IDsConverter<ElementLovDs, Element> {

    protected void modelToEntityAttributes(ElementLovDs ds, Element e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ElementLovDs ds, Element e)
            throws Exception {
    }

    @Override
    public void entityToModel(Element e, ElementLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
