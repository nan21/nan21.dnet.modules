/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceBalance;

public interface IAbsenceBalanceService extends IEntityService<AbsenceBalance> {

    public List<AbsenceBalance> findByEmployee(Employee employee);

    public List<AbsenceBalance> findByEmployeeId(Long employeeId);

}
