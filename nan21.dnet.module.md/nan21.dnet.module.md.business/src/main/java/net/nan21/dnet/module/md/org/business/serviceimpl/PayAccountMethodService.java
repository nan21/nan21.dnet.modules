/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.business.service.IPayAccountMethodService;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.PayAccountMethod;

public class PayAccountMethodService extends
        AbstractEntityService<PayAccountMethod> implements
        IPayAccountMethodService {

    public PayAccountMethodService() {
        super();
    }

    public PayAccountMethodService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayAccountMethod> getEntityClass() {
        return PayAccountMethod.class;
    }

    public PayAccountMethod findByAccount_mtd(PayAccount payAccount,
            PaymentMethod payMethod) {
        return (PayAccountMethod) this.em
                .createNamedQuery(PayAccountMethod.NQ_FIND_BY_ACCOUNT_MTD)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayAccount", payAccount)
                .setParameter("pPayMethod", payMethod).getSingleResult();
    }

    public PayAccountMethod findByAccount_mtd(Long payAccountId,
            Long payMethodId) {
        return (PayAccountMethod) this.em
                .createNamedQuery(
                        PayAccountMethod.NQ_FIND_BY_ACCOUNT_MTD_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayAccountId", payAccountId)
                .setParameter("pPayMethodId", payMethodId).getSingleResult();
    }

    public List<PayAccountMethod> findByPayAccount(PayAccount payAccount) {
        return this.findByPayAccountId(payAccount.getId());
    }

    public List<PayAccountMethod> findByPayAccountId(Long payAccountId) {
        return (List<PayAccountMethod>) this.em
                .createQuery(
                        "select e from PayAccountMethod e where e.clientId = :pClientId and e.payAccount.id = :pPayAccountId",
                        PayAccountMethod.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayAccountId", payAccountId).getResultList();
    }

    public List<PayAccountMethod> findByPayMethod(PaymentMethod payMethod) {
        return this.findByPayMethodId(payMethod.getId());
    }

    public List<PayAccountMethod> findByPayMethodId(Long payMethodId) {
        return (List<PayAccountMethod>) this.em
                .createQuery(
                        "select e from PayAccountMethod e where e.clientId = :pClientId and e.payMethod.id = :pPayMethodId",
                        PayAccountMethod.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayMethodId", payMethodId).getResultList();
    }

}
