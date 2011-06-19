/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

public class PayScalePointLovDsConv extends
        AbstractDsConverter<PayScalePointLovDs, PayScalePoint> implements
        IDsConverter<PayScalePointLovDs, PayScalePoint> {

    protected void modelToEntityAttributes(PayScalePointLovDs ds,
            PayScalePoint e) throws Exception {
        e.setCode(ds.getName());
        e.setClientId(ds.getClientId());
    }

    protected void modelToEntityReferences(PayScalePointLovDs ds,
            PayScalePoint e) throws Exception {
    }

    @Override
    public void entityToModel(PayScalePoint e, PayScalePointLovDs ds)
            throws Exception {
        ds.setName(e.getCode());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setPayScaleId(((e.getPayScale() != null)) ? e.getPayScale().getId()
                : null);
    }

}
