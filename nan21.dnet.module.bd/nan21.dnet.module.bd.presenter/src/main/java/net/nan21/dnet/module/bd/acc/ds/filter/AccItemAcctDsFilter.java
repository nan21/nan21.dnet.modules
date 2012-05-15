/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AccItemAcctDsFilter extends AbstractAuditableDsFilter {

    private Long accItemId;

    private Long accItemId_From;
    private Long accItemId_To;

    private String accItem;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long crAccountId;

    private Long crAccountId_From;
    private Long crAccountId_To;

    private String crAccount;

    private Long dbAccountId;

    private Long dbAccountId_From;
    private Long dbAccountId_To;

    private String dbAccount;

    public Long getAccItemId() {
        return this.accItemId;
    }

    public Long getAccItemId_From() {
        return this.accItemId_From;
    }

    public Long getAccItemId_To() {
        return this.accItemId_To;
    }

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
    }

    public void setAccItemId_From(Long accItemId_From) {
        this.accItemId_From = accItemId_From;
    }

    public void setAccItemId_To(Long accItemId_To) {
        this.accItemId_To = accItemId_To;
    }

    public String getAccItem() {
        return this.accItem;
    }

    public void setAccItem(String accItem) {
        this.accItem = accItem;
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

    public Long getCrAccountId() {
        return this.crAccountId;
    }

    public Long getCrAccountId_From() {
        return this.crAccountId_From;
    }

    public Long getCrAccountId_To() {
        return this.crAccountId_To;
    }

    public void setCrAccountId(Long crAccountId) {
        this.crAccountId = crAccountId;
    }

    public void setCrAccountId_From(Long crAccountId_From) {
        this.crAccountId_From = crAccountId_From;
    }

    public void setCrAccountId_To(Long crAccountId_To) {
        this.crAccountId_To = crAccountId_To;
    }

    public String getCrAccount() {
        return this.crAccount;
    }

    public void setCrAccount(String crAccount) {
        this.crAccount = crAccount;
    }

    public Long getDbAccountId() {
        return this.dbAccountId;
    }

    public Long getDbAccountId_From() {
        return this.dbAccountId_From;
    }

    public Long getDbAccountId_To() {
        return this.dbAccountId_To;
    }

    public void setDbAccountId(Long dbAccountId) {
        this.dbAccountId = dbAccountId;
    }

    public void setDbAccountId_From(Long dbAccountId_From) {
        this.dbAccountId_From = dbAccountId_From;
    }

    public void setDbAccountId_To(Long dbAccountId_To) {
        this.dbAccountId_To = dbAccountId_To;
    }

    public String getDbAccount() {
        return this.dbAccount;
    }

    public void setDbAccount(String dbAccount) {
        this.dbAccount = dbAccount;
    }

}
