/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionSourceTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionSourceType;

public class InvTransactionSourceTypeService extends
        AbstractEntityService<InvTransactionSourceType> implements
        IInvTransactionSourceTypeService {

    public InvTransactionSourceTypeService() {
        super();
    }

    public InvTransactionSourceTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransactionSourceType> getEntityClass() {
        return InvTransactionSourceType.class;
    }

    public InvTransactionSourceType findByName(Long clientId, String name) {
        return (InvTransactionSourceType) this.em
                .createNamedQuery(InvTransactionSourceType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}