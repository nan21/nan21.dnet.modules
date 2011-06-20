/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementCategoryLovDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;

public class ElementCategoryLovDsConv extends
        AbstractDsConverter<ElementCategoryLovDs, ElementCategory> implements
        IDsConverter<ElementCategoryLovDs, ElementCategory> {

    protected void modelToEntityAttributes(ElementCategoryLovDs ds,
            ElementCategory e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ElementCategoryLovDs ds,
            ElementCategory e) throws Exception {
    }

    @Override
    public void entityToModel(ElementCategory e, ElementCategoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
