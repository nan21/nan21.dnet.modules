/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.geo.domain.entity.Country;

public interface ICountryService extends IEntityService<Country> {

    public Country findByCode(Long clientId, String code);

    public Country findByName(Long clientId, String name);

}
