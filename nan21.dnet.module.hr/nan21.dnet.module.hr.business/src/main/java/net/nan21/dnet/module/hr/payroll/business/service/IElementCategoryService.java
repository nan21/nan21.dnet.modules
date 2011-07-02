/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;

public interface IElementCategoryService extends
        IEntityService<ElementCategory> {

    public ElementCategory findByName(Long clientId, String name);

}
