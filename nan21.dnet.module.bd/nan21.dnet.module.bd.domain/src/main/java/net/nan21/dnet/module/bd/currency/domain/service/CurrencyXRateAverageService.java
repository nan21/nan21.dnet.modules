/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.domain.service;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateAverage;

public class CurrencyXRateAverageService extends
        AbstractEntityService<CurrencyXRateAverage> {

    public CurrencyXRateAverageService() {
        super();
    }

    public CurrencyXRateAverageService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CurrencyXRateAverage> getEntityClass() {
        return CurrencyXRateAverage.class;
    }

    public List<CurrencyXRateAverage> findByProvider(
            CurrencyXRateProvider provider) {
        return this.findByProviderId(provider.getId());
    }

    public List<CurrencyXRateAverage> findByProviderId(Long providerId) {
        return (List<CurrencyXRateAverage>) this.em
                .createQuery(
                        "select e from CurrencyXRateAverage where e.provider.id = :pProviderId",
                        CurrencyXRateAverage.class)
                .setParameter("pProviderId", providerId).getResultList();
    }

    public List<CurrencyXRateAverage> findBySource(Currency source) {
        return this.findBySourceId(source.getId());
    }

    public List<CurrencyXRateAverage> findBySourceId(Long sourceId) {
        return (List<CurrencyXRateAverage>) this.em
                .createQuery(
                        "select e from CurrencyXRateAverage where e.source.id = :pSourceId",
                        CurrencyXRateAverage.class)
                .setParameter("pSourceId", sourceId).getResultList();
    }

    public List<CurrencyXRateAverage> findByTarget(Currency target) {
        return this.findByTargetId(target.getId());
    }

    public List<CurrencyXRateAverage> findByTargetId(Long targetId) {
        return (List<CurrencyXRateAverage>) this.em
                .createQuery(
                        "select e from CurrencyXRateAverage where e.target.id = :pTargetId",
                        CurrencyXRateAverage.class)
                .setParameter("pTargetId", targetId).getResultList();
    }

}
