/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

public class VendorGroupService extends AbstractEntityService<VendorGroup>
        implements IVendorGroupService {

    public VendorGroupService() {
        super();
    }

    public VendorGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<VendorGroup> getEntityClass() {
        return VendorGroup.class;
    }

    public VendorGroup findByCode(String code) {
        return (VendorGroup) this.em
                .createNamedQuery(VendorGroup.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public VendorGroup findByName(String name) {
        return (VendorGroup) this.em
                .createNamedQuery(VendorGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<VendorGroup> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<VendorGroup> findByPaymentMethodId(Long paymentMethodId) {
        return (List<VendorGroup>) this.em
                .createQuery(
                        "select e from VendorGroup e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        VendorGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

    public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm) {
        return this.findByPaymentTermId(paymentTerm.getId());
    }

    public List<VendorGroup> findByPaymentTermId(Long paymentTermId) {
        return (List<VendorGroup>) this.em
                .createQuery(
                        "select e from VendorGroup e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
                        VendorGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentTermId", paymentTermId).getResultList();
    }

    public List<VendorGroup> findByAccounts(VendorGroupAcct accounts) {
        return this.findByAccountsId(accounts.getId());
    }

    public List<VendorGroup> findByAccountsId(Long accountsId) {
        return (List<VendorGroup>) this.em
                .createQuery(
                        "select distinct e from VendorGroup e , IN (e.accounts) c where e.clientId = :pClientId and c.id = :pAccountsId",
                        VendorGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccountsId", accountsId).getResultList();
    }

}
