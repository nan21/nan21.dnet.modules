/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public interface IPayrollPeriodService extends IEntityService<PayrollPeriod> {

    public PayrollPeriod findByName(Long clientId, String name);

    public List<PayrollPeriod> findByPayroll(Payroll payroll);

    public List<PayrollPeriod> findByPayrollId(Long payrollId);

}
