/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

public interface IEmployeeContactTypeService extends
        IEntityService<EmployeeContactType> {

    public EmployeeContactType findByName(Long clientId, String name);

}
