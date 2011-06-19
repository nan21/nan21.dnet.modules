/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateAverage;

public interface ICurrencyXRateAverageService extends
        IEntityService<CurrencyXRateAverage> {

    public List<CurrencyXRateAverage> findByProvider(
            CurrencyXRateProvider provider);

    public List<CurrencyXRateAverage> findByProviderId(Long providerId);

    public List<CurrencyXRateAverage> findBySource(Currency source);

    public List<CurrencyXRateAverage> findBySourceId(Long sourceId);

    public List<CurrencyXRateAverage> findByTarget(Currency target);

    public List<CurrencyXRateAverage> findByTargetId(Long targetId);

}
