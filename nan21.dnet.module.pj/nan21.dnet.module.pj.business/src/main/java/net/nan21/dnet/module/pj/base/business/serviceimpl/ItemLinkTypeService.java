/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemLinkTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemLinkType;

public class ItemLinkTypeService extends AbstractEntityService<ItemLinkType>
        implements IItemLinkTypeService {

    public ItemLinkTypeService() {
        super();
    }

    public ItemLinkTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemLinkType> getEntityClass() {
        return ItemLinkType.class;
    }

    public ItemLinkType findByName(Long clientId, String name) {
        return (ItemLinkType) this.em
                .createNamedQuery(ItemLinkType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
