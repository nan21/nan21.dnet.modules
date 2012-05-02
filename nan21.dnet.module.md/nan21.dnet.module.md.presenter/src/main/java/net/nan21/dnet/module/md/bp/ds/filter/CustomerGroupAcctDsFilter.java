/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class CustomerGroupAcctDsFilter extends AbstractAuditableDsFilter {

    private Long custGroupId;

    private Long custGroupId_From;
    private Long custGroupId_To;

    private String custGroup;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long salesAccountId;

    private Long salesAccountId_From;
    private Long salesAccountId_To;

    private String salesAccount;

    private Long prepayAccountId;

    private Long prepayAccountId_From;
    private Long prepayAccountId_To;

    private String prepayAccount;

    public Long getCustGroupId() {
        return this.custGroupId;
    }

    public Long getCustGroupId_From() {
        return this.custGroupId_From;
    }

    public Long getCustGroupId_To() {
        return this.custGroupId_To;
    }

    public void setCustGroupId(Long custGroupId) {
        this.custGroupId = custGroupId;
    }

    public void setCustGroupId_From(Long custGroupId_From) {
        this.custGroupId_From = custGroupId_From;
    }

    public void setCustGroupId_To(Long custGroupId_To) {
        this.custGroupId_To = custGroupId_To;
    }

    public String getCustGroup() {
        return this.custGroup;
    }

    public void setCustGroup(String custGroup) {
        this.custGroup = custGroup;
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

}
