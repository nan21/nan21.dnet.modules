/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

public interface IInvTransactionTypeService extends
        IEntityService<InvTransactionType> {

    public InvTransactionType findByName(String name);

    public List<InvTransactionType> findByDocType(TxDocType docType);

    public List<InvTransactionType> findByDocTypeId(Long docTypeId);

}
