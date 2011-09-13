/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.business.service.ICustomerGroupService;
import net.nan21.dnet.module.bp.base.business.service.IPaymentMethodService;
import net.nan21.dnet.module.bp.base.business.service.IPaymentTermService;
import net.nan21.dnet.module.bp.base.business.service.IVendorGroupService;
import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BpAccountDs;
import net.nan21.dnet.module.bp.md.domain.entity.BpAccount;

public class BpAccountDsConv extends
        AbstractDsConverter<BpAccountDs, BpAccount> implements
        IDsConverter<BpAccountDs, BpAccount> {

    protected void modelToEntityAttributes(BpAccountDs ds, BpAccount e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setCustCreditLimit(ds.getCustomerCreditLimit());
        e.setVendCreditLimit(ds.getVendorCreditLimit());
    }

    protected void modelToEntityReferences(BpAccountDs ds, BpAccount e)
            throws Exception {

        if (ds.getBusinessPartnerId() != null) {
            if (e.getBp() == null
                    || !e.getBp().getId().equals(ds.getBusinessPartnerId())) {
                e.setBp((BusinessPartner) this.em.find(BusinessPartner.class,
                        ds.getBusinessPartnerId()));
            }
        } else {
            this.lookup_bp_BusinessPartner(ds, e);
        }
        if (ds.getOrganizationId() != null) {
            if (e.getOrganization() == null
                    || !e.getOrganization().getId()
                            .equals(ds.getOrganizationId())) {
                e.setOrganization((Organization) this.em.find(
                        Organization.class, ds.getOrganizationId()));
            }
        } else {
            this.lookup_organization_Organization(ds, e);
        }
        if (ds.getCustomerGroupId() != null) {
            if (e.getCustGroup() == null
                    || !e.getCustGroup().getId()
                            .equals(ds.getCustomerGroupId())) {
                e.setCustGroup((CustomerGroup) this.em.find(
                        CustomerGroup.class, ds.getCustomerGroupId()));
            }
        } else {
            this.lookup_custGroup_CustomerGroup(ds, e);
        }
        if (ds.getCustomerPaymentMethodId() != null) {
            if (e.getCustPaymentMethod() == null
                    || !e.getCustPaymentMethod().getId()
                            .equals(ds.getCustomerPaymentMethodId())) {
                e.setCustPaymentMethod((PaymentMethod) this.em.find(
                        PaymentMethod.class, ds.getCustomerPaymentMethodId()));
            }
        } else {
            this.lookup_custPaymentMethod_PaymentMethod(ds, e);
        }
        if (ds.getCustomerPaymentTermId() != null) {
            if (e.getCustPaymentTerm() == null
                    || !e.getCustPaymentTerm().getId()
                            .equals(ds.getCustomerPaymentTermId())) {
                e.setCustPaymentTerm((PaymentTerm) this.em.find(
                        PaymentTerm.class, ds.getCustomerPaymentTermId()));
            }
        } else {
            this.lookup_custPaymentTerm_PaymentTerm(ds, e);
        }
        if (ds.getVendorGroupId() != null) {
            if (e.getVendGroup() == null
                    || !e.getVendGroup().getId().equals(ds.getVendorGroupId())) {
                e.setVendGroup((VendorGroup) this.em.find(VendorGroup.class,
                        ds.getVendorGroupId()));
            }
        } else {
            this.lookup_vendGroup_VendorGroup(ds, e);
        }
        if (ds.getVendorPaymentMethodId() != null) {
            if (e.getVendPaymentMethod() == null
                    || !e.getVendPaymentMethod().getId()
                            .equals(ds.getVendorPaymentMethodId())) {
                e.setVendPaymentMethod((PaymentMethod) this.em.find(
                        PaymentMethod.class, ds.getVendorPaymentMethodId()));
            }
        } else {
            this.lookup_vendPaymentMethod_PaymentMethod(ds, e);
        }
        if (ds.getVendorPaymentTermId() != null) {
            if (e.getVendPaymentTerm() == null
                    || !e.getVendPaymentTerm().getId()
                            .equals(ds.getVendorPaymentTermId())) {
                e.setVendPaymentTerm((PaymentTerm) this.em.find(
                        PaymentTerm.class, ds.getVendorPaymentTermId()));
            }
        } else {
            this.lookup_vendPaymentTerm_PaymentTerm(ds, e);
        }
    }

    protected void lookup_bp_BusinessPartner(BpAccountDs ds, BpAccount e)
            throws Exception {
        if (ds.getBusinessPartner() != null
                && !ds.getBusinessPartner().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                        .findByCode(ds.getClientId(), ds.getBusinessPartner());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `businessPartner` = "
                                + ds.getBusinessPartner() + "  ");
            }
            e.setBp(x);
        } else {
            e.setBp(null);
        }
    }

    protected void lookup_organization_Organization(BpAccountDs ds, BpAccount e)
            throws Exception {
        if (ds.getOrganization() != null && !ds.getOrganization().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) getService(IOrganizationService.class))
                        .findByCode(ds.getClientId(), ds.getOrganization());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `organization` = "
                                + ds.getOrganization() + "  ");
            }
            e.setOrganization(x);
        } else {
            e.setOrganization(null);
        }
    }

    protected void lookup_custGroup_CustomerGroup(BpAccountDs ds, BpAccount e)
            throws Exception {
        if (ds.getCustomerGroup() != null && !ds.getCustomerGroup().equals("")) {
            CustomerGroup x = null;
            try {
                x = ((ICustomerGroupService) getService(ICustomerGroupService.class))
                        .findByCode(ds.getClientId(), ds.getCustomerGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CustomerGroup` reference:  `customerGroup` = "
                                + ds.getCustomerGroup() + "  ");
            }
            e.setCustGroup(x);
        } else {
            e.setCustGroup(null);
        }
    }

    protected void lookup_custPaymentMethod_PaymentMethod(BpAccountDs ds,
            BpAccount e) throws Exception {
        if (ds.getCustomerPaymentMethod() != null
                && !ds.getCustomerPaymentMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) getService(IPaymentMethodService.class))
                        .findByName(ds.getClientId(),
                                ds.getCustomerPaymentMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentMethod` reference:  `customerPaymentMethod` = "
                                + ds.getCustomerPaymentMethod() + "  ");
            }
            e.setCustPaymentMethod(x);
        } else {
            e.setCustPaymentMethod(null);
        }
    }

    protected void lookup_custPaymentTerm_PaymentTerm(BpAccountDs ds,
            BpAccount e) throws Exception {
        if (ds.getCustomerPaymentTerm() != null
                && !ds.getCustomerPaymentTerm().equals("")) {
            PaymentTerm x = null;
            try {
                x = ((IPaymentTermService) getService(IPaymentTermService.class))
                        .findByName(ds.getClientId(),
                                ds.getCustomerPaymentTerm());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentTerm` reference:  `customerPaymentTerm` = "
                                + ds.getCustomerPaymentTerm() + "  ");
            }
            e.setCustPaymentTerm(x);
        } else {
            e.setCustPaymentTerm(null);
        }
    }

    protected void lookup_vendGroup_VendorGroup(BpAccountDs ds, BpAccount e)
            throws Exception {
        if (ds.getVendorGroup() != null && !ds.getVendorGroup().equals("")) {
            VendorGroup x = null;
            try {
                x = ((IVendorGroupService) getService(IVendorGroupService.class))
                        .findByCode(ds.getClientId(), ds.getVendorGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `VendorGroup` reference:  `vendorGroup` = "
                                + ds.getVendorGroup() + "  ");
            }
            e.setVendGroup(x);
        } else {
            e.setVendGroup(null);
        }
    }

    protected void lookup_vendPaymentMethod_PaymentMethod(BpAccountDs ds,
            BpAccount e) throws Exception {
        if (ds.getVendorPaymentMethod() != null
                && !ds.getVendorPaymentMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) getService(IPaymentMethodService.class))
                        .findByName(ds.getClientId(),
                                ds.getVendorPaymentMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentMethod` reference:  `vendorPaymentMethod` = "
                                + ds.getVendorPaymentMethod() + "  ");
            }
            e.setVendPaymentMethod(x);
        } else {
            e.setVendPaymentMethod(null);
        }
    }

    protected void lookup_vendPaymentTerm_PaymentTerm(BpAccountDs ds,
            BpAccount e) throws Exception {
        if (ds.getVendorPaymentTerm() != null
                && !ds.getVendorPaymentTerm().equals("")) {
            PaymentTerm x = null;
            try {
                x = ((IPaymentTermService) getService(IPaymentTermService.class))
                        .findByName(ds.getClientId(), ds.getVendorPaymentTerm());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentTerm` reference:  `vendorPaymentTerm` = "
                                + ds.getVendorPaymentTerm() + "  ");
            }
            e.setVendPaymentTerm(x);
        } else {
            e.setVendPaymentTerm(null);
        }
    }

    @Override
    public void entityToModel(BpAccount e, BpAccountDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCustomerCreditLimit(e.getCustCreditLimit());
        ds.setVendorCreditLimit(e.getVendCreditLimit());
        ds.setBusinessPartnerId(((e.getBp() != null)) ? e.getBp().getId()
                : null);
        ds.setBusinessPartner(((e.getBp() != null)) ? e.getBp().getCode()
                : null);
        ds.setOrganizationId(((e.getOrganization() != null)) ? e
                .getOrganization().getId() : null);
        ds.setOrganization(((e.getOrganization() != null)) ? e
                .getOrganization().getCode() : null);
        ds.setCustomerGroupId(((e.getCustGroup() != null)) ? e.getCustGroup()
                .getId() : null);
        ds.setCustomerGroup(((e.getCustGroup() != null)) ? e.getCustGroup()
                .getCode() : null);
        ds.setCustomerPaymentMethodId(((e.getCustPaymentMethod() != null)) ? e
                .getCustPaymentMethod().getId() : null);
        ds.setCustomerPaymentMethod(((e.getCustPaymentMethod() != null)) ? e
                .getCustPaymentMethod().getName() : null);
        ds.setCustomerPaymentTermId(((e.getCustPaymentTerm() != null)) ? e
                .getCustPaymentTerm().getId() : null);
        ds.setCustomerPaymentTerm(((e.getCustPaymentTerm() != null)) ? e
                .getCustPaymentTerm().getName() : null);
        ds.setVendorGroupId(((e.getVendGroup() != null)) ? e.getVendGroup()
                .getId() : null);
        ds.setVendorGroup(((e.getVendGroup() != null)) ? e.getVendGroup()
                .getCode() : null);
        ds.setVendorPaymentMethodId(((e.getVendPaymentMethod() != null)) ? e
                .getVendPaymentMethod().getId() : null);
        ds.setVendorPaymentMethod(((e.getVendPaymentMethod() != null)) ? e
                .getVendPaymentMethod().getName() : null);
        ds.setVendorPaymentTermId(((e.getVendPaymentTerm() != null)) ? e
                .getVendPaymentTerm().getId() : null);
        ds.setVendorPaymentTerm(((e.getVendPaymentTerm() != null)) ? e
                .getVendPaymentTerm().getName() : null);
    }

}
