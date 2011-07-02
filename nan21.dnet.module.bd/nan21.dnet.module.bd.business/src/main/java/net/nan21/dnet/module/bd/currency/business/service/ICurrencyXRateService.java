/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;

public interface ICurrencyXRateService extends IEntityService<CurrencyXRate> {

    public CurrencyXRate findByValid(Long clientId,
            CurrencyXRateProvider provider, Currency source, Currency target,
            Date validAt);

    public CurrencyXRate findByValid(Long clientId, Long providerId,
            Long sourceId, Long targetId, Date validAt);

    public List<CurrencyXRate> findByProvider(CurrencyXRateProvider provider);

    public List<CurrencyXRate> findByProviderId(Long providerId);

    public List<CurrencyXRate> findBySource(Currency source);

    public List<CurrencyXRate> findBySourceId(Long sourceId);

    public List<CurrencyXRate> findByTarget(Currency target);

    public List<CurrencyXRate> findByTargetId(Long targetId);

}
