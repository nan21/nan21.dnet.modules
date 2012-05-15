/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.org.business.service.IStockLocatorService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;

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

    public StockLocator findByName(String name) {
        return (StockLocator) this.em
                .createNamedQuery(StockLocator.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<StockLocator> findBySubInventory(SubInventory subInventory) {
        return this.findBySubInventoryId(subInventory.getId());
    }

    public List<StockLocator> findBySubInventoryId(Long subInventoryId) {
        return (List<StockLocator>) this.em
                .createQuery(
                        "select e from StockLocator e where e.clientId = :pClientId and e.subInventory.id = :pSubInventoryId",
                        StockLocator.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSubInventoryId", subInventoryId)
                .getResultList();
    }

    public List<StockLocator> findByLocatorType(StockLocatorType locatorType) {
        return this.findByLocatorTypeId(locatorType.getId());
    }

    public List<StockLocator> findByLocatorTypeId(Long locatorTypeId) {
        return (List<StockLocator>) this.em
                .createQuery(
                        "select e from StockLocator e where e.clientId = :pClientId and e.locatorType.id = :pLocatorTypeId",
                        StockLocator.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLocatorTypeId", locatorTypeId).getResultList();
    }

}
