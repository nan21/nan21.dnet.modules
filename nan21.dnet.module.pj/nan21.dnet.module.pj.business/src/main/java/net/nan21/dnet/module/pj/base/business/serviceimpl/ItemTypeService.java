/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IItemTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;

public class ItemTypeService extends AbstractEntityService<ItemType> implements
        IItemTypeService {

    public ItemTypeService() {
        super();
    }

    public ItemTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemType> getEntityClass() {
        return ItemType.class;
    }

    public ItemType findByName(Long clientId, String name) {
        return (ItemType) this.em.createNamedQuery(ItemType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ItemType> findByCategory(ItemCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<ItemType> findByCategoryId(Long categoryId) {
        return (List<ItemType>) this.em
                .createQuery(
                        "select e from ItemType e where e.category.id = :pCategoryId",
                        ItemType.class).setParameter("pCategoryId", categoryId)
                .getResultList();
    }

    public List<ItemType> findByProjectTypes(ProjectType projectTypes) {
        return this.findByProjectTypesId(projectTypes.getId());
    }

    public List<ItemType> findByProjectTypesId(Long projectTypesId) {
        return (List<ItemType>) this.em
                .createQuery(
                        "select e from ItemType e where e.projectTypes.id = :pProjectTypesId",
                        ItemType.class)
                .setParameter("pProjectTypesId", projectTypesId)
                .getResultList();
    }

}
