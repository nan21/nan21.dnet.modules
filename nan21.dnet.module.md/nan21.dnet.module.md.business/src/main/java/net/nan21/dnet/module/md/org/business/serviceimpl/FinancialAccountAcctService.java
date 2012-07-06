/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

public class FinancialAccountAcctService extends
        AbstractEntityService<FinancialAccountAcct> {

    public FinancialAccountAcctService() {
        super();
    }

    public FinancialAccountAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<FinancialAccountAcct> getEntityClass() {
        return FinancialAccountAcct.class;
    }

    public FinancialAccountAcct findByAccount_schema(
            FinancialAccount financialAccount, AccSchema accSchema) {
        return (FinancialAccountAcct) this.em
                .createNamedQuery(
                        FinancialAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFinancialAccount", financialAccount)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public FinancialAccountAcct findByAccount_schema(Long financialAccountId,
            Long accSchemaId) {
        return (FinancialAccountAcct) this.em
                .createNamedQuery(
                        FinancialAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFinancialAccountId", financialAccountId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<FinancialAccountAcct> findByFinancialAccount(
            FinancialAccount financialAccount) {
        return this.findByFinancialAccountId(financialAccount.getId());
    }

    public List<FinancialAccountAcct> findByFinancialAccountId(
            Long financialAccountId) {
        return (List<FinancialAccountAcct>) this.em
                .createQuery(
                        "select e from FinancialAccountAcct e where e.clientId = :pClientId and e.financialAccount.id = :pFinancialAccountId",
                        FinancialAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFinancialAccountId", financialAccountId)
                .getResultList();
    }

    public List<FinancialAccountAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<FinancialAccountAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<FinancialAccountAcct>) this.em
                .createQuery(
                        "select e from FinancialAccountAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        FinancialAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<FinancialAccountAcct> findByDepositAccount(
            Account depositAccount) {
        return this.findByDepositAccountId(depositAccount.getId());
    }

    public List<FinancialAccountAcct> findByDepositAccountId(
            Long depositAccountId) {
        return (List<FinancialAccountAcct>) this.em
                .createQuery(
                        "select e from FinancialAccountAcct e where e.clientId = :pClientId and e.depositAccount.id = :pDepositAccountId",
                        FinancialAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDepositAccountId", depositAccountId)
                .getResultList();
    }

    public List<FinancialAccountAcct> findByWithdrawalAccount(
            Account withdrawalAccount) {
        return this.findByWithdrawalAccountId(withdrawalAccount.getId());
    }

    public List<FinancialAccountAcct> findByWithdrawalAccountId(
            Long withdrawalAccountId) {
        return (List<FinancialAccountAcct>) this.em
                .createQuery(
                        "select e from FinancialAccountAcct e where e.clientId = :pClientId and e.withdrawalAccount.id = :pWithdrawalAccountId",
                        FinancialAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pWithdrawalAccountId", withdrawalAccountId)
                .getResultList();
    }

}
