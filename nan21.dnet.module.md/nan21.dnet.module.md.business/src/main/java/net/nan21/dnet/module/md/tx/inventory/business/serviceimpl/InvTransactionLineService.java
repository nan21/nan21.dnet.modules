/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionLineService;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;

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
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.invTransaction.id = :pInvTransactionId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInvTransactionId", invTransactionId)
                .getResultList();
    }

    public List<InvTransactionLine> findByItem(Product item) {
        return this.findByItemId(item.getId());
    }

    public List<InvTransactionLine> findByItemId(Long itemId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.item.id = :pItemId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
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
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.fromSubInventory.id = :pFromSubInventoryId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFromSubInventoryId", fromSubInventoryId)
                .getResultList();
    }

    public List<InvTransactionLine> findByFromLocator(StockLocator fromLocator) {
        return this.findByFromLocatorId(fromLocator.getId());
    }

    public List<InvTransactionLine> findByFromLocatorId(Long fromLocatorId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.fromLocator.id = :pFromLocatorId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFromLocatorId", fromLocatorId).getResultList();
    }

    public List<InvTransactionLine> findByToSubInventory(
            SubInventory toSubInventory) {
        return this.findByToSubInventoryId(toSubInventory.getId());
    }

    public List<InvTransactionLine> findByToSubInventoryId(Long toSubInventoryId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.toSubInventory.id = :pToSubInventoryId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pToSubInventoryId", toSubInventoryId)
                .getResultList();
    }

    public List<InvTransactionLine> findByToLocator(StockLocator toLocator) {
        return this.findByToLocatorId(toLocator.getId());
    }

    public List<InvTransactionLine> findByToLocatorId(Long toLocatorId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.toLocator.id = :pToLocatorId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pToLocatorId", toLocatorId).getResultList();
    }

    public List<InvTransactionLine> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<InvTransactionLine> findByUomId(Long uomId) {
        return (List<InvTransactionLine>) this.em
                .createQuery(
                        "select e from InvTransactionLine e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        InvTransactionLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

}
