/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = BpAccount.class)
public class BpAccountDs extends AbstractAuditableDs<BpAccount> {

    public static final String fBUSINESSPARTNERID = "businessPartnerId";
    public static final String fBUSINESSPARTNER = "businessPartner";
    public static final String fCUSTOMER = "customer";
    public static final String fVENDOR = "vendor";
    public static final String fORGANIZATIONID = "organizationId";
    public static final String fORGANIZATION = "organization";
    public static final String fCUSTOMERGROUPID = "customerGroupId";
    public static final String fCUSTOMERGROUP = "customerGroup";
    public static final String fCUSTOMERPAYMENTMETHODID = "customerPaymentMethodId";
    public static final String fCUSTOMERPAYMENTMETHOD = "customerPaymentMethod";
    public static final String fCUSTOMERCREDITLIMIT = "customerCreditLimit";
    public static final String fCUSTOMERPAYMENTTERMID = "customerPaymentTermId";
    public static final String fCUSTOMERPAYMENTTERM = "customerPaymentTerm";
    public static final String fVENDORGROUPID = "vendorGroupId";
    public static final String fVENDORGROUP = "vendorGroup";
    public static final String fVENDORPAYMENTMETHODID = "vendorPaymentMethodId";
    public static final String fVENDORPAYMENTMETHOD = "vendorPaymentMethod";
    public static final String fVENDORCREDITLIMIT = "vendorCreditLimit";
    public static final String fVENDORPAYMENTTERMID = "vendorPaymentTermId";
    public static final String fVENDORPAYMENTTERM = "vendorPaymentTerm";

    @DsField(join = "left", path = "bp.id")
    private Long businessPartnerId;

    @DsField(join = "left", path = "bp.code")
    private String businessPartner;

    @DsField()
    private Boolean customer;

    @DsField()
    private Boolean vendor;

    @DsField(join = "left", path = "organization.id")
    private Long organizationId;

    @DsField(join = "left", path = "organization.code")
    private String organization;

    @DsField(join = "left", path = "custGroup.id")
    private Long customerGroupId;

    @DsField(join = "left", path = "custGroup.code")
    private String customerGroup;

    @DsField(join = "left", path = "custPaymentMethod.id")
    private Long customerPaymentMethodId;

    @DsField(join = "left", path = "custPaymentMethod.name")
    private String customerPaymentMethod;

    @DsField(path = "custCreditLimit")
    private Float customerCreditLimit;

    @DsField(join = "left", path = "custPaymentTerm.id")
    private Long customerPaymentTermId;

    @DsField(join = "left", path = "custPaymentTerm.name")
    private String customerPaymentTerm;

    @DsField(join = "left", path = "vendGroup.id")
    private Long vendorGroupId;

    @DsField(join = "left", path = "vendGroup.code")
    private String vendorGroup;

    @DsField(join = "left", path = "vendPaymentMethod.id")
    private Long vendorPaymentMethodId;

    @DsField(join = "left", path = "vendPaymentMethod.name")
    private String vendorPaymentMethod;

    @DsField(path = "vendCreditLimit")
    private Float vendorCreditLimit;

    @DsField(join = "left", path = "vendPaymentTerm.id")
    private Long vendorPaymentTermId;

    @DsField(join = "left", path = "vendPaymentTerm.name")
    private String vendorPaymentTerm;

    public BpAccountDs() {
        super();
    }

    public BpAccountDs(BpAccount e) {
        super(e);
    }

    public Long getBusinessPartnerId() {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
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

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
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

    public void setCustomerPaymentMethodId(Long customerPaymentMethodId) {
        this.customerPaymentMethodId = customerPaymentMethodId;
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

    public void setCustomerCreditLimit(Float customerCreditLimit) {
        this.customerCreditLimit = customerCreditLimit;
    }

    public Long getCustomerPaymentTermId() {
        return this.customerPaymentTermId;
    }

    public void setCustomerPaymentTermId(Long customerPaymentTermId) {
        this.customerPaymentTermId = customerPaymentTermId;
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

    public void setVendorGroupId(Long vendorGroupId) {
        this.vendorGroupId = vendorGroupId;
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

    public void setVendorPaymentMethodId(Long vendorPaymentMethodId) {
        this.vendorPaymentMethodId = vendorPaymentMethodId;
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

    public void setVendorCreditLimit(Float vendorCreditLimit) {
        this.vendorCreditLimit = vendorCreditLimit;
    }

    public Long getVendorPaymentTermId() {
        return this.vendorPaymentTermId;
    }

    public void setVendorPaymentTermId(Long vendorPaymentTermId) {
        this.vendorPaymentTermId = vendorPaymentTermId;
    }

    public String getVendorPaymentTerm() {
        return this.vendorPaymentTerm;
    }

    public void setVendorPaymentTerm(String vendorPaymentTerm) {
        this.vendorPaymentTerm = vendorPaymentTerm;
    }

}
