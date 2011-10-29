/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemResolutionService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;

public class ItemResolutionService extends
        AbstractEntityService<ItemResolution> implements IItemResolutionService {

    public ItemResolutionService() {
        super();
    }

    public ItemResolutionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemResolution> getEntityClass() {
        return ItemResolution.class;
    }

    public ItemResolution findByName(Long clientId, String name) {
        return (ItemResolution) this.em
                .createNamedQuery(ItemResolution.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
