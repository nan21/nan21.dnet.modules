/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;

public interface IInvTransactionService extends IEntityService<InvTransaction> {

    public List<InvTransaction> findByTransactionType(
            InvTransactionType transactionType);

    public List<InvTransaction> findByTransactionTypeId(Long transactionTypeId);

    public List<InvTransaction> findByFromInventory(Organization fromInventory);

    public List<InvTransaction> findByFromInventoryId(Long fromInventoryId);

    public List<InvTransaction> findByToInventory(Organization toInventory);

    public List<InvTransaction> findByToInventoryId(Long toInventoryId);

}
