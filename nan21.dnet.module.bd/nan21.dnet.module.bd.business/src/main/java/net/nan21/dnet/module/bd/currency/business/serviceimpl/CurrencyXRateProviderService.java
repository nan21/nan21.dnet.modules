/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateProviderService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

public class CurrencyXRateProviderService extends
        AbstractEntityService<CurrencyXRateProvider> implements
        ICurrencyXRateProviderService {

    public CurrencyXRateProviderService() {
        super();
    }

    public CurrencyXRateProviderService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CurrencyXRateProvider> getEntityClass() {
        return CurrencyXRateProvider.class;
    }

    public CurrencyXRateProvider findByCode(String code) {
        return (CurrencyXRateProvider) this.em
                .createNamedQuery(CurrencyXRateProvider.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public CurrencyXRateProvider findByName(String name) {
        return (CurrencyXRateProvider) this.em
                .createNamedQuery(CurrencyXRateProvider.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
