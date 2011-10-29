/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTextType;
import net.nan21.dnet.module.pj.md.business.service.IItemTextService;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ItemText;

public class ItemTextService extends AbstractEntityService<ItemText> implements
        IItemTextService {

    public ItemTextService() {
        super();
    }

    public ItemTextService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ItemText> getEntityClass() {
        return ItemText.class;
    }

    public List<ItemText> findByItem(Item item) {
        return this.findByItemId(item.getId());
    }

    public List<ItemText> findByItemId(Long itemId) {
        return (List<ItemText>) this.em
                .createQuery(
                        "select e from ItemText e where e.item.id = :pItemId",
                        ItemText.class).setParameter("pItemId", itemId)
                .getResultList();
    }

    public List<ItemText> findByItemTextType(ItemTextType itemTextType) {
        return this.findByItemTextTypeId(itemTextType.getId());
    }

    public List<ItemText> findByItemTextTypeId(Long itemTextTypeId) {
        return (List<ItemText>) this.em
                .createQuery(
                        "select e from ItemText e where e.itemTextType.id = :pItemTextTypeId",
                        ItemText.class)
                .setParameter("pItemTextTypeId", itemTextTypeId)
                .getResultList();
    }

}
