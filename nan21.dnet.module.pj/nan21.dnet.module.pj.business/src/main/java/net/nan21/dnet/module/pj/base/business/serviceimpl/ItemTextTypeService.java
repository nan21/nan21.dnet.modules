/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemTextTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTextType;

public class ItemTextTypeService extends AbstractEntityService<ItemTextType>
        implements IItemTextTypeService {

    public ItemTextTypeService() {
        super();
    }

    public ItemTextTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemTextType> getEntityClass() {
        return ItemTextType.class;
    }

    public ItemTextType findByName(Long clientId, String name) {
        return (ItemTextType) this.em
                .createNamedQuery(ItemTextType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
