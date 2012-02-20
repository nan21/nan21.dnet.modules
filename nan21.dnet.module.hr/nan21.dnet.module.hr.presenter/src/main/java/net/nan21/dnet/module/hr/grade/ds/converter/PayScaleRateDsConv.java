/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDs;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

public class PayScaleRateDsConv extends
        AbstractDsConverter<PayScaleRateDs, PayScaleRate> implements
        IDsConverter<PayScaleRateDs, PayScaleRate> {

    @Override
    protected void modelToEntityReferences(PayScaleRateDs ds, PayScaleRate e,
            boolean isInsert) throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }

        if (ds.getPayScaleId() != null) {
            if (e.getPayScale() == null
                    || !e.getPayScale().getId().equals(ds.getPayScaleId())) {
                e.setPayScale((PayScale) this.em.find(PayScale.class,
                        ds.getPayScaleId()));
            }
        } else {
            this.lookup_payScale_PayScale(ds, e);
        }

    }

    protected void lookup_currency_Currency(PayScaleRateDs ds, PayScaleRate e)
            throws Exception {
        if (ds.getCurrencyCode() != null && !ds.getCurrencyCode().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getCurrencyCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Currency` reference:  `currencyCode` = "
                                + ds.getCurrencyCode() + "  ");
            }
            e.setCurrency(x);

        } else {
            e.setCurrency(null);
        }
    }

    protected void lookup_payScale_PayScale(PayScaleRateDs ds, PayScaleRate e)
            throws Exception {
        if (ds.getPayScaleCode() != null && !ds.getPayScaleCode().equals("")) {
            PayScale x = null;
            try {
                x = ((IPayScaleService) findEntityService(PayScale.class))
                        .findByCode(ds.getPayScaleCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PayScale` reference:  `payScaleCode` = "
                                + ds.getPayScaleCode() + "  ");
            }
            e.setPayScale(x);

        } else {
            e.setPayScale(null);
        }
    }

}
