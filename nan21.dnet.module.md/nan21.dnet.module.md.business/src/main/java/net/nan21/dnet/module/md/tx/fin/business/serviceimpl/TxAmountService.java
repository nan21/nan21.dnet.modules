/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.fin.business.service.ITxAmountService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxAmount;

public class TxAmountService extends AbstractEntityService<TxAmount> implements
        ITxAmountService {

    public TxAmountService() {
        super();
    }

    public TxAmountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<TxAmount> getEntityClass() {
        return TxAmount.class;
    }

    public List<TxAmount> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<TxAmount> findByBpartnerId(Long bpartnerId) {
        return (List<TxAmount>) this.em
                .createQuery(
                        "select e from TxAmount e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        TxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<TxAmount> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<TxAmount> findByOrgId(Long orgId) {
        return (List<TxAmount>) this.em
                .createQuery(
                        "select e from TxAmount e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        TxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<TxAmount> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<TxAmount> findByPaymentMethodId(Long paymentMethodId) {
        return (List<TxAmount>) this.em
                .createQuery(
                        "select e from TxAmount e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        TxAmount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

}
