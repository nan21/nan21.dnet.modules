/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

import net.nan21.dnet.module.pj.base.domain.entity.ItemType;

public interface IItemTypeService extends IEntityService<ItemType> {

    public ItemType findByName(Long clientId, String name);

    public List<ItemType> findByCategory(ItemCategory category);

    public List<ItemType> findByCategoryId(Long categoryId);

    public List<ItemType> findByProjectTypes(ProjectType projectTypes);

    public List<ItemType> findByProjectTypesId(Long projectTypesId);

}
