/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementInput;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementType;
import net.nan21.dnet.module.md.base.elem.domain.entity.Engine;

import net.nan21.dnet.module.md.base.elem.domain.entity.Element;

public interface IElementService extends IEntityService<Element> {

    public Element findByCode(String code);

    public Element findByName(String name);

    public List<Element> findByEngine(Engine engine);

    public List<Element> findByEngineId(Long engineId);

    public List<Element> findByType(ElementType type);

    public List<Element> findByTypeId(Long typeId);

    public List<Element> findByVariables(ElementInput variables);

    public List<Element> findByVariablesId(Long variablesId);

    public List<Element> findByFormulas(ElementFormula formulas);

    public List<Element> findByFormulasId(Long formulasId);

}
