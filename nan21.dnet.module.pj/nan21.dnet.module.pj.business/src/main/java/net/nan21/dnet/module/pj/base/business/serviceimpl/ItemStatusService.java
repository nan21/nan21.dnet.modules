/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemStatus;

public class ItemStatusService extends AbstractEntityService<ItemStatus>
        implements IItemStatusService {

    public ItemStatusService() {
        super();
    }

    public ItemStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemStatus> getEntityClass() {
        return ItemStatus.class;
    }

    public ItemStatus findByName(Long clientId, String name) {
        return (ItemStatus) this.em
                .createNamedQuery(ItemStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
