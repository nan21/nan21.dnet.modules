/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

public class AbsenceCategoryLovDsConv extends
        AbstractDsConverter<AbsenceCategoryLovDs, AbsenceCategory> implements
        IDsConverter<AbsenceCategoryLovDs, AbsenceCategory> {

    protected void modelToEntityAttributes(AbsenceCategoryLovDs ds,
            AbsenceCategory e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AbsenceCategoryLovDs ds,
            AbsenceCategory e) throws Exception {
    }

    @Override
    public void entityToModel(AbsenceCategory e, AbsenceCategoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
