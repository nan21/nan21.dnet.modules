/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.mm.price.business.service.IPriceListTypeService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.price.ds.model.PriceListDs;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;

public class PriceListDsConv extends
        AbstractDsConverter<PriceListDs, PriceList> implements
        IDsConverter<PriceListDs, PriceList> {

    protected void modelToEntityReferences(PriceListDs ds, PriceList e)
            throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((PriceListType) this.em.find(PriceListType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_PriceListType(ds, e);
        }
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

    protected void lookup_type_PriceListType(PriceListDs ds, PriceList e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            PriceListType x = null;
            try {
                x = ((IPriceListTypeService) findEntityService(PriceListType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PriceListType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_currency_Currency(PriceListDs ds, PriceList e)
            throws Exception {
        if (ds.getCurrency() != null && !ds.getCurrency().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getClientId(), ds.getCurrency());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Currency` reference:  `currency` = "
                                + ds.getCurrency() + "  ");
            }
            e.setCurrency(x);

        } else {
            e.setCurrency(null);
        }
    }

}
