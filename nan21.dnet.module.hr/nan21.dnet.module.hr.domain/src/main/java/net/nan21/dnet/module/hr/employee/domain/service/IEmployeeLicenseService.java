/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;

public interface IEmployeeLicenseService extends
        IEntityService<EmployeeLicense> {

    public List<EmployeeLicense> findByEmployee(Employee employee);

    public List<EmployeeLicense> findByEmployeeId(Long employeeId);

    public List<EmployeeLicense> findByLicenseType(LicenseType licenseType);

    public List<EmployeeLicense> findByLicenseTypeId(Long licenseTypeId);

}
