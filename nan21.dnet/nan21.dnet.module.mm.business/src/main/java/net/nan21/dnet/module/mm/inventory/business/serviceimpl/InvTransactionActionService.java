/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionActionService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionAction;

public class InvTransactionActionService extends
        AbstractEntityService<InvTransactionAction> implements
        IInvTransactionActionService {

    public InvTransactionActionService() {
        super();
    }

    public InvTransactionActionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransactionAction> getEntityClass() {
        return InvTransactionAction.class;
    }

    public InvTransactionAction findByName(Long clientId, String name) {
        return (InvTransactionAction) this.em
                .createNamedQuery(InvTransactionAction.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
