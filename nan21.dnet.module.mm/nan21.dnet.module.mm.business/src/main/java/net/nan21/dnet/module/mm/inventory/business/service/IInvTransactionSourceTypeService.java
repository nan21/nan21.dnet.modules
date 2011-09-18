/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionSourceType;

public interface IInvTransactionSourceTypeService extends
        IEntityService<InvTransactionSourceType> {

    public InvTransactionSourceType findByName(Long clientId, String name);

}