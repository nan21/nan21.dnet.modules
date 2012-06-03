/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeCategory;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeType;

public interface IAttributeTypeService extends IEntityService<AttributeType> {

    public AttributeType findByName(String name);

    public List<AttributeType> findByCategory(AttributeCategory category);

    public List<AttributeType> findByCategoryId(Long categoryId);

}
