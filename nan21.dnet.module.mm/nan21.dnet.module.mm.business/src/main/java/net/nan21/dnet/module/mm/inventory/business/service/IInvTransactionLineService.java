/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;

public interface IInvTransactionLineService extends
        IEntityService<InvTransactionLine> {

    public List<InvTransactionLine> findByInvTransaction(
            InvTransaction invTransaction);

    public List<InvTransactionLine> findByInvTransactionId(Long invTransactionId);

    public List<InvTransactionLine> findByItem(Product item);

    public List<InvTransactionLine> findByItemId(Long itemId);

    public List<InvTransactionLine> findByFromSubInventory(
            SubInventory fromSubInventory);

    public List<InvTransactionLine> findByFromSubInventoryId(
            Long fromSubInventoryId);

    public List<InvTransactionLine> findByFromLocator(StockLocator fromLocator);

    public List<InvTransactionLine> findByFromLocatorId(Long fromLocatorId);

    public List<InvTransactionLine> findByToSubInventory(
            SubInventory toSubInventory);

    public List<InvTransactionLine> findByToSubInventoryId(Long toSubInventoryId);

    public List<InvTransactionLine> findByToLocator(StockLocator toLocator);

    public List<InvTransactionLine> findByToLocatorId(Long toLocatorId);

}
