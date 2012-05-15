/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

public class PayScalePointDsConv extends
        AbstractDsConverter<PayScalePointDs, PayScalePoint> implements
        IDsConverter<PayScalePointDs, PayScalePoint> {

    @Override
    protected void modelToEntityReferences(PayScalePointDs ds, PayScalePoint e,
            boolean isInsert) throws Exception {

        if (ds.getPayScaleId() != null) {
            if (e.getPayScale() == null
                    || !e.getPayScale().getId().equals(ds.getPayScaleId())) {
                e.setPayScale((PayScale) this.em.find(PayScale.class,
                        ds.getPayScaleId()));
            }
        }

    }

}
