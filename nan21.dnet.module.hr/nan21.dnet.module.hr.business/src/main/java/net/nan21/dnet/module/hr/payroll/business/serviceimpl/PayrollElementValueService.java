/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollElementValueService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
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

    public List<PayrollElementValue> findByElement(PayrollElement element) {
        return this.findByElementId(element.getId());
    }

    public List<PayrollElementValue> findByElementId(Long elementId) {
        return (List<PayrollElementValue>) this.em
                .createQuery(
                        "select e from PayrollElementValue e where e.clientId = :pClientId and e.element.id = :pElementId",
                        PayrollElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pElementId", elementId).getResultList();
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

    public List<PayrollElementValue> findByAssignment(
            EmployeeAssignment assignment) {
        return this.findByAssignmentId(assignment.getId());
    }

    public List<PayrollElementValue> findByAssignmentId(Long assignmentId) {
        return (List<PayrollElementValue>) this.em
                .createQuery(
                        "select e from PayrollElementValue e where e.clientId = :pClientId and e.assignment.id = :pAssignmentId",
                        PayrollElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAssignmentId", assignmentId).getResultList();
    }

    public List<PayrollElementValue> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<PayrollElementValue> findByOrgId(Long orgId) {
        return (List<PayrollElementValue>) this.em
                .createQuery(
                        "select e from PayrollElementValue e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        PayrollElementValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

}
