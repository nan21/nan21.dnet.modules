/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

public class BpAccountService extends AbstractEntityService<BpAccount>
        implements IBpAccountService {

    public BpAccountService() {
        super();
    }

    public BpAccountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BpAccount> getEntityClass() {
        return BpAccount.class;
    }

    public BpAccount findByBp_org(BusinessPartner bp, Organization organization) {
        return (BpAccount) this.em
                .createNamedQuery(BpAccount.NQ_FIND_BY_BP_ORG)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBp", bp)
                .setParameter("pOrganization", organization).getSingleResult();
    }

    public BpAccount findByBp_org(Long bpId, Long organizationId) {
        return (BpAccount) this.em
                .createNamedQuery(BpAccount.NQ_FIND_BY_BP_ORG_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpId", bpId)
                .setParameter("pOrganizationId", organizationId)
                .getSingleResult();
    }

    public List<BpAccount> findByBp(BusinessPartner bp) {
        return this.findByBpId(bp.getId());
    }

    public List<BpAccount> findByBpId(Long bpId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.bp.id = :pBpId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpId", bpId).getResultList();
    }

    public List<BpAccount> findByOrganization(Organization organization) {
        return this.findByOrganizationId(organization.getId());
    }

    public List<BpAccount> findByOrganizationId(Long organizationId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.organization.id = :pOrganizationId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrganizationId", organizationId)
                .getResultList();
    }

    public List<BpAccount> findByCustGroup(CustomerGroup custGroup) {
        return this.findByCustGroupId(custGroup.getId());
    }

    public List<BpAccount> findByCustGroupId(Long custGroupId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.custGroup.id = :pCustGroupId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustGroupId", custGroupId).getResultList();
    }

    public List<BpAccount> findByCustPaymentMethod(
            PaymentMethod custPaymentMethod) {
        return this.findByCustPaymentMethodId(custPaymentMethod.getId());
    }

    public List<BpAccount> findByCustPaymentMethodId(Long custPaymentMethodId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.custPaymentMethod.id = :pCustPaymentMethodId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustPaymentMethodId", custPaymentMethodId)
                .getResultList();
    }

    public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm) {
        return this.findByCustPaymentTermId(custPaymentTerm.getId());
    }

    public List<BpAccount> findByCustPaymentTermId(Long custPaymentTermId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.custPaymentTerm.id = :pCustPaymentTermId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustPaymentTermId", custPaymentTermId)
                .getResultList();
    }

    public List<BpAccount> findByCustDeliveryMethod(
            DeliveryMethod custDeliveryMethod) {
        return this.findByCustDeliveryMethodId(custDeliveryMethod.getId());
    }

    public List<BpAccount> findByCustDeliveryMethodId(Long custDeliveryMethodId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.custDeliveryMethod.id = :pCustDeliveryMethodId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustDeliveryMethodId", custDeliveryMethodId)
                .getResultList();
    }

    public List<BpAccount> findByVendGroup(VendorGroup vendGroup) {
        return this.findByVendGroupId(vendGroup.getId());
    }

    public List<BpAccount> findByVendGroupId(Long vendGroupId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.vendGroup.id = :pVendGroupId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendGroupId", vendGroupId).getResultList();
    }

    public List<BpAccount> findByVendPaymentMethod(
            PaymentMethod vendPaymentMethod) {
        return this.findByVendPaymentMethodId(vendPaymentMethod.getId());
    }

    public List<BpAccount> findByVendPaymentMethodId(Long vendPaymentMethodId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.vendPaymentMethod.id = :pVendPaymentMethodId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendPaymentMethodId", vendPaymentMethodId)
                .getResultList();
    }

    public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm) {
        return this.findByVendPaymentTermId(vendPaymentTerm.getId());
    }

    public List<BpAccount> findByVendPaymentTermId(Long vendPaymentTermId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.clientId = :pClientId and e.vendPaymentTerm.id = :pVendPaymentTermId",
                        BpAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVendPaymentTermId", vendPaymentTermId)
                .getResultList();
    }

}
