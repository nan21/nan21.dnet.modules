/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import net.nan21.dnet.module.hr.time.domain.entity.Absence;

public interface IAbsenceService extends IEntityService<Absence> {

    public List<Absence> findByEmployee(Employee employee);

    public List<Absence> findByEmployeeId(Long employeeId);

    public List<Absence> findByType(AbsenceType type);

    public List<Absence> findByTypeId(Long typeId);

    public List<Absence> findByReason(AbsenceReason reason);

    public List<Absence> findByReasonId(Long reasonId);

}
