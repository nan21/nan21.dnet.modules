/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.PayScaleLovDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

public class PayScaleLovDsConv extends
        AbstractDsConverter<PayScaleLovDs, PayScale> implements
        IDsConverter<PayScaleLovDs, PayScale> {

    protected void modelToEntityAttributes(PayScaleLovDs ds, PayScale e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(PayScaleLovDs ds, PayScale e)
            throws Exception {
    }

    @Override
    public void entityToModel(PayScale e, PayScaleLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
