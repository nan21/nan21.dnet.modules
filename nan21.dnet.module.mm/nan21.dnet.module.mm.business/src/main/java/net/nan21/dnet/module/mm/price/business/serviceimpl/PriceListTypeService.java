/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.price.business.service.IPriceListTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListType;

public class PriceListTypeService extends AbstractEntityService<PriceListType>
        implements IPriceListTypeService {

    public PriceListTypeService() {
        super();
    }

    public PriceListTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PriceListType> getEntityClass() {
        return PriceListType.class;
    }

    public PriceListType findByName(String name) {
        return (PriceListType) this.em
                .createNamedQuery(PriceListType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
