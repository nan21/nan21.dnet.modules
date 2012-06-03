/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public interface IPayrollPeriodService extends IEntityService<PayrollPeriod> {

    public PayrollPeriod findByName(String name);

    public List<PayrollPeriod> findByPayroll(Payroll payroll);

    public List<PayrollPeriod> findByPayrollId(Long payrollId);

    public void doProcess(PayrollPeriod period) throws Exception;

    public void doOpen(PayrollPeriod period) throws Exception;

    public void doClose(PayrollPeriod period) throws Exception;

    public void doClear(PayrollPeriod period) throws Exception;

}
