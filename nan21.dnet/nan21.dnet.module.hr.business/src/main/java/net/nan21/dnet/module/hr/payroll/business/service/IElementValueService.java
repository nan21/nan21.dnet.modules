/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementValue;

public interface IElementValueService extends IEntityService<ElementValue> {

    public List<ElementValue> findByElement(Element element);

    public List<ElementValue> findByElementId(Long elementId);

    public List<ElementValue> findByEmployee(Employee employee);

    public List<ElementValue> findByEmployeeId(Long employeeId);

    public List<ElementValue> findByPeriod(PayrollPeriod period);

    public List<ElementValue> findByPeriodId(Long periodId);

}
