/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;

public class InvTransactionService extends
        AbstractEntityService<InvTransaction> implements IInvTransactionService {

    public InvTransactionService() {
        super();
    }

    public InvTransactionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransaction> getEntityClass() {
        return InvTransaction.class;
    }

    public List<InvTransaction> findByTransactionType(
            InvTransactionType transactionType) {
        return this.findByTransactionTypeId(transactionType.getId());
    }

    public List<InvTransaction> findByTransactionTypeId(Long transactionTypeId) {
        return (List<InvTransaction>) this.em
                .createQuery(
                        "select e from InvTransaction e where e.transactionType.id = :pTransactionTypeId",
                        InvTransaction.class)
                .setParameter("pTransactionTypeId", transactionTypeId)
                .getResultList();
    }

    public List<InvTransaction> findByFromInventory(Organization fromInventory) {
        return this.findByFromInventoryId(fromInventory.getId());
    }

    public List<InvTransaction> findByFromInventoryId(Long fromInventoryId) {
        return (List<InvTransaction>) this.em
                .createQuery(
                        "select e from InvTransaction e where e.fromInventory.id = :pFromInventoryId",
                        InvTransaction.class)
                .setParameter("pFromInventoryId", fromInventoryId)
                .getResultList();
    }

    public List<InvTransaction> findByToInventory(Organization toInventory) {
        return this.findByToInventoryId(toInventory.getId());
    }

    public List<InvTransaction> findByToInventoryId(Long toInventoryId) {
        return (List<InvTransaction>) this.em
                .createQuery(
                        "select e from InvTransaction e where e.toInventory.id = :pToInventoryId",
                        InvTransaction.class)
                .setParameter("pToInventoryId", toInventoryId).getResultList();
    }

}