/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;

public class BpAccountAcctService extends AbstractEntityService<BpAccountAcct>
        implements IBpAccountAcctService {

    public BpAccountAcctService() {
        super();
    }

    public BpAccountAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BpAccountAcct> getEntityClass() {
        return BpAccountAcct.class;
    }

    public BpAccountAcct findByAccount_schema(BpAccount bpAccount,
            AccSchema accSchema) {
        return (BpAccountAcct) this.em
                .createNamedQuery(BpAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpAccount", bpAccount)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public BpAccountAcct findByAccount_schema(Long bpAccountId, Long accSchemaId) {
        return (BpAccountAcct) this.em
                .createNamedQuery(
                        BpAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpAccountId", bpAccountId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<BpAccountAcct> findByBpAccount(BpAccount bpAccount) {
        return this.findByBpAccountId(bpAccount.getId());
    }

    public List<BpAccountAcct> findByBpAccountId(Long bpAccountId) {
        return (List<BpAccountAcct>) this.em
                .createQuery(
                        "select e from BpAccountAcct e where e.clientId = :pClientId and e.bpAccount.id = :pBpAccountId",
                        BpAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpAccountId", bpAccountId).getResultList();
    }

    public List<BpAccountAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<BpAccountAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<BpAccountAcct>) this.em
                .createQuery(
                        "select e from BpAccountAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        BpAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<BpAccountAcct> findByCustSalesAccount(Account custSalesAccount) {
        return this.findByCustSalesAccountId(custSalesAccount.getId());
    }

    public List<BpAccountAcct> findByCustSalesAccountId(Long custSalesAccountId) {
        return (List<BpAccountAcct>) this.em
                .createQuery(
                        "select e from BpAccountAcct e where e.clientId = :pClientId and e.custSalesAccount.id = :pCustSalesAccountId",
                        BpAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustSalesAccountId", custSalesAccountId)
                .getResultList();
    }

    public List<BpAccountAcct> findByCustPrepayAccount(Account custPrepayAccount) {
        return this.findByCustPrepayAccountId(custPrepayAccount.getId());
    }

    public List<BpAccountAcct> findByCustPrepayAccountId(
            Long custPrepayAccountId) {
        return (List<BpAccountAcct>) this.em
                .createQuery(
                        "select e from BpAccountAcct e where e.clientId = :pClientId and e.custPrepayAccount.id = :pCustPrepayAccountId",
                        BpAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustPrepayAccountId", custPrepayAccountId)
                .getResultList();
    }

    public List<BpAccountAcct> findByVendorPurchaseAccount(
            Account vendorPurchaseAccount) {
        return this
                .findByVendorPurchaseAccountId(vendorPurchaseAccount.getId());
    }

    public List<BpAccountAcct> findByVendorPurchaseAccountId(
            Long vendorPurchaseAccountId) {
        return (List<BpAccountAcct>) this.em
                .createQuery(
                        "select e from BpAccountAcct e where e.clientId = :pClientId and e.vendorPurchaseAccount.id = :pVendorPurchaseAccountId",
                        BpAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendorPurchaseAccountId",
                        vendorPurchaseAccountId).getResultList();
    }

    public List<BpAccountAcct> findByVendorPrepayAccount(
            Account vendorPrepayAccount) {
        return this.findByVendorPrepayAccountId(vendorPrepayAccount.getId());
    }

    public List<BpAccountAcct> findByVendorPrepayAccountId(
            Long vendorPrepayAccountId) {
        return (List<BpAccountAcct>) this.em
                .createQuery(
                        "select e from BpAccountAcct e where e.clientId = :pClientId and e.vendorPrepayAccount.id = :pVendorPrepayAccountId",
                        BpAccountAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendorPrepayAccountId", vendorPrepayAccountId)
                .getResultList();
    }

}
