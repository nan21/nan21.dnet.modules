/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public interface IEmployeeService extends IEntityService<Employee> {

    public Employee findByCode(Long clientId, String code);

    public List<Employee> findByEmployer(Organization employer);

    public List<Employee> findByEmployerId(Long employerId);

    public List<Employee> findByCitizenship(Country citizenship);

    public List<Employee> findByCitizenshipId(Long citizenshipId);

}
