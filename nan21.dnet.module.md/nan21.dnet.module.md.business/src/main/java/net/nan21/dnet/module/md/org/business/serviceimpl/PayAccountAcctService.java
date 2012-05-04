/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.business.service.IPayAccountAcctService;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.PayAccountAcct;

public class PayAccountAcctService extends
        AbstractEntityService<PayAccountAcct> implements IPayAccountAcctService {

    public PayAccountAcctService() {
        super();
    }

    public PayAccountAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayAccountAcct> getEntityClass() {
        return PayAccountAcct.class;
    }

    public PayAccountAcct findByAccount_schema(PayAccount payAccount,
            AccSchema accSchema) {
        return (PayAccountAcct) this.em
                .createNamedQuery(PayAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayAccount", payAccount)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public PayAccountAcct findByAccount_schema(Long payAccountId,
            Long accSchemaId) {
        return (PayAccountAcct) this.em
                .createNamedQuery(
                        PayAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayAccountId", payAccountId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<PayAccountAcct> findByPayAccount(PayAccount payAccount) {
        return this.findByPayAccountId(payAccount.getId());
    }

    public List<PayAccountAcct> findByPayAccountId(Long payAccountId) {
        return (List<PayAccountAcct>) this.em
                .createQuery(
                        "select e from PayAccountAcct e where e.clientId = :pClientId and e.payAccount.id = :pPayAccountId",
                        PayAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayAccountId", payAccountId).getResultList();
    }

    public List<PayAccountAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<PayAccountAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<PayAccountAcct>) this.em
                .createQuery(
                        "select e from PayAccountAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        PayAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<PayAccountAcct> findByDepositAccount(Account depositAccount) {
        return this.findByDepositAccountId(depositAccount.getId());
    }

    public List<PayAccountAcct> findByDepositAccountId(Long depositAccountId) {
        return (List<PayAccountAcct>) this.em
                .createQuery(
                        "select e from PayAccountAcct e where e.clientId = :pClientId and e.depositAccount.id = :pDepositAccountId",
                        PayAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDepositAccountId", depositAccountId)
                .getResultList();
    }

    public List<PayAccountAcct> findByWithdrawalAccount(
            Account withdrawalAccount) {
        return this.findByWithdrawalAccountId(withdrawalAccount.getId());
    }

    public List<PayAccountAcct> findByWithdrawalAccountId(
            Long withdrawalAccountId) {
        return (List<PayAccountAcct>) this.em
                .createQuery(
                        "select e from PayAccountAcct e where e.clientId = :pClientId and e.withdrawalAccount.id = :pWithdrawalAccountId",
                        PayAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pWithdrawalAccountId", withdrawalAccountId)
                .getResultList();
    }

}
