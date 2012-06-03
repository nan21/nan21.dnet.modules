/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
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

    public List<Payroll> findByEngine(Engine engine) {
        return this.findByEngineId(engine.getId());
    }

    public List<Payroll> findByEngineId(Long engineId) {
        return (List<Payroll>) this.em
                .createQuery(
                        "select e from Payroll e where e.clientId = :pClientId and e.engine.id = :pEngineId",
                        Payroll.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngineId", engineId).getResultList();
    }

}
