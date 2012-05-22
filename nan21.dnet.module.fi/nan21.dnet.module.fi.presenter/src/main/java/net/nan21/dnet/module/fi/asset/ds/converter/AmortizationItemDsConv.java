/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.fi.asset.ds.model.AmortizationItemDs;
import net.nan21.dnet.module.fi.asset.domain.entity.AmortizationItem;

public class AmortizationItemDsConv extends
        AbstractDsConverter<AmortizationItemDs, AmortizationItem> implements
        IDsConverter<AmortizationItemDs, AmortizationItem> {

    @Override
    protected void modelToEntityReferences(AmortizationItemDs ds,
            AmortizationItem e, boolean isInsert) throws Exception {

        if (ds.getAssetId() != null) {
            if (e.getAsset() == null
                    || !e.getAsset().getId().equals(ds.getAssetId())) {
                e.setAsset((Asset) this.em.find(Asset.class, ds.getAssetId()));
            }
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

    protected void lookup_currency_Currency(AmortizationItemDs ds,
            AmortizationItem e) throws Exception {
        if (ds.getCurrency() != null && !ds.getCurrency().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getCurrency());
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
