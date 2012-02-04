/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.inventory.business.service.IStockLocatorTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocatorType;

public class StockLocatorTypeService extends
        AbstractEntityService<StockLocatorType> implements
        IStockLocatorTypeService {

    public StockLocatorTypeService() {
        super();
    }

    public StockLocatorTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<StockLocatorType> getEntityClass() {
        return StockLocatorType.class;
    }

    public StockLocatorType findByName(Long clientId, String name) {
        return (StockLocatorType) this.em
                .createNamedQuery(StockLocatorType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
