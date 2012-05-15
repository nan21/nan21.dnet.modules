/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class BpAccountAcctDsFilter extends AbstractAuditableDsFilter {

    private Long bpAccountId;

    private Long bpAccountId_From;
    private Long bpAccountId_To;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long custSalesAccountId;

    private Long custSalesAccountId_From;
    private Long custSalesAccountId_To;

    private String custSalesAccount;

    private Long custPrepayAccountId;

    private Long custPrepayAccountId_From;
    private Long custPrepayAccountId_To;

    private String custPrepayAccount;

    private Long vendorPurchaseAccountId;

    private Long vendorPurchaseAccountId_From;
    private Long vendorPurchaseAccountId_To;

    private String vendorPurchaseAccount;

    private Long vendorPrepayAccountId;

    private Long vendorPrepayAccountId_From;
    private Long vendorPrepayAccountId_To;

    private String vendorPrepayAccount;

    public Long getBpAccountId() {
        return this.bpAccountId;
    }

    public Long getBpAccountId_From() {
        return this.bpAccountId_From;
    }

    public Long getBpAccountId_To() {
        return this.bpAccountId_To;
    }

    public void setBpAccountId(Long bpAccountId) {
        this.bpAccountId = bpAccountId;
    }

    public void setBpAccountId_From(Long bpAccountId_From) {
        this.bpAccountId_From = bpAccountId_From;
    }

    public void setBpAccountId_To(Long bpAccountId_To) {
        this.bpAccountId_To = bpAccountId_To;
    }

    public Long getAccSchemaId() {
        return this.accSchemaId;
    }

    public Long getAccSchemaId_From() {
        return this.accSchemaId_From;
    }

    public Long getAccSchemaId_To() {
        return this.accSchemaId_To;
    }

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
    }

    public void setAccSchemaId_From(Long accSchemaId_From) {
        this.accSchemaId_From = accSchemaId_From;
    }

    public void setAccSchemaId_To(Long accSchemaId_To) {
        this.accSchemaId_To = accSchemaId_To;
    }

    public String getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(String accSchema) {
        this.accSchema = accSchema;
    }

    public Long getCustSalesAccountId() {
        return this.custSalesAccountId;
    }

    public Long getCustSalesAccountId_From() {
        return this.custSalesAccountId_From;
    }

    public Long getCustSalesAccountId_To() {
        return this.custSalesAccountId_To;
    }

    public void setCustSalesAccountId(Long custSalesAccountId) {
        this.custSalesAccountId = custSalesAccountId;
    }

    public void setCustSalesAccountId_From(Long custSalesAccountId_From) {
        this.custSalesAccountId_From = custSalesAccountId_From;
    }

    public void setCustSalesAccountId_To(Long custSalesAccountId_To) {
        this.custSalesAccountId_To = custSalesAccountId_To;
    }

    public String getCustSalesAccount() {
        return this.custSalesAccount;
    }

    public void setCustSalesAccount(String custSalesAccount) {
        this.custSalesAccount = custSalesAccount;
    }

    public Long getCustPrepayAccountId() {
        return this.custPrepayAccountId;
    }

    public Long getCustPrepayAccountId_From() {
        return this.custPrepayAccountId_From;
    }

    public Long getCustPrepayAccountId_To() {
        return this.custPrepayAccountId_To;
    }

    public void setCustPrepayAccountId(Long custPrepayAccountId) {
        this.custPrepayAccountId = custPrepayAccountId;
    }

    public void setCustPrepayAccountId_From(Long custPrepayAccountId_From) {
        this.custPrepayAccountId_From = custPrepayAccountId_From;
    }

    public void setCustPrepayAccountId_To(Long custPrepayAccountId_To) {
        this.custPrepayAccountId_To = custPrepayAccountId_To;
    }

    public String getCustPrepayAccount() {
        return this.custPrepayAccount;
    }

    public void setCustPrepayAccount(String custPrepayAccount) {
        this.custPrepayAccount = custPrepayAccount;
    }

    public Long getVendorPurchaseAccountId() {
        return this.vendorPurchaseAccountId;
    }

    public Long getVendorPurchaseAccountId_From() {
        return this.vendorPurchaseAccountId_From;
    }

    public Long getVendorPurchaseAccountId_To() {
        return this.vendorPurchaseAccountId_To;
    }

    public void setVendorPurchaseAccountId(Long vendorPurchaseAccountId) {
        this.vendorPurchaseAccountId = vendorPurchaseAccountId;
    }

    public void setVendorPurchaseAccountId_From(
            Long vendorPurchaseAccountId_From) {
        this.vendorPurchaseAccountId_From = vendorPurchaseAccountId_From;
    }

    public void setVendorPurchaseAccountId_To(Long vendorPurchaseAccountId_To) {
        this.vendorPurchaseAccountId_To = vendorPurchaseAccountId_To;
    }

    public String getVendorPurchaseAccount() {
        return this.vendorPurchaseAccount;
    }

    public void setVendorPurchaseAccount(String vendorPurchaseAccount) {
        this.vendorPurchaseAccount = vendorPurchaseAccount;
    }

    public Long getVendorPrepayAccountId() {
        return this.vendorPrepayAccountId;
    }

    public Long getVendorPrepayAccountId_From() {
        return this.vendorPrepayAccountId_From;
    }

    public Long getVendorPrepayAccountId_To() {
        return this.vendorPrepayAccountId_To;
    }

    public void setVendorPrepayAccountId(Long vendorPrepayAccountId) {
        this.vendorPrepayAccountId = vendorPrepayAccountId;
    }

    public void setVendorPrepayAccountId_From(Long vendorPrepayAccountId_From) {
        this.vendorPrepayAccountId_From = vendorPrepayAccountId_From;
    }

    public void setVendorPrepayAccountId_To(Long vendorPrepayAccountId_To) {
        this.vendorPrepayAccountId_To = vendorPrepayAccountId_To;
    }

    public String getVendorPrepayAccount() {
        return this.vendorPrepayAccount;
    }

    public void setVendorPrepayAccount(String vendorPrepayAccount) {
        this.vendorPrepayAccount = vendorPrepayAccount;
    }

}
