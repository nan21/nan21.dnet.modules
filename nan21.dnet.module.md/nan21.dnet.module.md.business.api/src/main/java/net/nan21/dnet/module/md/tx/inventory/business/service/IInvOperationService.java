/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;

import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvOperation;

public interface IInvOperationService extends IEntityService<InvOperation> {

    public List<InvOperation> findByInventory(Organization inventory);

    public List<InvOperation> findByInventoryId(Long inventoryId);

    public List<InvOperation> findBySubInventory(SubInventory subInventory);

    public List<InvOperation> findBySubInventoryId(Long subInventoryId);

    public List<InvOperation> findByLocator(StockLocator locator);

    public List<InvOperation> findByLocatorId(Long locatorId);

    public List<InvOperation> findByItem(Product item);

    public List<InvOperation> findByItemId(Long itemId);

    public List<InvOperation> findByTransactionLine(
            InvTransactionLine transactionLine);

    public List<InvOperation> findByTransactionLineId(Long transactionLineId);

    public List<InvOperation> findByUom(Uom uom);

    public List<InvOperation> findByUomId(Long uomId);

}
