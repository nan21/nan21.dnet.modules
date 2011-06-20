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
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequestItem;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;

public interface IAbsenceRequestService extends IEntityService<AbsenceRequest> {

    public List<AbsenceRequest> findByEmployee(Employee employee);

    public List<AbsenceRequest> findByEmployeeId(Long employeeId);

    public List<AbsenceRequest> findByType(AbsenceType type);

    public List<AbsenceRequest> findByTypeId(Long typeId);

    public List<AbsenceRequest> findByReason(AbsenceReason reason);

    public List<AbsenceRequest> findByReasonId(Long reasonId);

    public List<AbsenceRequest> findByItems(AbsenceRequestItem items);

    public List<AbsenceRequest> findByItemsId(Long itemsId);

}
