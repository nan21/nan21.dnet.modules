/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

public class CustomerGroupService extends AbstractEntityService<CustomerGroup>
        implements ICustomerGroupService {

    public CustomerGroupService() {
        super();
    }

    public CustomerGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CustomerGroup> getEntityClass() {
        return CustomerGroup.class;
    }

    public CustomerGroup findByCode(String code) {
        return (CustomerGroup) this.em
                .createNamedQuery(CustomerGroup.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public CustomerGroup findByName(String name) {
        return (CustomerGroup) this.em
                .createNamedQuery(CustomerGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<CustomerGroup> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<CustomerGroup> findByPaymentMethodId(Long paymentMethodId) {
        return (List<CustomerGroup>) this.em
                .createQuery(
                        "select e from CustomerGroup e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        CustomerGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

    public List<CustomerGroup> findByPaymentTerm(PaymentTerm paymentTerm) {
        return this.findByPaymentTermId(paymentTerm.getId());
    }

    public List<CustomerGroup> findByPaymentTermId(Long paymentTermId) {
        return (List<CustomerGroup>) this.em
                .createQuery(
                        "select e from CustomerGroup e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
                        CustomerGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentTermId", paymentTermId).getResultList();
    }

}
