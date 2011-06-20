/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

public interface IEmployeeEducationService extends
        IEntityService<EmployeeEducation> {

    public List<EmployeeEducation> findByEmployee(Employee employee);

    public List<EmployeeEducation> findByEmployeeId(Long employeeId);

    public List<EmployeeEducation> findByType(EducationType type);

    public List<EmployeeEducation> findByTypeId(Long typeId);

}
