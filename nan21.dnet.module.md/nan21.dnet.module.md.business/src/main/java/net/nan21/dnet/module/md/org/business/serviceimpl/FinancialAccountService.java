/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

public class FinancialAccountService extends
        AbstractEntityService<FinancialAccount> implements
        IFinancialAccountService {

    public FinancialAccountService() {
        super();
    }

    public FinancialAccountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<FinancialAccount> getEntityClass() {
        return FinancialAccount.class;
    }

    public FinancialAccount findByName(String name) {
        return (FinancialAccount) this.em
                .createNamedQuery(FinancialAccount.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<FinancialAccount> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<FinancialAccount> findByOrgId(Long orgId) {
        return (List<FinancialAccount>) this.em
                .createQuery(
                        "select e from FinancialAccount e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        FinancialAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<FinancialAccount> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<FinancialAccount> findByCurrencyId(Long currencyId) {
        return (List<FinancialAccount>) this.em
                .createQuery(
                        "select e from FinancialAccount e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        FinancialAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<FinancialAccount> findByJournal(AccJournal journal) {
        return this.findByJournalId(journal.getId());
    }

    public List<FinancialAccount> findByJournalId(Long journalId) {
        return (List<FinancialAccount>) this.em
                .createQuery(
                        "select e from FinancialAccount e where e.clientId = :pClientId and e.journal.id = :pJournalId",
                        FinancialAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJournalId", journalId).getResultList();
    }

}
