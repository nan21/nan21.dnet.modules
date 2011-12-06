/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListType;

import net.nan21.dnet.module.mm.price.domain.entity.PriceList;

public interface IPriceListService extends IEntityService<PriceList> {

    public List<PriceList> findByType(PriceListType type);

    public List<PriceList> findByTypeId(Long typeId);

    public List<PriceList> findByCurrency(Currency currency);

    public List<PriceList> findByCurrencyId(Long currencyId);

}
