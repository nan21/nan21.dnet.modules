/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;

public interface IElementSetService extends IEntityService<ElementSet> {

    public ElementSet findByEngine_name(Engine engine, String name);

    public ElementSet findByEngine_name(Long engineId, String name);

    public List<ElementSet> findByEngine(Engine engine);

    public List<ElementSet> findByEngineId(Long engineId);

}
