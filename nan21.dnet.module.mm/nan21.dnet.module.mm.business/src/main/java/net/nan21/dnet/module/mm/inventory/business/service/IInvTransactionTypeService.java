/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionAction;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionSourceType;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

public interface IInvTransactionTypeService extends
        IEntityService<InvTransactionType> {

    public InvTransactionType findByName(Long clientId, String name);

    public List<InvTransactionType> findBySourceType(
            InvTransactionSourceType sourceType);

    public List<InvTransactionType> findBySourceTypeId(Long sourceTypeId);

    public List<InvTransactionType> findByAction(InvTransactionAction action);

    public List<InvTransactionType> findByActionId(Long actionId);

}
