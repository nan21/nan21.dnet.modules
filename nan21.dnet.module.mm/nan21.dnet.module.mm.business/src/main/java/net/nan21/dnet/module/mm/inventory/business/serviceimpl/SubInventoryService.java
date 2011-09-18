/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.inventory.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.business.service.ISubInventoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;

public class SubInventoryService extends AbstractEntityService<SubInventory>
        implements ISubInventoryService {

    public SubInventoryService() {
        super();
    }

    public SubInventoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SubInventory> getEntityClass() {
        return SubInventory.class;
    }

    public SubInventory findByName(Long clientId, String name) {
        return (SubInventory) this.em
                .createNamedQuery(SubInventory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<SubInventory> findByInventory(Organization inventory) {
        return this.findByInventoryId(inventory.getId());
    }

    public List<SubInventory> findByInventoryId(Long inventoryId) {
        return (List<SubInventory>) this.em
                .createQuery(
                        "select e from SubInventory e where e.inventory.id = :pInventoryId",
                        SubInventory.class)
                .setParameter("pInventoryId", inventoryId).getResultList();
    }

}
