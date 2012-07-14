/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class VendorGroupAcctDsFilter extends AbstractAuditableDsFilter {

    private Long vendorGroupId;

    private Long vendorGroupId_From;
    private Long vendorGroupId_To;

    private String vendorGroup;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long purchaseAccountId;

    private Long purchaseAccountId_From;
    private Long purchaseAccountId_To;

    private String purchaseAccount;

    private String purchaseAccountName;

    private Long prepayAccountId;

    private Long prepayAccountId_From;
    private Long prepayAccountId_To;

    private String prepayAccount;

    private String prepayAccountName;

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

    public Long getPurchaseAccountId() {
        return this.purchaseAccountId;
    }

    public Long getPurchaseAccountId_From() {
        return this.purchaseAccountId_From;
    }

    public Long getPurchaseAccountId_To() {
        return this.purchaseAccountId_To;
    }

    public void setPurchaseAccountId(Long purchaseAccountId) {
        this.purchaseAccountId = purchaseAccountId;
    }

    public void setPurchaseAccountId_From(Long purchaseAccountId_From) {
        this.purchaseAccountId_From = purchaseAccountId_From;
    }

    public void setPurchaseAccountId_To(Long purchaseAccountId_To) {
        this.purchaseAccountId_To = purchaseAccountId_To;
    }

    public String getPurchaseAccount() {
        return this.purchaseAccount;
    }

    public void setPurchaseAccount(String purchaseAccount) {
        this.purchaseAccount = purchaseAccount;
    }

    public String getPurchaseAccountName() {
        return this.purchaseAccountName;
    }

    public void setPurchaseAccountName(String purchaseAccountName) {
        this.purchaseAccountName = purchaseAccountName;
    }

    public Long getPrepayAccountId() {
        return this.prepayAccountId;
    }

    public Long getPrepayAccountId_From() {
        return this.prepayAccountId_From;
    }

    public Long getPrepayAccountId_To() {
        return this.prepayAccountId_To;
    }

    public void setPrepayAccountId(Long prepayAccountId) {
        this.prepayAccountId = prepayAccountId;
    }

    public void setPrepayAccountId_From(Long prepayAccountId_From) {
        this.prepayAccountId_From = prepayAccountId_From;
    }

    public void setPrepayAccountId_To(Long prepayAccountId_To) {
        this.prepayAccountId_To = prepayAccountId_To;
    }

    public String getPrepayAccount() {
        return this.prepayAccount;
    }

    public void setPrepayAccount(String prepayAccount) {
        this.prepayAccount = prepayAccount;
    }

    public String getPrepayAccountName() {
        return this.prepayAccountName;
    }

    public void setPrepayAccountName(String prepayAccountName) {
        this.prepayAccountName = prepayAccountName;
    }

}
