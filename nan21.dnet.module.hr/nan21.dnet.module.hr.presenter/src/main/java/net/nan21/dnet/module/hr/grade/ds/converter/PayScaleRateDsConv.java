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

    protected void modelToEntityAttributes(PayScaleRateDs ds, PayScaleRate e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(PayScaleRateDs ds, PayScaleRate e)
            throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.getReference(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }
        if (ds.getPayScaleId() != null) {
            if (e.getPayScale() == null
                    || !e.getPayScale().getId().equals(ds.getPayScaleId())) {
                e.setPayScale((PayScale) this.em.getReference(PayScale.class,
                        ds.getPayScaleId()));
            }
        } else {
            this.lookup_payScale_PayScale(ds, e);
        }
    }

    protected void lookup_currency_Currency(PayScaleRateDs ds, PayScaleRate e)
            throws Exception {
        Currency x = null;
        try {
            x = ((ICurrencyService) getService(ICurrencyService.class))
                    .findByCode(ds.getClientId(), ds.getCurrencyCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCurrency(x);
    }

    protected void lookup_payScale_PayScale(PayScaleRateDs ds, PayScaleRate e)
            throws Exception {
        PayScale x = null;
        try {
            x = ((IPayScaleService) getService(IPayScaleService.class))
                    .findByCode(ds.getClientId(), ds.getPayScaleCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setPayScale(x);
    }

    @Override
    public void entityToModel(PayScaleRate e, PayScaleRateDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setPayScaleId(((e.getPayScale() != null)) ? e.getPayScale().getId()
                : null);
        ds.setPayScaleCode(((e.getPayScale() != null)) ? e.getPayScale()
                .getCode() : null);
        ds.setPayScaleName(((e.getPayScale() != null)) ? e.getPayScale()
                .getName() : null);
        ds.setCurrencyId(((e.getCurrency() != null)) ? e.getCurrency().getId()
                : null);
        ds.setCurrencyCode(((e.getCurrency() != null)) ? e.getCurrency()
                .getCode() : null);
    }

}
