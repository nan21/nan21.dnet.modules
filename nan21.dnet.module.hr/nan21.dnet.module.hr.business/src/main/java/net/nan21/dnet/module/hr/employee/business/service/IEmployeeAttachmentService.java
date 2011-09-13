/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmplAttachmentType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAttachment;

public interface IEmployeeAttachmentService extends
        IEntityService<EmployeeAttachment> {

    public List<EmployeeAttachment> findByEmployee(Employee employee);

    public List<EmployeeAttachment> findByEmployeeId(Long employeeId);

    public List<EmployeeAttachment> findByType(EmplAttachmentType type);

    public List<EmployeeAttachment> findByTypeId(Long typeId);

}
