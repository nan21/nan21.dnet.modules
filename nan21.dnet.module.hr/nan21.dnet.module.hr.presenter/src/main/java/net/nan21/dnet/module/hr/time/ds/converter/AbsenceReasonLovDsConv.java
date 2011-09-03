/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;

public class AbsenceReasonLovDsConv extends
        AbstractDsConverter<AbsenceReasonLovDs, AbsenceReason> implements
        IDsConverter<AbsenceReasonLovDs, AbsenceReason> {

    protected void modelToEntityAttributes(AbsenceReasonLovDs ds,
            AbsenceReason e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AbsenceReasonLovDs ds,
            AbsenceReason e) throws Exception {
    }

    @Override
    public void entityToModel(AbsenceReason e, AbsenceReasonLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
    }

}
