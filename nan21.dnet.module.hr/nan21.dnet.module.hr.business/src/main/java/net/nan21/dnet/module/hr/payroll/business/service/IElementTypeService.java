/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

public interface IElementTypeService extends IEntityService<ElementType> {

    public ElementType findByName(String name);

    public List<ElementType> findByCategory(ElementCategory category);

    public List<ElementType> findByCategoryId(Long categoryId);

}
