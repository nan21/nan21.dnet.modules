/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(PayScalePointDs ds, PayScalePoint e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
        e.setCode(ds.getCode());
    }

    protected void modelToEntityReferences(PayScalePointDs ds, PayScalePoint e)
            throws Exception {

        if (ds.getPayScaleId() != null) {
            if (e.getPayScale() == null
                    || !e.getPayScale().getId().equals(ds.getPayScaleId())) {
                e.setPayScale((PayScale) this.em.getReference(PayScale.class,
                        ds.getPayScaleId()));
            }
        }
    }

    @Override
    public void entityToModel(PayScalePoint e, PayScalePointDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSequenceNo(e.getSequenceNo());
        ds.setCode(e.getCode());
        ds.setPayScaleId(((e.getPayScale() != null)) ? e.getPayScale().getId()
                : null);
    }

}
