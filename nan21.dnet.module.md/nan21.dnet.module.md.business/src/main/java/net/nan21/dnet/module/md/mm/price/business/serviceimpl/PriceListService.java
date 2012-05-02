/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

public class PriceListService extends AbstractEntityService<PriceList> {

    public PriceListService() {
        super();
    }

    public PriceListService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PriceList> getEntityClass() {
        return PriceList.class;
    }

    public PriceList findByName(String name) {
        return (PriceList) this.em.createNamedQuery(PriceList.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<PriceList> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<PriceList> findByCurrencyId(Long currencyId) {
        return (List<PriceList>) this.em
                .createQuery(
                        "select e from PriceList e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        PriceList.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
