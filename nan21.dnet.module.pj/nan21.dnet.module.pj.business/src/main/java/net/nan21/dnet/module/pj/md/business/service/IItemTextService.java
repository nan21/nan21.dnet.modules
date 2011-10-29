/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

import net.nan21.dnet.module.pj.md.domain.entity.ItemText;

public interface IItemTextService extends IEntityService<ItemText> {

    public List<ItemText> findByItem(Item item);

    public List<ItemText> findByItemId(Long itemId);

    public List<ItemText> findByItemTextType(ItemTextType itemTextType);

    public List<ItemText> findByItemTextTypeId(Long itemTextTypeId);

}
