/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

public class VendorGroupAcctService extends
        AbstractEntityService<VendorGroupAcct> implements
        IVendorGroupAcctService {

    public VendorGroupAcctService() {
        super();
    }

    public VendorGroupAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<VendorGroupAcct> getEntityClass() {
        return VendorGroupAcct.class;
    }

    public VendorGroupAcct findByGroup_schema(CustomerGroup vendorGroup,
            AccSchema accSchema) {
        return (VendorGroupAcct) this.em
                .createNamedQuery(VendorGroupAcct.NQ_FIND_BY_GROUP_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendorGroup", vendorGroup)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public VendorGroupAcct findByGroup_schema(Long vendorGroupId,
            Long accSchemaId) {
        return (VendorGroupAcct) this.em
                .createNamedQuery(
                        VendorGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendorGroupId", vendorGroupId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<VendorGroupAcct> findByVendorGroup(CustomerGroup vendorGroup) {
        return this.findByVendorGroupId(vendorGroup.getId());
    }

    public List<VendorGroupAcct> findByVendorGroupId(Long vendorGroupId) {
        return (List<VendorGroupAcct>) this.em
                .createQuery(
                        "select e from VendorGroupAcct e where e.clientId = :pClientId and e.vendorGroup.id = :pVendorGroupId",
                        VendorGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendorGroupId", vendorGroupId).getResultList();
    }

    public List<VendorGroupAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<VendorGroupAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<VendorGroupAcct>) this.em
                .createQuery(
                        "select e from VendorGroupAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        VendorGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<VendorGroupAcct> findByPurchaseAccount(Account purchaseAccount) {
        return this.findByPurchaseAccountId(purchaseAccount.getId());
    }

    public List<VendorGroupAcct> findByPurchaseAccountId(Long purchaseAccountId) {
        return (List<VendorGroupAcct>) this.em
                .createQuery(
                        "select e from VendorGroupAcct e where e.clientId = :pClientId and e.purchaseAccount.id = :pPurchaseAccountId",
                        VendorGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPurchaseAccountId", purchaseAccountId)
                .getResultList();
    }

    public List<VendorGroupAcct> findByPrepayAccount(Account prepayAccount) {
        return this.findByPrepayAccountId(prepayAccount.getId());
    }

    public List<VendorGroupAcct> findByPrepayAccountId(Long prepayAccountId) {
        return (List<VendorGroupAcct>) this.em
                .createQuery(
                        "select e from VendorGroupAcct e where e.clientId = :pClientId and e.prepayAccount.id = :pPrepayAccountId",
                        VendorGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPrepayAccountId", prepayAccountId)
                .getResultList();
    }

}
