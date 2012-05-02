/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class BpAccountDsFilter extends AbstractAuditableDsFilter {

    private Long businessPartnerId;

    private Long businessPartnerId_From;
    private Long businessPartnerId_To;

    private String businessPartner;

    private Boolean customer;

    private Boolean vendor;

    private Long organizationId;

    private Long organizationId_From;
    private Long organizationId_To;

    private String organization;

    private Long customerGroupId;

    private Long customerGroupId_From;
    private Long customerGroupId_To;

    private String customerGroup;

    private Long customerPaymentMethodId;

    private Long customerPaymentMethodId_From;
    private Long customerPaymentMethodId_To;

    private String customerPaymentMethod;

    private Float customerCreditLimit;

    private Float customerCreditLimit_From;
    private Float customerCreditLimit_To;

    private Long customerPaymentTermId;

    private Long customerPaymentTermId_From;
    private Long customerPaymentTermId_To;

    private String customerPaymentTerm;

    private Long vendorGroupId;

    private Long vendorGroupId_From;
    private Long vendorGroupId_To;

    private String vendorGroup;

    private Long vendorPaymentMethodId;

    private Long vendorPaymentMethodId_From;
    private Long vendorPaymentMethodId_To;

    private String vendorPaymentMethod;

    private Float vendorCreditLimit;

    private Float vendorCreditLimit_From;
    private Float vendorCreditLimit_To;

    private Long vendorPaymentTermId;

    private Long vendorPaymentTermId_From;
    private Long vendorPaymentTermId_To;

    private String vendorPaymentTerm;

    public Long getBusinessPartnerId() {
        return this.businessPartnerId;
    }

    public Long getBusinessPartnerId_From() {
        return this.businessPartnerId_From;
    }

    public Long getBusinessPartnerId_To() {
        return this.businessPartnerId_To;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public void setBusinessPartnerId_From(Long businessPartnerId_From) {
        this.businessPartnerId_From = businessPartnerId_From;
    }

    public void setBusinessPartnerId_To(Long businessPartnerId_To) {
        this.businessPartnerId_To = businessPartnerId_To;
    }

    public String getBusinessPartner() {
        return this.businessPartner;
    }

    public void setBusinessPartner(String businessPartner) {
        this.businessPartner = businessPartner;
    }

    public Boolean getCustomer() {
        return this.customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    public Boolean getVendor() {
        return this.vendor;
    }

    public void setVendor(Boolean vendor) {
        this.vendor = vendor;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public Long getOrganizationId_From() {
        return this.organizationId_From;
    }

    public Long getOrganizationId_To() {
        return this.organizationId_To;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationId_From(Long organizationId_From) {
        this.organizationId_From = organizationId_From;
    }

    public void setOrganizationId_To(Long organizationId_To) {
        this.organizationId_To = organizationId_To;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Long getCustomerGroupId() {
        return this.customerGroupId;
    }

    public Long getCustomerGroupId_From() {
        return this.customerGroupId_From;
    }

    public Long getCustomerGroupId_To() {
        return this.customerGroupId_To;
    }

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public void setCustomerGroupId_From(Long customerGroupId_From) {
        this.customerGroupId_From = customerGroupId_From;
    }

    public void setCustomerGroupId_To(Long customerGroupId_To) {
        this.customerGroupId_To = customerGroupId_To;
    }

    public String getCustomerGroup() {
        return this.customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public Long getCustomerPaymentMethodId() {
        return this.customerPaymentMethodId;
    }

    public Long getCustomerPaymentMethodId_From() {
        return this.customerPaymentMethodId_From;
    }

    public Long getCustomerPaymentMethodId_To() {
        return this.customerPaymentMethodId_To;
    }

    public void setCustomerPaymentMethodId(Long customerPaymentMethodId) {
        this.customerPaymentMethodId = customerPaymentMethodId;
    }

    public void setCustomerPaymentMethodId_From(
            Long customerPaymentMethodId_From) {
        this.customerPaymentMethodId_From = customerPaymentMethodId_From;
    }

    public void setCustomerPaymentMethodId_To(Long customerPaymentMethodId_To) {
        this.customerPaymentMethodId_To = customerPaymentMethodId_To;
    }

    public String getCustomerPaymentMethod() {
        return this.customerPaymentMethod;
    }

    public void setCustomerPaymentMethod(String customerPaymentMethod) {
        this.customerPaymentMethod = customerPaymentMethod;
    }

    public Float getCustomerCreditLimit() {
        return this.customerCreditLimit;
    }

    public Float getCustomerCreditLimit_From() {
        return this.customerCreditLimit_From;
    }

    public Float getCustomerCreditLimit_To() {
        return this.customerCreditLimit_To;
    }

    public void setCustomerCreditLimit(Float customerCreditLimit) {
        this.customerCreditLimit = customerCreditLimit;
    }

    public void setCustomerCreditLimit_From(Float customerCreditLimit_From) {
        this.customerCreditLimit_From = customerCreditLimit_From;
    }

    public void setCustomerCreditLimit_To(Float customerCreditLimit_To) {
        this.customerCreditLimit_To = customerCreditLimit_To;
    }

    public Long getCustomerPaymentTermId() {
        return this.customerPaymentTermId;
    }

    public Long getCustomerPaymentTermId_From() {
        return this.customerPaymentTermId_From;
    }

    public Long getCustomerPaymentTermId_To() {
        return this.customerPaymentTermId_To;
    }

    public void setCustomerPaymentTermId(Long customerPaymentTermId) {
        this.customerPaymentTermId = customerPaymentTermId;
    }

    public void setCustomerPaymentTermId_From(Long customerPaymentTermId_From) {
        this.customerPaymentTermId_From = customerPaymentTermId_From;
    }

    public void setCustomerPaymentTermId_To(Long customerPaymentTermId_To) {
        this.customerPaymentTermId_To = customerPaymentTermId_To;
    }

    public String getCustomerPaymentTerm() {
        return this.customerPaymentTerm;
    }

    public void setCustomerPaymentTerm(String customerPaymentTerm) {
        this.customerPaymentTerm = customerPaymentTerm;
    }

    public Long getVendorGroupId() {
        return this.vendorGroupId;
    }

    public Long getVendorGroupId_From() {
        return this.vendorGroupId_From;
    }

    public Long getVendorGroupId_To() {
        return this.vendorGroupId_To;
    }

    public void setVendorGroupId(Long vendorGroupId) {
        this.vendorGroupId = vendorGroupId;
    }

    public void setVendorGroupId_From(Long vendorGroupId_From) {
        this.vendorGroupId_From = vendorGroupId_From;
    }

    public void setVendorGroupId_To(Long vendorGroupId_To) {
        this.vendorGroupId_To = vendorGroupId_To;
    }

    public String getVendorGroup() {
        return this.vendorGroup;
    }

    public void setVendorGroup(String vendorGroup) {
        this.vendorGroup = vendorGroup;
    }

    public Long getVendorPaymentMethodId() {
        return this.vendorPaymentMethodId;
    }

    public Long getVendorPaymentMethodId_From() {
        return this.vendorPaymentMethodId_From;
    }

    public Long getVendorPaymentMethodId_To() {
        return this.vendorPaymentMethodId_To;
    }

    public void setVendorPaymentMethodId(Long vendorPaymentMethodId) {
        this.vendorPaymentMethodId = vendorPaymentMethodId;
    }

    public void setVendorPaymentMethodId_From(Long vendorPaymentMethodId_From) {
        this.vendorPaymentMethodId_From = vendorPaymentMethodId_From;
    }

    public void setVendorPaymentMethodId_To(Long vendorPaymentMethodId_To) {
        this.vendorPaymentMethodId_To = vendorPaymentMethodId_To;
    }

    public String getVendorPaymentMethod() {
        return this.vendorPaymentMethod;
    }

    public void setVendorPaymentMethod(String vendorPaymentMethod) {
        this.vendorPaymentMethod = vendorPaymentMethod;
    }

    public Float getVendorCreditLimit() {
        return this.vendorCreditLimit;
    }

    public Float getVendorCreditLimit_From() {
        return this.vendorCreditLimit_From;
    }

    public Float getVendorCreditLimit_To() {
        return this.vendorCreditLimit_To;
    }

    public void setVendorCreditLimit(Float vendorCreditLimit) {
        this.vendorCreditLimit = vendorCreditLimit;
    }

    public void setVendorCreditLimit_From(Float vendorCreditLimit_From) {
        this.vendorCreditLimit_From = vendorCreditLimit_From;
    }

    public void setVendorCreditLimit_To(Float vendorCreditLimit_To) {
        this.vendorCreditLimit_To = vendorCreditLimit_To;
    }

    public Long getVendorPaymentTermId() {
        return this.vendorPaymentTermId;
    }

    public Long getVendorPaymentTermId_From() {
        return this.vendorPaymentTermId_From;
    }

    public Long getVendorPaymentTermId_To() {
        return this.vendorPaymentTermId_To;
    }

    public void setVendorPaymentTermId(Long vendorPaymentTermId) {
        this.vendorPaymentTermId = vendorPaymentTermId;
    }

    public void setVendorPaymentTermId_From(Long vendorPaymentTermId_From) {
        this.vendorPaymentTermId_From = vendorPaymentTermId_From;
    }

    public void setVendorPaymentTermId_To(Long vendorPaymentTermId_To) {
        this.vendorPaymentTermId_To = vendorPaymentTermId_To;
    }

    public String getVendorPaymentTerm() {
        return this.vendorPaymentTerm;
    }

    public void setVendorPaymentTerm(String vendorPaymentTerm) {
        this.vendorPaymentTerm = vendorPaymentTerm;
    }

}
