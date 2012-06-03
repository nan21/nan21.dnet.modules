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
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollElementService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;

public class PayrollElementService extends
        AbstractEntityService<PayrollElement> implements IPayrollElementService {

    public PayrollElementService() {
        super();
    }

    public PayrollElementService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayrollElement> getEntityClass() {
        return PayrollElement.class;
    }

    public PayrollElement findByEngine_code(Engine engine, String code) {
        return (PayrollElement) this.em
                .createNamedQuery(PayrollElement.NQ_FIND_BY_ENGINE_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngine", engine).setParameter("pCode", code)
                .getSingleResult();
    }

    public PayrollElement findByEngine_code(Long engineId, String code) {
        return (PayrollElement) this.em
                .createNamedQuery(
                        PayrollElement.NQ_FIND_BY_ENGINE_CODE_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEngineId", engineId)
                .setParameter("pCode", code).getSingleResult();
    }

    public List<PayrollElement> findByAccItem(AccItem accItem) {
        return this.findByAccItemId(accItem.getId());
    }

    public List<PayrollElement> findByAccItemId(Long accItemId) {
        return (List<PayrollElement>) this.em
                .createQuery(
                        "select e from PayrollElement e where e.clientId = :pClientId and e.accItem.id = :pAccItemId",
                        PayrollElement.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccItemId", accItemId).getResultList();
    }

    public List<PayrollElement> findBySourceElement(PayrollElement sourceElement) {
        return this.findBySourceElementId(sourceElement.getId());
    }

    public List<PayrollElement> findBySourceElementId(Long sourceElementId) {
        return (List<PayrollElement>) this.em
                .createQuery(
                        "select e from PayrollElement e where e.clientId = :pClientId and e.sourceElement.id = :pSourceElementId",
                        PayrollElement.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSourceElementId", sourceElementId)
                .getResultList();
    }

}
