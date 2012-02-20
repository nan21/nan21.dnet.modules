/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.grade.business.service.IPayScalePointService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

public class PayScaleRateValueDsConv extends
        AbstractDsConverter<PayScaleRateValueDs, PayScaleRateValue> implements
        IDsConverter<PayScaleRateValueDs, PayScaleRateValue> {

    @Override
    protected void modelToEntityReferences(PayScaleRateValueDs ds,
            PayScaleRateValue e, boolean isInsert) throws Exception {

        if (ds.getScaleRateId() != null) {
            if (e.getScaleRate() == null
                    || !e.getScaleRate().getId().equals(ds.getScaleRateId())) {
                e.setScaleRate((PayScaleRate) this.em.find(PayScaleRate.class,
                        ds.getScaleRateId()));
            }
        }

        if (ds.getScalePointId() != null) {
            if (e.getScalePoint() == null
                    || !e.getScalePoint().getId().equals(ds.getScalePointId())) {
                e.setScalePoint((PayScalePoint) this.em.find(
                        PayScalePoint.class, ds.getScalePointId()));
            }
        } else {
            this.lookup_scalePoint_PayScalePoint(ds, e);
        }

    }

    protected void lookup_scalePoint_PayScalePoint(PayScaleRateValueDs ds,
            PayScaleRateValue e) throws Exception {
        if (ds.getScaleRateId() != null && !ds.getScaleRateId().equals("")
                && ds.getScalePointCode() != null
                && !ds.getScalePointCode().equals("")) {
            PayScalePoint x = null;
            try {
                x = ((IPayScalePointService) findEntityService(PayScalePoint.class))
                        .findByScale_code(ds.getScaleRateId(),
                                ds.getScalePointCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PayScalePoint` reference:  `scaleRateId` = "
                                + ds.getScaleRateId()
                                + " , `scalePointCode` = "
                                + ds.getScalePointCode() + "  ");
            }
            e.setScalePoint(x);

        } else {
            e.setScalePoint(null);
        }
    }

}
