/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;

import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;

public interface IAttributeSetAttributeService extends
        IEntityService<AttributeSetAttribute> {

    public AttributeSetAttribute findByName(AttributeSet attributeSet,
            Attribute attribute);

    public AttributeSetAttribute findByName(Long attributeSetId,
            Long attributeId);

    public List<AttributeSetAttribute> findByAttributeSet(
            AttributeSet attributeSet);

    public List<AttributeSetAttribute> findByAttributeSetId(Long attributeSetId);

    public List<AttributeSetAttribute> findByAttribute(Attribute attribute);

    public List<AttributeSetAttribute> findByAttributeId(Long attributeId);

}
