/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionLineService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;

public class InvTransactionLineService extends
        AbstractEntityService<InvTransactionLine> implements
        IInvTransactionLineService {

    public InvTransactionLineService() {
        super();
    }

    public InvTransactionLineService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransactionLine> getEntityClass() {
        return InvTransactionLine.class;
    }

    public List<InvTransactionLine> findByInvTransaction(
            InvTransaction invTransaction) {
        return this.findByInvTransactionId(invTransaction.getId());
    }

    public List<InvTransactionLine> findByInvTransactionId(Long invTransactionId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.invTransaction.id = :pInvTransactionId",
                        InvTransactionLine.class)
                .setParameter("pInvTransactionId", invTransactionId)
                .getResultList();
    }

    public List<InvTransactionLine> findByItem(Product item) {
        return this.findByItemId(item.getId());
    }

    public List<InvTransactionLine> findByItemId(Long itemId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.item.id = :pItemId",
                        InvTransactionLine.class)
                .setParameter("pItemId", itemId).getResultList();
    }

    public List<InvTransactionLine> findByFromSubInventory(
            SubInventory fromSubInventory) {
        return this.findByFromSubInventoryId(fromSubInventory.getId());
    }

    public List<InvTransactionLine> findByFromSubInventoryId(
            Long fromSubInventoryId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.fromSubInventory.id = :pFromSubInventoryId",
                        InvTransactionLine.class)
                .setParameter("pFromSubInventoryId", fromSubInventoryId)
                .getResultList();
    }

    public List<InvTransactionLine> findByFromLocator(StockLocator fromLocator) {
        return this.findByFromLocatorId(fromLocator.getId());
    }

    public List<InvTransactionLine> findByFromLocatorId(Long fromLocatorId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.fromLocator.id = :pFromLocatorId",
                        InvTransactionLine.class)
                .setParameter("pFromLocatorId", fromLocatorId).getResultList();
    }

    public List<InvTransactionLine> findByToSubInventory(
            SubInventory toSubInventory) {
        return this.findByToSubInventoryId(toSubInventory.getId());
    }

    public List<InvTransactionLine> findByToSubInventoryId(Long toSubInventoryId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.toSubInventory.id = :pToSubInventoryId",
                        InvTransactionLine.class)
                .setParameter("pToSubInventoryId", toSubInventoryId)
                .getResultList();
    }

    public List<InvTransactionLine> findByToLocator(StockLocator toLocator) {
        return this.findByToLocatorId(toLocator.getId());
    }

    public List<InvTransactionLine> findByToLocatorId(Long toLocatorId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.toLocator.id = :pToLocatorId",
                        InvTransactionLine.class)
                .setParameter("pToLocatorId", toLocatorId).getResultList();
    }

}
