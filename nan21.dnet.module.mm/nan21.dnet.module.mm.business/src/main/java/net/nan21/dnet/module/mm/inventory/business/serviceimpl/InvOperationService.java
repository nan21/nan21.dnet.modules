/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.business.service.IInvOperationService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvOperation;

public class InvOperationService extends AbstractEntityService<InvOperation>
        implements IInvOperationService {

    public InvOperationService() {
        super();
    }

    public InvOperationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvOperation> getEntityClass() {
        return InvOperation.class;
    }

    public List<InvOperation> findByInventory(Organization inventory) {
        return this.findByInventoryId(inventory.getId());
    }

    public List<InvOperation> findByInventoryId(Long inventoryId) {
        return (List<InvOperation>) this.em
                .createQuery(
                        "select e from InvOperation e where e.clientId = :pClientId and  e.inventory.id = :pInventoryId",
                        InvOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInventoryId", inventoryId).getResultList();
    }

    public List<InvOperation> findBySubInventory(SubInventory subInventory) {
        return this.findBySubInventoryId(subInventory.getId());
    }

    public List<InvOperation> findBySubInventoryId(Long subInventoryId) {
        return (List<InvOperation>) this.em
                .createQuery(
                        "select e from InvOperation e where e.clientId = :pClientId and  e.subInventory.id = :pSubInventoryId",
                        InvOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSubInventoryId", subInventoryId)
                .getResultList();
    }

    public List<InvOperation> findByLocator(StockLocator locator) {
        return this.findByLocatorId(locator.getId());
    }

    public List<InvOperation> findByLocatorId(Long locatorId) {
        return (List<InvOperation>) this.em
                .createQuery(
                        "select e from InvOperation e where e.clientId = :pClientId and  e.locator.id = :pLocatorId",
                        InvOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLocatorId", locatorId).getResultList();
    }

    public List<InvOperation> findByItem(Product item) {
        return this.findByItemId(item.getId());
    }

    public List<InvOperation> findByItemId(Long itemId) {
        return (List<InvOperation>) this.em
                .createQuery(
                        "select e from InvOperation e where e.clientId = :pClientId and  e.item.id = :pItemId",
                        InvOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemId", itemId).getResultList();
    }

    public List<InvOperation> findByTransactionLine(
            InvTransactionLine transactionLine) {
        return this.findByTransactionLineId(transactionLine.getId());
    }

    public List<InvOperation> findByTransactionLineId(Long transactionLineId) {
        return (List<InvOperation>) this.em
                .createQuery(
                        "select e from InvOperation e where e.clientId = :pClientId and  e.transactionLine.id = :pTransactionLineId",
                        InvOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTransactionLineId", transactionLineId)
                .getResultList();
    }

}
