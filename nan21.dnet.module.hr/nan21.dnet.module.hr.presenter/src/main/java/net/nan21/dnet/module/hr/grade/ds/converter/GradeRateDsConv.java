/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.service.ICurrencyService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.grade.ds.model.GradeRateDs;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

public class GradeRateDsConv extends
        AbstractDsConverter<GradeRateDs, GradeRate> implements
        IDsConverter<GradeRateDs, GradeRate> {

    protected void modelToEntityAttributes(GradeRateDs ds, GradeRate e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(GradeRateDs ds, GradeRate e)
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
    }

    protected void lookup_currency_Currency(GradeRateDs ds, GradeRate e)
            throws Exception {
        Currency x = null;
        try {
            x = ((ICurrencyService) getService(ICurrencyService.class))
                    .findByCode(ds.getClientId(), ds.getCurrencyCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCurrency(x);
    }

    @Override
    public void entityToModel(GradeRate e, GradeRateDs ds) throws Exception {
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
        ds.setCurrencyId(((e.getCurrency() != null)) ? e.getCurrency().getId()
                : null);
        ds.setCurrencyCode(((e.getCurrency() != null)) ? e.getCurrency()
                .getCode() : null);
    }

}
