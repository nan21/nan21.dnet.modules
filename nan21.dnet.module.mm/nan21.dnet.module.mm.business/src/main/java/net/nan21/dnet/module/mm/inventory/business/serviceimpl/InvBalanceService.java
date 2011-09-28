/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.inventory.business.service.IInvBalanceService;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvBalance;

public class InvBalanceService extends AbstractEntityService<InvBalance>
        implements IInvBalanceService {

    public InvBalanceService() {
        super();
    }

    public InvBalanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvBalance> getEntityClass() {
        return InvBalance.class;
    }

    public List<InvBalance> findBySubInventory(SubInventory subInventory) {
        return this.findBySubInventoryId(subInventory.getId());
    }

    public List<InvBalance> findBySubInventoryId(Long subInventoryId) {
        return (List<InvBalance>) this.em
                .createQuery(
                        "select e from InvBalance e where e.subInventory.id = :pSubInventoryId",
                        InvBalance.class)
                .setParameter("pSubInventoryId", subInventoryId)
                .getResultList();
    }

    public List<InvBalance> findByLocator(StockLocator locator) {
        return this.findByLocatorId(locator.getId());
    }

    public List<InvBalance> findByLocatorId(Long locatorId) {
        return (List<InvBalance>) this.em
                .createQuery(
                        "select e from InvBalance e where e.locator.id = :pLocatorId",
                        InvBalance.class).setParameter("pLocatorId", locatorId)
                .getResultList();
    }

    public List<InvBalance> findByItem(Product item) {
        return this.findByItemId(item.getId());
    }

    public List<InvBalance> findByItemId(Long itemId) {
        return (List<InvBalance>) this.em
                .createQuery(
                        "select e from InvBalance e where e.item.id = :pItemId",
                        InvBalance.class).setParameter("pItemId", itemId)
                .getResultList();
    }

    public List<InvBalance> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<InvBalance> findByUomId(Long uomId) {
        return (List<InvBalance>) this.em
                .createQuery(
                        "select e from InvBalance e where e.uom.id = :pUomId",
                        InvBalance.class).setParameter("pUomId", uomId)
                .getResultList();
    }

}
