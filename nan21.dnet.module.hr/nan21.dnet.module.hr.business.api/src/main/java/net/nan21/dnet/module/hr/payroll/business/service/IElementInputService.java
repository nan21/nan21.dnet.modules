/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementInput;

public interface IElementInputService extends IEntityService<ElementInput> {

    public List<ElementInput> findByElement(Element element);

    public List<ElementInput> findByElementId(Long elementId);

    public List<ElementInput> findByCrossReference(Element crossReference);

    public List<ElementInput> findByCrossReferenceId(Long crossReferenceId);

}
