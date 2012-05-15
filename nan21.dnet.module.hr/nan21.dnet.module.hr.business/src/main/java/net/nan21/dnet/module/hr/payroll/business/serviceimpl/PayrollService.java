/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

public class PayrollService extends AbstractEntityService<Payroll> implements
        IPayrollService {

    public PayrollService() {
        super();
    }

    public PayrollService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Payroll> getEntityClass() {
        return Payroll.class;
    }

    public Payroll findByName(String name) {
        return (Payroll) this.em.createNamedQuery(Payroll.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
