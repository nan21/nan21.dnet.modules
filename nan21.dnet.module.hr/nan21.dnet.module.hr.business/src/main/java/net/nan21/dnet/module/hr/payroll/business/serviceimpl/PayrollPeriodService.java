/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollPeriodService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public class PayrollPeriodService extends AbstractEntityService<PayrollPeriod>
        implements IPayrollPeriodService {

    public PayrollPeriodService() {
        super();
    }

    public PayrollPeriodService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayrollPeriod> getEntityClass() {
        return PayrollPeriod.class;
    }

    public PayrollPeriod findByName(Long clientId, String name) {
        return (PayrollPeriod) this.em
                .createNamedQuery(PayrollPeriod.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<PayrollPeriod> findByPayroll(Payroll payroll) {
        return this.findByPayrollId(payroll.getId());
    }

    public List<PayrollPeriod> findByPayrollId(Long payrollId) {
        return (List<PayrollPeriod>) this.em
                .createQuery(
                        "select e from PayrollPeriod where e.payroll.id = :pPayrollId",
                        PayrollPeriod.class)
                .setParameter("pPayrollId", payrollId).getResultList();
    }

}
