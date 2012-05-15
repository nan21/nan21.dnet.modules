/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

public class CurrencyService extends AbstractEntityService<Currency> implements
        ICurrencyService {

    public CurrencyService() {
        super();
    }

    public CurrencyService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Currency> getEntityClass() {
        return Currency.class;
    }

    public Currency findByCode(String code) {
        return (Currency) this.em.createNamedQuery(Currency.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Currency findByName(String name) {
        return (Currency) this.em.createNamedQuery(Currency.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
