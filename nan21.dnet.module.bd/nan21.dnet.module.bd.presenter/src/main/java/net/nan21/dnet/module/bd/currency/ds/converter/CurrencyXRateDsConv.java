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

    protected void modelToEntityAttributes(CurrencyXRateDs ds, CurrencyXRate e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setValidAt(ds.getValidAt());
        e.setValue(ds.getValue());
    }

    protected void modelToEntityReferences(CurrencyXRateDs ds, CurrencyXRate e)
            throws Exception {

        if (ds.getSourceId() != null) {
            if (e.getSource() == null
                    || !e.getSource().getId().equals(ds.getSourceId())) {
                e.setSource((Currency) this.em.getReference(Currency.class,
                        ds.getSourceId()));
            }
        }
        if (ds.getTargetId() != null) {
            if (e.getTarget() == null
                    || !e.getTarget().getId().equals(ds.getTargetId())) {
                e.setTarget((Currency) this.em.getReference(Currency.class,
                        ds.getTargetId()));
            }
        }
        if (ds.getProviderId() != null) {
            if (e.getProvider() == null
                    || !e.getProvider().getId().equals(ds.getProviderId())) {
                e.setProvider((CurrencyXRateProvider) this.em.getReference(
                        CurrencyXRateProvider.class, ds.getProviderId()));
            }
        } else {
            this.lookup_provider_CurrencyXRateProvider(ds, e);
        }
    }

    protected void lookup_provider_CurrencyXRateProvider(CurrencyXRateDs ds,
            CurrencyXRate e) throws Exception {
        if (ds.getProviderCode() != null) {
            CurrencyXRateProvider x = null;
            try {
                x = ((ICurrencyXRateProviderService) getService(ICurrencyXRateProviderService.class))
                        .findByCode(ds.getClientId(), ds.getProviderCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CurrencyXRateProvider` reference:  `providerCode` = "
                                + ds.getProviderCode() + "  ");
            }
            e.setProvider(x);
        }
    }

    @Override
    public void entityToModel(CurrencyXRate e, CurrencyXRateDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setValidAt(e.getValidAt());
        ds.setValue(e.getValue());
        ds.setSourceId(((e.getSource() != null)) ? e.getSource().getId() : null);
        ds.setSourceCode(((e.getSource() != null)) ? e.getSource().getCode()
                : null);
        ds.setTargetId(((e.getTarget() != null)) ? e.getTarget().getId() : null);
        ds.setTargetCode(((e.getTarget() != null)) ? e.getTarget().getCode()
                : null);
        ds.setProviderId(((e.getProvider() != null)) ? e.getProvider().getId()
                : null);
        ds.setProviderCode(((e.getProvider() != null)) ? e.getProvider()
                .getCode() : null);
    }

}
