/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemTaskTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTaskType;

public class ItemTaskTypeService extends AbstractEntityService<ItemTaskType>
        implements IItemTaskTypeService {

    public ItemTaskTypeService() {
        super();
    }

    public ItemTaskTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemTaskType> getEntityClass() {
        return ItemTaskType.class;
    }

    public ItemTaskType findByName(Long clientId, String name) {
        return (ItemTaskType) this.em
                .createNamedQuery(ItemTaskType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
