/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bp.base.domain.entity.Bank;
import net.nan21.dnet.module.bp.md.business.service.IBpBankAccountService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.BpBankAccount;

public class BpBankAccountService extends AbstractEntityService<BpBankAccount>
        implements IBpBankAccountService {

    public BpBankAccountService() {
        super();
    }

    public BpBankAccountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BpBankAccount> getEntityClass() {
        return BpBankAccount.class;
    }

    public BpBankAccount findByAccount(Long clientId, BusinessPartner bpartner,
            String accountNo) {
        return (BpBankAccount) this.em
                .createNamedQuery(BpBankAccount.NQ_FIND_BY_ACCOUNT)
                .setParameter("pClientId", clientId)
                .setParameter("pBpartner", bpartner)
                .setParameter("pAccountNo", accountNo).getSingleResult();
    }

    public BpBankAccount findByAccount(Long clientId, Long bpartnerId,
            String accountNo) {
        return (BpBankAccount) this.em
                .createNamedQuery(BpBankAccount.NQ_FIND_BY_ACCOUNT_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pBpartnerId", bpartnerId)
                .setParameter("pAccountNo", accountNo).getSingleResult();
    }

    public List<BpBankAccount> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<BpBankAccount> findByBpartnerId(Long bpartnerId) {
        return (List<BpBankAccount>) this.em
                .createQuery(
                        "select e from BpBankAccount where e.bpartner.id = :pBpartnerId",
                        BpBankAccount.class)
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<BpBankAccount> findByBank(Bank bank) {
        return this.findByBankId(bank.getId());
    }

    public List<BpBankAccount> findByBankId(Long bankId) {
        return (List<BpBankAccount>) this.em
                .createQuery(
                        "select e from BpBankAccount where e.bank.id = :pBankId",
                        BpBankAccount.class).setParameter("pBankId", bankId)
                .getResultList();
    }

    public List<BpBankAccount> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<BpBankAccount> findByCurrencyId(Long currencyId) {
        return (List<BpBankAccount>) this.em
                .createQuery(
                        "select e from BpBankAccount where e.currency.id = :pCurrencyId",
                        BpBankAccount.class)
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
