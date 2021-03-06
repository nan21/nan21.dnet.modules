/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;

public class CurrencyXRateService extends AbstractEntityService<CurrencyXRate>
        implements ICurrencyXRateService {

    public CurrencyXRateService() {
        super();
    }

    public CurrencyXRateService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CurrencyXRate> getEntityClass() {
        return CurrencyXRate.class;
    }

    public CurrencyXRate findByValid(CurrencyXRateProvider provider,
            Currency source, Currency target, Date validAt) {
        return (CurrencyXRate) this.em
                .createNamedQuery(CurrencyXRate.NQ_FIND_BY_VALID)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProvider", provider)
                .setParameter("pSource", source)
                .setParameter("pTarget", target)
                .setParameter("pValidAt", validAt).getSingleResult();
    }

    public CurrencyXRate findByValid(Long providerId, Long sourceId,
            Long targetId, Date validAt) {
        return (CurrencyXRate) this.em
                .createNamedQuery(CurrencyXRate.NQ_FIND_BY_VALID_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProviderId", providerId)
                .setParameter("pSourceId", sourceId)
                .setParameter("pTargetId", targetId)
                .setParameter("pValidAt", validAt).getSingleResult();
    }

    public List<CurrencyXRate> findByProvider(CurrencyXRateProvider provider) {
        return this.findByProviderId(provider.getId());
    }

    public List<CurrencyXRate> findByProviderId(Long providerId) {
        return (List<CurrencyXRate>) this.em
                .createQuery(
                        "select e from CurrencyXRate e where e.clientId = :pClientId and e.provider.id = :pProviderId",
                        CurrencyXRate.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProviderId", providerId).getResultList();
    }

    public List<CurrencyXRate> findBySource(Currency source) {
        return this.findBySourceId(source.getId());
    }

    public List<CurrencyXRate> findBySourceId(Long sourceId) {
        return (List<CurrencyXRate>) this.em
                .createQuery(
                        "select e from CurrencyXRate e where e.clientId = :pClientId and e.source.id = :pSourceId",
                        CurrencyXRate.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSourceId", sourceId).getResultList();
    }

    public List<CurrencyXRate> findByTarget(Currency target) {
        return this.findByTargetId(target.getId());
    }

    public List<CurrencyXRate> findByTargetId(Long targetId) {
        return (List<CurrencyXRate>) this.em
                .createQuery(
                        "select e from CurrencyXRate e where e.clientId = :pClientId and e.target.id = :pTargetId",
                        CurrencyXRate.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTargetId", targetId).getResultList();
    }

}
