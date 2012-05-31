/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollElementValueService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;

public class PayrollElementValueService extends
        AbstractEntityService<PayrollElementValue> implements
        IPayrollElementValueService {

    public PayrollElementValueService() {
        super();
    }

    public PayrollElementValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayrollElementValue> getEntityClass() {
        return PayrollElementValue.class;
    }

    public List<PayrollElementValue> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<PayrollElementValue> findByEmployeeId(Long employeeId) {
        return (List<PayrollElementValue>) this.em
                .createQuery(
                        "select e from PayrollElementValue e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
                        PayrollElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<PayrollElementValue> findByPeriod(PayrollPeriod period) {
        return this.findByPeriodId(period.getId());
    }

    public List<PayrollElementValue> findByPeriodId(Long periodId) {
        return (List<PayrollElementValue>) this.em
                .createQuery(
                        "select e from PayrollElementValue e where e.clientId = :pClientId and e.period.id = :pPeriodId",
                        PayrollElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPeriodId", periodId).getResultList();
    }

}
