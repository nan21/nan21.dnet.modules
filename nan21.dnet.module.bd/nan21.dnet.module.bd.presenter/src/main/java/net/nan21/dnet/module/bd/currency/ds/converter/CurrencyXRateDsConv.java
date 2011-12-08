/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.currency.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateProviderService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDs;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;

public class CurrencyXRateDsConv extends
        AbstractDsConverter<CurrencyXRateDs, CurrencyXRate> implements
        IDsConverter<CurrencyXRateDs, CurrencyXRate> {

    protected void modelToEntityReferences(CurrencyXRateDs ds, CurrencyXRate e)
            throws Exception {
        if (ds.getSourceId() != null) {
            if (e.getSource() == null
                    || !e.getSource().getId().equals(ds.getSourceId())) {
                e.setSource((Currency) this.em.find(Currency.class,
                        ds.getSourceId()));
            }
        }
        if (ds.getTargetId() != null) {
            if (e.getTarget() == null
                    || !e.getTarget().getId().equals(ds.getTargetId())) {
                e.setTarget((Currency) this.em.find(Currency.class,
                        ds.getTargetId()));
            }
        }
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

    protected void lookup_provider_CurrencyXRateProvider(CurrencyXRateDs ds,
            CurrencyXRate e) throws Exception {
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
