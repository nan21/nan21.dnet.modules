/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.org.business.service.IStockLocatorTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;

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

    public StockLocatorType findByName(String name) {
        return (StockLocatorType) this.em
                .createNamedQuery(StockLocatorType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
