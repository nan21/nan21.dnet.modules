/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupAcctService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

public class ProductAccountGroupAcctService extends
        AbstractEntityService<ProductAccountGroupAcct> implements
        IProductAccountGroupAcctService {

    public ProductAccountGroupAcctService() {
        super();
    }

    public ProductAccountGroupAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAccountGroupAcct> getEntityClass() {
        return ProductAccountGroupAcct.class;
    }

    public ProductAccountGroupAcct findByGroup_schema(
            ProductAccountGroup group, AccSchema accSchema) {
        return (ProductAccountGroupAcct) this.em
                .createNamedQuery(
                        ProductAccountGroupAcct.NQ_FIND_BY_GROUP_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroup", group)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public ProductAccountGroupAcct findByGroup_schema(Long groupId,
            Long accSchemaId) {
        return (ProductAccountGroupAcct) this.em
                .createNamedQuery(
                        ProductAccountGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<ProductAccountGroupAcct> findByGroup(ProductAccountGroup group) {
        return this.findByGroupId(group.getId());
    }

    public List<ProductAccountGroupAcct> findByGroupId(Long groupId) {
        return (List<ProductAccountGroupAcct>) this.em
                .createQuery(
                        "select e from ProductAccountGroupAcct e where e.clientId = :pClientId and e.group.id = :pGroupId",
                        ProductAccountGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId).getResultList();
    }

    public List<ProductAccountGroupAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<ProductAccountGroupAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<ProductAccountGroupAcct>) this.em
                .createQuery(
                        "select e from ProductAccountGroupAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        ProductAccountGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<ProductAccountGroupAcct> findByExpenseAccount(
            Account expenseAccount) {
        return this.findByExpenseAccountId(expenseAccount.getId());
    }

    public List<ProductAccountGroupAcct> findByExpenseAccountId(
            Long expenseAccountId) {
        return (List<ProductAccountGroupAcct>) this.em
                .createQuery(
                        "select e from ProductAccountGroupAcct e where e.clientId = :pClientId and e.expenseAccount.id = :pExpenseAccountId",
                        ProductAccountGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pExpenseAccountId", expenseAccountId)
                .getResultList();
    }

    public List<ProductAccountGroupAcct> findByRevenueAccount(
            Account revenueAccount) {
        return this.findByRevenueAccountId(revenueAccount.getId());
    }

    public List<ProductAccountGroupAcct> findByRevenueAccountId(
            Long revenueAccountId) {
        return (List<ProductAccountGroupAcct>) this.em
                .createQuery(
                        "select e from ProductAccountGroupAcct e where e.clientId = :pClientId and e.revenueAccount.id = :pRevenueAccountId",
                        ProductAccountGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRevenueAccountId", revenueAccountId)
                .getResultList();
    }

}
