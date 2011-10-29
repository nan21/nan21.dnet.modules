/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

import net.nan21.dnet.module.pj.md.domain.entity.ItemLink;

public interface IItemLinkService extends IEntityService<ItemLink> {

    public List<ItemLink> findBySourceItem(Item sourceItem);

    public List<ItemLink> findBySourceItemId(Long sourceItemId);

    public List<ItemLink> findByTargetItem(Item targetItem);

    public List<ItemLink> findByTargetItemId(Long targetItemId);

    public List<ItemLink> findByLinkType(ItemLinkType linkType);

    public List<ItemLink> findByLinkTypeId(Long linkTypeId);

}
