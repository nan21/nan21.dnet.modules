/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;
import net.nan21.dnet.module.hr.grade.domain.service.IPayScalePointService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

public class PayScaleRateValueDsConv extends
        AbstractDsConverter<PayScaleRateValueDs, PayScaleRateValue> implements
        IDsConverter<PayScaleRateValueDs, PayScaleRateValue> {

    protected void modelToEntityAttributes(PayScaleRateValueDs ds,
            PayScaleRateValue e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValue(ds.getValue());
        e.setValidFrom(ds.getValidFrom());
        e.setValidTo(ds.getValidTo());
    }

    protected void modelToEntityReferences(PayScaleRateValueDs ds,
            PayScaleRateValue e) throws Exception {

        if (ds.getScaleRateId() != null) {
            if (e.getScaleRate() == null
                    || !e.getScaleRate().getId().equals(ds.getScaleRateId())) {
                e.setScaleRate((PayScaleRate) this.em.getReference(
                        PayScaleRate.class, ds.getScaleRateId()));
            }
        }
        if (ds.getScalePointId() != null) {
            if (e.getScalePoint() == null
                    || !e.getScalePoint().getId().equals(ds.getScalePointId())) {
                e.setScalePoint((PayScalePoint) this.em.getReference(
                        PayScalePoint.class, ds.getScalePointId()));
            }
        } else {
            this.lookup_scalePoint_PayScalePoint(ds, e);
        }
    }

    protected void lookup_scalePoint_PayScalePoint(PayScaleRateValueDs ds,
            PayScaleRateValue e) throws Exception {
        PayScalePoint x = null;
        try {
            x = ((IPayScalePointService) getService(IPayScalePointService.class))
                    .findByScale_code(ds.getClientId(), ds.getScaleRateId(),
                            ds.getScalePointCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setScalePoint(x);
    }

    @Override
    public void entityToModel(PayScaleRateValue e, PayScaleRateValueDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setValue(e.getValue());
        ds.setValidFrom(e.getValidFrom());
        ds.setValidTo(e.getValidTo());
        ds.setScaleRateId(((e.getScaleRate() != null)) ? e.getScaleRate()
                .getId() : null);
        ds.setScalePointId(((e.getScalePoint() != null)) ? e.getScalePoint()
                .getId() : null);
        ds.setScalePointCode(((e.getScalePoint() != null)) ? e.getScalePoint()
                .getCode() : null);
    }

}
