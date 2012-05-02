/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.fin.business.service.IPaymentService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

public class PaymentService extends AbstractEntityService<Payment> implements
        IPaymentService {

    public PaymentService() {
        super();
    }

    public PaymentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Payment> getEntityClass() {
        return Payment.class;
    }

    public List<Payment> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<Payment> findByBpartnerId(Long bpartnerId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<Payment> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<Payment> findByOrgId(Long orgId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<Payment> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<Payment> findByCurrencyId(Long currencyId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<Payment> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<Payment> findByPaymentMethodId(Long paymentMethodId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

}
