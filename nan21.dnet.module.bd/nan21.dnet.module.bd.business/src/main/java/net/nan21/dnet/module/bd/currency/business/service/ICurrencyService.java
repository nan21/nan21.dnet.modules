/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

public interface ICurrencyService extends IEntityService<Currency> {

    public Currency findByCode(String code);

    public Currency findByName(String name);

}
