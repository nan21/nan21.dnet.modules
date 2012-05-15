/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.bd.fin.business.service.ITaxAcctService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.fin.domain.entity.TaxAcct;

public class TaxAcctService extends AbstractEntityService<TaxAcct> implements
        ITaxAcctService {

    public TaxAcctService() {
        super();
    }

    public TaxAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<TaxAcct> getEntityClass() {
        return TaxAcct.class;
    }

    public TaxAcct findByTax_schema(Tax tax, AccSchema accSchema) {
        return (TaxAcct) this.em
                .createNamedQuery(TaxAcct.NQ_FIND_BY_TAX_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTax", tax)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public TaxAcct findByTax_schema(Long taxId, Long accSchemaId) {
        return (TaxAcct) this.em
                .createNamedQuery(TaxAcct.NQ_FIND_BY_TAX_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<TaxAcct> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<TaxAcct> findByTaxId(Long taxId) {
        return (List<TaxAcct>) this.em
                .createQuery(
                        "select e from TaxAcct e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        TaxAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

    public List<TaxAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<TaxAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<TaxAcct>) this.em
                .createQuery(
                        "select e from TaxAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        TaxAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<TaxAcct> findBySalesAccount(Account salesAccount) {
        return this.findBySalesAccountId(salesAccount.getId());
    }

    public List<TaxAcct> findBySalesAccountId(Long salesAccountId) {
        return (List<TaxAcct>) this.em
                .createQuery(
                        "select e from TaxAcct e where e.clientId = :pClientId and e.salesAccount.id = :pSalesAccountId",
                        TaxAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesAccountId", salesAccountId)
                .getResultList();
    }

    public List<TaxAcct> findByPurchaseAccount(Account purchaseAccount) {
        return this.findByPurchaseAccountId(purchaseAccount.getId());
    }

    public List<TaxAcct> findByPurchaseAccountId(Long purchaseAccountId) {
        return (List<TaxAcct>) this.em
                .createQuery(
                        "select e from TaxAcct e where e.clientId = :pClientId and e.purchaseAccount.id = :pPurchaseAccountId",
                        TaxAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseAccountId", purchaseAccountId)
                .getResultList();
    }

}
