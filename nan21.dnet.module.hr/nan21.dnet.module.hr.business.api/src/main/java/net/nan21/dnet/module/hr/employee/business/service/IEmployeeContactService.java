/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

public interface IEmployeeContactService extends
        IEntityService<EmployeeContact> {

    public List<EmployeeContact> findByEmployee(Employee employee);

    public List<EmployeeContact> findByEmployeeId(Long employeeId);

    public List<EmployeeContact> findByType(EmployeeContactType type);

    public List<EmployeeContact> findByTypeId(Long typeId);

    public List<EmployeeContact> findByRelationship(
            EmployeeContactRelationship relationship);

    public List<EmployeeContact> findByRelationshipId(Long relationshipId);

}
