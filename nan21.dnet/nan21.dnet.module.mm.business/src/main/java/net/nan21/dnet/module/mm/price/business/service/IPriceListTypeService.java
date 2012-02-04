/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.mm.price.domain.entity.PriceListType;

public interface IPriceListTypeService extends IEntityService<PriceListType> {

    public PriceListType findByName(Long clientId, String name);

}
