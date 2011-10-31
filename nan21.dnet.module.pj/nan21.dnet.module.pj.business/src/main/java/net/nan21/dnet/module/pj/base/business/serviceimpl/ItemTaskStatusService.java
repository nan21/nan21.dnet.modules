/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemTaskStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskStatus;

public class ItemTaskStatusService extends
        AbstractEntityService<ItemTaskStatus> implements IItemTaskStatusService {

    public ItemTaskStatusService() {
        super();
    }

    public ItemTaskStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemTaskStatus> getEntityClass() {
        return ItemTaskStatus.class;
    }

    public ItemTaskStatus findByName(Long clientId, String name) {
        return (ItemTaskStatus) this.em
                .createNamedQuery(ItemTaskStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
