/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;

public interface IPayrollElementValueService extends
        IEntityService<PayrollElementValue> {

    public List<PayrollElementValue> findByElement(PayrollElement element);

    public List<PayrollElementValue> findByElementId(Long elementId);

    public List<PayrollElementValue> findByPeriod(PayrollPeriod period);

    public List<PayrollElementValue> findByPeriodId(Long periodId);

    public List<PayrollElementValue> findByAssignment(
            EmployeeAssignment assignment);

    public List<PayrollElementValue> findByAssignmentId(Long assignmentId);

    public List<PayrollElementValue> findByOrg(Organization org);

    public List<PayrollElementValue> findByOrgId(Long orgId);

}
