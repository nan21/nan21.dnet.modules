/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.GradeRateDs;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

public class GradeRateDsConv extends
        AbstractDsConverter<GradeRateDs, GradeRate> implements
        IDsConverter<GradeRateDs, GradeRate> {

    @Override
    protected void modelToEntityReferences(GradeRateDs ds, GradeRate e,
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

    }

    protected void lookup_currency_Currency(GradeRateDs ds, GradeRate e)
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

}
