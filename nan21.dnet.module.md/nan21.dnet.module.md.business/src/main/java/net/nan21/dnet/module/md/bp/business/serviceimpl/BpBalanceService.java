/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.bp.business.service.IBpBalanceService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.BpBalance;

public class BpBalanceService extends AbstractEntityService<BpBalance>
        implements IBpBalanceService {

    public BpBalanceService() {
        super();
    }

    public BpBalanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BpBalance> getEntityClass() {
        return BpBalance.class;
    }

    public List<BpBalance> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<BpBalance> findByBpartnerId(Long bpartnerId) {
        return (List<BpBalance>) this.em
                .createQuery(
                        "select e from BpBalance e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        BpBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<BpBalance> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<BpBalance> findByOrgId(Long orgId) {
        return (List<BpBalance>) this.em
                .createQuery(
                        "select e from BpBalance e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        BpBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<BpBalance> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<BpBalance> findByCurrencyId(Long currencyId) {
        return (List<BpBalance>) this.em
                .createQuery(
                        "select e from BpBalance e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        BpBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
