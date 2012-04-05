/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

import net.nan21.dnet.module.hr.payroll.domain.entity.Variable;

public interface IVariableService extends IEntityService<Variable> {

    public Variable findByCode(Element element, String code);

    public Variable findByCode(Long elementId, String code);

    public Variable findByName(Element element, String name);

    public Variable findByName(Long elementId, String name);

    public List<Variable> findByElement(Element element);

    public List<Variable> findByElementId(Long elementId);

    public List<Variable> findByCrossReference(Element crossReference);

    public List<Variable> findByCrossReferenceId(Long crossReferenceId);

}
