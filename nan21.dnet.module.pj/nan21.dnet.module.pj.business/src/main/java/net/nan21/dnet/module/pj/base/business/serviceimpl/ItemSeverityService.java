/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemSeverityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemSeverity;

public class ItemSeverityService extends AbstractEntityService<ItemSeverity>
        implements IItemSeverityService {

    public ItemSeverityService() {
        super();
    }

    public ItemSeverityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemSeverity> getEntityClass() {
        return ItemSeverity.class;
    }

    public ItemSeverity findByName(Long clientId, String name) {
        return (ItemSeverity) this.em
                .createNamedQuery(ItemSeverity.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
