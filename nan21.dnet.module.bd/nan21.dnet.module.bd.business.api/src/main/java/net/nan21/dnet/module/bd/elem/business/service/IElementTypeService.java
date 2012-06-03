/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;

public interface IElementTypeService extends IEntityService<ElementType> {

    public ElementType findByEngine_name(Engine engine, String name);

    public ElementType findByEngine_name(Long engineId, String name);

    public List<ElementType> findByEngine(Engine engine);

    public List<ElementType> findByEngineId(Long engineId);

    public List<ElementType> findByCategory(ElementCategory category);

    public List<ElementType> findByCategoryId(Long categoryId);

}
