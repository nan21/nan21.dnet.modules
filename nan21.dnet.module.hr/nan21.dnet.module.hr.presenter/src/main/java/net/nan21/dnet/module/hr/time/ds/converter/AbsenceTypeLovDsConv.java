/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeLovDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

public class AbsenceTypeLovDsConv extends
        AbstractDsConverter<AbsenceTypeLovDs, AbsenceType> implements
        IDsConverter<AbsenceTypeLovDs, AbsenceType> {

    protected void modelToEntityAttributes(AbsenceTypeLovDs ds, AbsenceType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AbsenceTypeLovDs ds, AbsenceType e)
            throws Exception {
    }

    @Override
    public void entityToModel(AbsenceType e, AbsenceTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
