/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;
import net.nan21.dnet.module.bp.md.business.service.IBpAccountService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.BpAccount;

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

    public List<BpAccount> findByBp(BusinessPartner bp) {
        return this.findByBpId(bp.getId());
    }

    public List<BpAccount> findByBpId(Long bpId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.bp.id = :pBpId",
                        BpAccount.class).setParameter("pBpId", bpId)
                .getResultList();
    }

    public List<BpAccount> findByOrganization(Organization organization) {
        return this.findByOrganizationId(organization.getId());
    }

    public List<BpAccount> findByOrganizationId(Long organizationId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.organization.id = :pOrganizationId",
                        BpAccount.class)
                .setParameter("pOrganizationId", organizationId)
                .getResultList();
    }

    public List<BpAccount> findByCustGroup(CustomerGroup custGroup) {
        return this.findByCustGroupId(custGroup.getId());
    }

    public List<BpAccount> findByCustGroupId(Long custGroupId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.custGroup.id = :pCustGroupId",
                        BpAccount.class)
                .setParameter("pCustGroupId", custGroupId).getResultList();
    }

    public List<BpAccount> findByCustPaymentMethod(
            PaymentMethod custPaymentMethod) {
        return this.findByCustPaymentMethodId(custPaymentMethod.getId());
    }

    public List<BpAccount> findByCustPaymentMethodId(Long custPaymentMethodId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.custPaymentMethod.id = :pCustPaymentMethodId",
                        BpAccount.class)
                .setParameter("pCustPaymentMethodId", custPaymentMethodId)
                .getResultList();
    }

    public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm) {
        return this.findByCustPaymentTermId(custPaymentTerm.getId());
    }

    public List<BpAccount> findByCustPaymentTermId(Long custPaymentTermId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.custPaymentTerm.id = :pCustPaymentTermId",
                        BpAccount.class)
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
                        "select e from BpAccount e where e.custDeliveryMethod.id = :pCustDeliveryMethodId",
                        BpAccount.class)
                .setParameter("pCustDeliveryMethodId", custDeliveryMethodId)
                .getResultList();
    }

    public List<BpAccount> findByVendGroup(VendorGroup vendGroup) {
        return this.findByVendGroupId(vendGroup.getId());
    }

    public List<BpAccount> findByVendGroupId(Long vendGroupId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.vendGroup.id = :pVendGroupId",
                        BpAccount.class)
                .setParameter("pVendGroupId", vendGroupId).getResultList();
    }

    public List<BpAccount> findByVendPaymentMethod(
            PaymentMethod vendPaymentMethod) {
        return this.findByVendPaymentMethodId(vendPaymentMethod.getId());
    }

    public List<BpAccount> findByVendPaymentMethodId(Long vendPaymentMethodId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.vendPaymentMethod.id = :pVendPaymentMethodId",
                        BpAccount.class)
                .setParameter("pVendPaymentMethodId", vendPaymentMethodId)
                .getResultList();
    }

    public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm) {
        return this.findByVendPaymentTermId(vendPaymentTerm.getId());
    }

    public List<BpAccount> findByVendPaymentTermId(Long vendPaymentTermId) {
        return (List<BpAccount>) this.em
                .createQuery(
                        "select e from BpAccount e where e.vendPaymentTerm.id = :pVendPaymentTermId",
                        BpAccount.class)
                .setParameter("pVendPaymentTermId", vendPaymentTermId)
                .getResultList();
    }

}