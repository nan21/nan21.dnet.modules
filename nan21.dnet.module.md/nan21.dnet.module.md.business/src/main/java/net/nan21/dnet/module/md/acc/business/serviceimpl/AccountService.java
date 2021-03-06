/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

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

}
