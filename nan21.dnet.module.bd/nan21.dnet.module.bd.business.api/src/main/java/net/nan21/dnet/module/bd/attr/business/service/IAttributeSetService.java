/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;

public interface IAttributeSetService extends IEntityService<AttributeSet> {

    public AttributeSet findByName(String name);

}
