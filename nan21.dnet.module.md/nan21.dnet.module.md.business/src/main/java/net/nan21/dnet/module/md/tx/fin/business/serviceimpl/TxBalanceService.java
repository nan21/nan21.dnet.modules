/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.fin.business.service.ITxBalanceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxBalance;

public class TxBalanceService extends AbstractEntityService<TxBalance>
        implements ITxBalanceService {

    public TxBalanceService() {
        super();
    }

    public TxBalanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<TxBalance> getEntityClass() {
        return TxBalance.class;
    }

    public List<TxBalance> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<TxBalance> findByBpartnerId(Long bpartnerId) {
        return (List<TxBalance>) this.em
                .createQuery(
                        "select e from TxBalance e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        TxBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<TxBalance> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<TxBalance> findByOrgId(Long orgId) {
        return (List<TxBalance>) this.em
                .createQuery(
                        "select e from TxBalance e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        TxBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<TxBalance> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<TxBalance> findByCurrencyId(Long currencyId) {
        return (List<TxBalance>) this.em
                .createQuery(
                        "select e from TxBalance e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        TxBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
