/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class TaxAcctDsFilter extends AbstractAuditableDsFilter {

    private Long taxId;

    private Long taxId_From;
    private Long taxId_To;

    private String tax;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long salesAccountId;

    private Long salesAccountId_From;
    private Long salesAccountId_To;

    private String salesAccount;

    private String salesAccountName;

    private Long purchaseAccountId;

    private Long purchaseAccountId_From;
    private Long purchaseAccountId_To;

    private String purchaseAccount;

    private String purchaseAccountName;

    private Long nonDeductAccountId;

    private Long nonDeductAccountId_From;
    private Long nonDeductAccountId_To;

    private String nonDeductAccount;

    private String nonDeductAccountName;

    public Long getTaxId() {
        return this.taxId;
    }

    public Long getTaxId_From() {
        return this.taxId_From;
    }

    public Long getTaxId_To() {
        return this.taxId_To;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public void setTaxId_From(Long taxId_From) {
        this.taxId_From = taxId_From;
    }

    public void setTaxId_To(Long taxId_To) {
        this.taxId_To = taxId_To;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
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

    public Long getSalesAccountId() {
        return this.salesAccountId;
    }

    public Long getSalesAccountId_From() {
        return this.salesAccountId_From;
    }

    public Long getSalesAccountId_To() {
        return this.salesAccountId_To;
    }

    public void setSalesAccountId(Long salesAccountId) {
        this.salesAccountId = salesAccountId;
    }

    public void setSalesAccountId_From(Long salesAccountId_From) {
        this.salesAccountId_From = salesAccountId_From;
    }

    public void setSalesAccountId_To(Long salesAccountId_To) {
        this.salesAccountId_To = salesAccountId_To;
    }

    public String getSalesAccount() {
        return this.salesAccount;
    }

    public void setSalesAccount(String salesAccount) {
        this.salesAccount = salesAccount;
    }

    public String getSalesAccountName() {
        return this.salesAccountName;
    }

    public void setSalesAccountName(String salesAccountName) {
        this.salesAccountName = salesAccountName;
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

    public Long getNonDeductAccountId() {
        return this.nonDeductAccountId;
    }

    public Long getNonDeductAccountId_From() {
        return this.nonDeductAccountId_From;
    }

    public Long getNonDeductAccountId_To() {
        return this.nonDeductAccountId_To;
    }

    public void setNonDeductAccountId(Long nonDeductAccountId) {
        this.nonDeductAccountId = nonDeductAccountId;
    }

    public void setNonDeductAccountId_From(Long nonDeductAccountId_From) {
        this.nonDeductAccountId_From = nonDeductAccountId_From;
    }

    public void setNonDeductAccountId_To(Long nonDeductAccountId_To) {
        this.nonDeductAccountId_To = nonDeductAccountId_To;
    }

    public String getNonDeductAccount() {
        return this.nonDeductAccount;
    }

    public void setNonDeductAccount(String nonDeductAccount) {
        this.nonDeductAccount = nonDeductAccount;
    }

    public String getNonDeductAccountName() {
        return this.nonDeductAccountName;
    }

    public void setNonDeductAccountName(String nonDeductAccountName) {
        this.nonDeductAccountName = nonDeductAccountName;
    }

}
