/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementFormula;

public interface IElementFormulaService extends IEntityService<ElementFormula> {

    public List<ElementFormula> findByElement(Element element);

    public List<ElementFormula> findByElementId(Long elementId);

}
