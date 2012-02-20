/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionTypeService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionAction;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionSourceType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

public class InvTransactionTypeService extends
        AbstractEntityService<InvTransactionType> implements
        IInvTransactionTypeService {

    public InvTransactionTypeService() {
        super();
    }

    public InvTransactionTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransactionType> getEntityClass() {
        return InvTransactionType.class;
    }

    public InvTransactionType findByName(String name) {
        return (InvTransactionType) this.em
                .createNamedQuery(InvTransactionType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<InvTransactionType> findBySourceType(
            InvTransactionSourceType sourceType) {
        return this.findBySourceTypeId(sourceType.getId());
    }

    public List<InvTransactionType> findBySourceTypeId(Long sourceTypeId) {
        return (List<InvTransactionType>) this.em
                .createQuery(
                        "select e from InvTransactionType e where e.clientId = :pClientId and  e.sourceType.id = :pSourceTypeId",
                        InvTransactionType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSourceTypeId", sourceTypeId).getResultList();
    }

    public List<InvTransactionType> findByAction(InvTransactionAction action) {
        return this.findByActionId(action.getId());
    }

    public List<InvTransactionType> findByActionId(Long actionId) {
        return (List<InvTransactionType>) this.em
                .createQuery(
                        "select e from InvTransactionType e where e.clientId = :pClientId and  e.action.id = :pActionId",
                        InvTransactionType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pActionId", actionId).getResultList();
    }

}
