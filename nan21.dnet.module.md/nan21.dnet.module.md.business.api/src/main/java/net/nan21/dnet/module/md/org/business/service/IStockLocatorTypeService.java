/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;

public interface IStockLocatorTypeService extends
        IEntityService<StockLocatorType> {

    public StockLocatorType findByName(String name);

}
