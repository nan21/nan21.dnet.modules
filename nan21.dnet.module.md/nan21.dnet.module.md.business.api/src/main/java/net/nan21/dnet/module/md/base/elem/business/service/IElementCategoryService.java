/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.elem.domain.entity.Engine;

import net.nan21.dnet.module.md.base.elem.domain.entity.ElementCategory;

public interface IElementCategoryService extends
        IEntityService<ElementCategory> {

    public ElementCategory findByName(String name);

    public List<ElementCategory> findByEngine(Engine engine);

    public List<ElementCategory> findByEngineId(Long engineId);

}
