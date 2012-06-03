/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;

import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;

public interface IAttributeGroupAttributeService extends
        IEntityService<AttributeGroupAttribute> {

    public AttributeGroupAttribute findByName(AttributeGroup group,
            Attribute attribute);

    public AttributeGroupAttribute findByName(Long groupId, Long attributeId);

    public List<AttributeGroupAttribute> findByGroup(AttributeGroup group);

    public List<AttributeGroupAttribute> findByGroupId(Long groupId);

    public List<AttributeGroupAttribute> findByAttribute(Attribute attribute);

    public List<AttributeGroupAttribute> findByAttributeId(Long attributeId);

}
