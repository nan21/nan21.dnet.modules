/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.tx.fin.business.service.IPaymentService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

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

    public List<Payment> findByFromOrg(Organization fromOrg) {
        return this.findByFromOrgId(fromOrg.getId());
    }

    public List<Payment> findByFromOrgId(Long fromOrgId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.fromOrg.id = :pFromOrgId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFromOrgId", fromOrgId).getResultList();
    }

    public List<Payment> findByToOrg(Organization toOrg) {
        return this.findByToOrgId(toOrg.getId());
    }

    public List<Payment> findByToOrgId(Long toOrgId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.toOrg.id = :pToOrgId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pToOrgId", toOrgId).getResultList();
    }

    public List<Payment> findByFromAccount(FinancialAccount fromAccount) {
        return this.findByFromAccountId(fromAccount.getId());
    }

    public List<Payment> findByFromAccountId(Long fromAccountId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.fromAccount.id = :pFromAccountId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFromAccountId", fromAccountId).getResultList();
    }

    public List<Payment> findByToAccount(FinancialAccount toAccount) {
        return this.findByToAccountId(toAccount.getId());
    }

    public List<Payment> findByToAccountId(Long toAccountId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select e from Payment e where e.clientId = :pClientId and e.toAccount.id = :pToAccountId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pToAccountId", toAccountId).getResultList();
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

    public List<Payment> findByLines(PaymentItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<Payment> findByLinesId(Long linesId) {
        return (List<Payment>) this.em
                .createQuery(
                        "select distinct e from Payment e , IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
                        Payment.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinesId", linesId).getResultList();
    }

}
