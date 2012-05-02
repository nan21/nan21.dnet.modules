/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

import net.nan21.dnet.module.md.org.domain.entity.StockLocator;

public interface IStockLocatorService extends IEntityService<StockLocator> {

    public StockLocator findByName(String name);

    public List<StockLocator> findBySubInventory(SubInventory subInventory);

    public List<StockLocator> findBySubInventoryId(Long subInventoryId);

    public List<StockLocator> findByLocatorType(StockLocatorType locatorType);

    public List<StockLocator> findByLocatorTypeId(Long locatorTypeId);

}
