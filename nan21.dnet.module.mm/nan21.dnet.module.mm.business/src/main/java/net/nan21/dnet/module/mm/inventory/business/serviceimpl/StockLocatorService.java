/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.inventory.business.service.IStockLocatorService;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocatorType;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;

public class StockLocatorService extends AbstractEntityService<StockLocator>
        implements IStockLocatorService {

    public StockLocatorService() {
        super();
    }

    public StockLocatorService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<StockLocator> getEntityClass() {
        return StockLocator.class;
    }

    public StockLocator findByName(Long clientId, String name) {
        return (StockLocator) this.em
                .createNamedQuery(StockLocator.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<StockLocator> findBySubInventory(SubInventory subInventory) {
        return this.findBySubInventoryId(subInventory.getId());
    }

    public List<StockLocator> findBySubInventoryId(Long subInventoryId) {
        return (List<StockLocator>) this.em
                .createQuery(
                        "select e from StockLocator e where e.subInventory.id = :pSubInventoryId",
                        StockLocator.class)
                .setParameter("pSubInventoryId", subInventoryId)
                .getResultList();
    }

    public List<StockLocator> findByLocatorType(StockLocatorType locatorType) {
        return this.findByLocatorTypeId(locatorType.getId());
    }

    public List<StockLocator> findByLocatorTypeId(Long locatorTypeId) {
        return (List<StockLocator>) this.em
                .createQuery(
                        "select e from StockLocator e where e.locatorType.id = :pLocatorTypeId",
                        StockLocator.class)
                .setParameter("pLocatorTypeId", locatorTypeId).getResultList();
    }

}