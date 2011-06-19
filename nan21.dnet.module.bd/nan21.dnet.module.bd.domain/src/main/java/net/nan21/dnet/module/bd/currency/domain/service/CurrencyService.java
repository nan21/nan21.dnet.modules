/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.domain.service;

import net.nan21.dnet.core.domain.service.AbstractEntityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

public class CurrencyService extends AbstractEntityService<Currency> {

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

    public Currency findByCode(Long clientId, String code) {
        return (Currency) this.em.createNamedQuery(Currency.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Currency findByName(Long clientId, String name) {
        return (Currency) this.em.createNamedQuery(Currency.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
