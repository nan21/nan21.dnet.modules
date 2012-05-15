/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

public interface IEmployeeContactRelationshipService extends
        IEntityService<EmployeeContactRelationship> {

    public EmployeeContactRelationship findByName(String name);

}
