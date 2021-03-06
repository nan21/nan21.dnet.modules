/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

public interface IPriceListService extends IEntityService<PriceList> {

    public PriceList findByName(String name);

    public List<PriceList> findByCurrency(Currency currency);

    public List<PriceList> findByCurrencyId(Long currencyId);

    public PriceList findDefaultPriceList(boolean salesList) throws Exception;

}
