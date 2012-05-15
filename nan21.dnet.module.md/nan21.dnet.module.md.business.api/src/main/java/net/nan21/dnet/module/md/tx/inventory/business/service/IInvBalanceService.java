/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvBalance;

public interface IInvBalanceService extends IEntityService<InvBalance> {

    public List<InvBalance> findBySubInventory(SubInventory subInventory);

    public List<InvBalance> findBySubInventoryId(Long subInventoryId);

    public List<InvBalance> findByLocator(StockLocator locator);

    public List<InvBalance> findByLocatorId(Long locatorId);

    public List<InvBalance> findByItem(Product item);

    public List<InvBalance> findByItemId(Long itemId);

    public List<InvBalance> findByUom(Uom uom);

    public List<InvBalance> findByUomId(Long uomId);

}
