/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollPeriodService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;
import net.nan21.dnet.module.hr._businessdelegates.payroll.PayrollPeriodProcessorBD;

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

    public PayrollPeriod findByName(String name) {
        return (PayrollPeriod) this.em
                .createNamedQuery(PayrollPeriod.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<PayrollPeriod> findByPayroll(Payroll payroll) {
        return this.findByPayrollId(payroll.getId());
    }

    public List<PayrollPeriod> findByPayrollId(Long payrollId) {
        return (List<PayrollPeriod>) this.em
                .createQuery(
                        "select e from PayrollPeriod e where e.clientId = :pClientId and e.payroll.id = :pPayrollId",
                        PayrollPeriod.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayrollId", payrollId).getResultList();
    }

    public void doProcess(PayrollPeriod period) throws Exception {
        this.getBusinessDelegate(PayrollPeriodProcessorBD.class)
                .process(period);
    }

    public void doOpen(PayrollPeriod period) throws Exception {
        this.getBusinessDelegate(PayrollPeriodProcessorBD.class).open(period);
    }

    public void doClose(PayrollPeriod period) throws Exception {
        this.getBusinessDelegate(PayrollPeriodProcessorBD.class).close(period);
    }

    public void doClear(PayrollPeriod period) throws Exception {
        this.getBusinessDelegate(PayrollPeriodProcessorBD.class).clear(period);
    }

}
