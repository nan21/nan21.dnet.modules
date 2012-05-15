/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItem;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItemAcct;

public class AccItemAcctService extends AbstractEntityService<AccItemAcct> {

    public AccItemAcctService() {
        super();
    }

    public AccItemAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccItemAcct> getEntityClass() {
        return AccItemAcct.class;
    }

    public AccItemAcct findByItem_schema(AccItem accItem, AccSchema accSchema) {
        return (AccItemAcct) this.em
                .createNamedQuery(AccItemAcct.NQ_FIND_BY_ITEM_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccItem", accItem)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public AccItemAcct findByItem_schema(Long accItemId, Long accSchemaId) {
        return (AccItemAcct) this.em
                .createNamedQuery(AccItemAcct.NQ_FIND_BY_ITEM_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccItemId", accItemId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<AccItemAcct> findByAccItem(AccItem accItem) {
        return this.findByAccItemId(accItem.getId());
    }

    public List<AccItemAcct> findByAccItemId(Long accItemId) {
        return (List<AccItemAcct>) this.em
                .createQuery(
                        "select e from AccItemAcct e where e.clientId = :pClientId and e.accItem.id = :pAccItemId",
                        AccItemAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccItemId", accItemId).getResultList();
    }

    public List<AccItemAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<AccItemAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<AccItemAcct>) this.em
                .createQuery(
                        "select e from AccItemAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        AccItemAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<AccItemAcct> findByCrAccount(Account crAccount) {
        return this.findByCrAccountId(crAccount.getId());
    }

    public List<AccItemAcct> findByCrAccountId(Long crAccountId) {
        return (List<AccItemAcct>) this.em
                .createQuery(
                        "select e from AccItemAcct e where e.clientId = :pClientId and e.crAccount.id = :pCrAccountId",
                        AccItemAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCrAccountId", crAccountId).getResultList();
    }

    public List<AccItemAcct> findByDbAccount(Account dbAccount) {
        return this.findByDbAccountId(dbAccount.getId());
    }

    public List<AccItemAcct> findByDbAccountId(Long dbAccountId) {
        return (List<AccItemAcct>) this.em
                .createQuery(
                        "select e from AccItemAcct e where e.clientId = :pClientId and e.dbAccount.id = :pDbAccountId",
                        AccItemAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDbAccountId", dbAccountId).getResultList();
    }

}
