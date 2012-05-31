/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;

public interface IAttributeGroupService extends IEntityService<AttributeGroup> {

    public AttributeGroup findByName(String name);

}
