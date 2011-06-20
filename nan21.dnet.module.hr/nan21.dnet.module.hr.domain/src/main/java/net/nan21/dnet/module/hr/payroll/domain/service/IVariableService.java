/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

import net.nan21.dnet.module.hr.payroll.domain.entity.Variable;

public interface IVariableService extends IEntityService<Variable> {

    public Variable findByCode(Long clientId, Element element, String code);

    public Variable findByCode(Long clientId, Long elementId, String code);

    public Variable findByName(Long clientId, Element element, String name);

    public Variable findByName(Long clientId, Long elementId, String name);

    public List<Variable> findByElement(Element element);

    public List<Variable> findByElementId(Long elementId);

    public List<Variable> findByCrossReference(Element crossReference);

    public List<Variable> findByCrossReferenceId(Long crossReferenceId);

}
