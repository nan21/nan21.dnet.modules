/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemPriorityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;

public class ItemPriorityService extends AbstractEntityService<ItemPriority>
        implements IItemPriorityService {

    public ItemPriorityService() {
        super();
    }

    public ItemPriorityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemPriority> getEntityClass() {
        return ItemPriority.class;
    }

    public ItemPriority findByName(Long clientId, String name) {
        return (ItemPriority) this.em
                .createNamedQuery(ItemPriority.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
