/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateProviderService;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDs;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateAverage;

public class CurrencyXRateAverageDsConv extends
        AbstractDsConverter<CurrencyXRateAverageDs, CurrencyXRateAverage>
        implements IDsConverter<CurrencyXRateAverageDs, CurrencyXRateAverage> {

    protected void modelToEntityReferences(CurrencyXRateAverageDs ds,
            CurrencyXRateAverage e) throws Exception {
        if (ds.getProviderId() != null) {
            if (e.getProvider() == null
                    || !e.getProvider().getId().equals(ds.getProviderId())) {
                e.setProvider((CurrencyXRateProvider) this.em.find(
                        CurrencyXRateProvider.class, ds.getProviderId()));
            }
        } else {
            this.lookup_provider_CurrencyXRateProvider(ds, e);
        }
    }

    protected void lookup_provider_CurrencyXRateProvider(
            CurrencyXRateAverageDs ds, CurrencyXRateAverage e) throws Exception {
        if (ds.getProviderCode() != null && !ds.getProviderCode().equals("")) {
            CurrencyXRateProvider x = null;
            try {
                x = ((ICurrencyXRateProviderService) findEntityService(CurrencyXRateProvider.class))
                        .findByCode(ds.getClientId(), ds.getProviderCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CurrencyXRateProvider` reference:  `providerCode` = "
                                + ds.getProviderCode() + "  ");
            }
            e.setProvider(x);

        } else {
            e.setProvider(null);
        }
    }

}
