/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;

public class AccountService extends AbstractEntityService<Account> implements
        IAccountService {

    public AccountService() {
        super();
    }

    public AccountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }

    public Account findByCode(String code) {
        return (Account) this.em.createNamedQuery(Account.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Account findByName(String name) {
        return (Account) this.em.createNamedQuery(Account.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Account> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<Account> findByAccSchemaId(Long accSchemaId) {
        return (List<Account>) this.em
                .createQuery(
                        "select e from Account e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        Account.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<Account> findByAccGroup(AccountGroup accGroup) {
        return this.findByAccGroupId(accGroup.getId());
    }

    public List<Account> findByAccGroupId(Long accGroupId) {
        return (List<Account>) this.em
                .createQuery(
                        "select e from Account e where e.clientId = :pClientId and e.accGroup.id = :pAccGroupId",
                        Account.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccGroupId", accGroupId).getResultList();
    }

}
