/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemLinkType;
import net.nan21.dnet.module.pj.md.business.service.IItemLinkService;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ItemLink;

public class ItemLinkService extends AbstractEntityService<ItemLink> implements
        IItemLinkService {

    public ItemLinkService() {
        super();
    }

    public ItemLinkService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemLink> getEntityClass() {
        return ItemLink.class;
    }

    public List<ItemLink> findBySourceItem(Item sourceItem) {
        return this.findBySourceItemId(sourceItem.getId());
    }

    public List<ItemLink> findBySourceItemId(Long sourceItemId) {
        return (List<ItemLink>) this.em
                .createQuery(
                        "select e from ItemLink e where e.sourceItem.id = :pSourceItemId",
                        ItemLink.class)
                .setParameter("pSourceItemId", sourceItemId).getResultList();
    }

    public List<ItemLink> findByTargetItem(Item targetItem) {
        return this.findByTargetItemId(targetItem.getId());
    }

    public List<ItemLink> findByTargetItemId(Long targetItemId) {
        return (List<ItemLink>) this.em
                .createQuery(
                        "select e from ItemLink e where e.targetItem.id = :pTargetItemId",
                        ItemLink.class)
                .setParameter("pTargetItemId", targetItemId).getResultList();
    }

    public List<ItemLink> findByLinkType(ItemLinkType linkType) {
        return this.findByLinkTypeId(linkType.getId());
    }

    public List<ItemLink> findByLinkTypeId(Long linkTypeId) {
        return (List<ItemLink>) this.em
                .createQuery(
                        "select e from ItemLink e where e.linkType.id = :pLinkTypeId",
                        ItemLink.class).setParameter("pLinkTypeId", linkTypeId)
                .getResultList();
    }

}
