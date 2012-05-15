/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.bd.acc.domain.entity.AccItemAcct;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccItemAcct.class)
public class AccItemAcctDs extends AbstractAuditableDs<AccItemAcct> {

    public static final String fACCITEMID = "accItemId";
    public static final String fACCITEM = "accItem";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fCRACCOUNTID = "crAccountId";
    public static final String fCRACCOUNT = "crAccount";
    public static final String fDBACCOUNTID = "dbAccountId";
    public static final String fDBACCOUNT = "dbAccount";

    @DsField(join = "left", path = "accItem.id")
    private Long accItemId;

    @DsField(join = "left", path = "accItem.name")
    private String accItem;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "crAccount.id")
    private Long crAccountId;

    @DsField(join = "left", path = "crAccount.code")
    private String crAccount;

    @DsField(join = "left", path = "dbAccount.id")
    private Long dbAccountId;

    @DsField(join = "left", path = "dbAccount.code")
    private String dbAccount;

    public AccItemAcctDs() {
        super();
    }

    public AccItemAcctDs(AccItemAcct e) {
        super(e);
    }

    public Long getAccItemId() {
        return this.accItemId;
    }

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
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

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
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

    public void setCrAccountId(Long crAccountId) {
        this.crAccountId = crAccountId;
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

    public void setDbAccountId(Long dbAccountId) {
        this.dbAccountId = dbAccountId;
    }

    public String getDbAccount() {
        return this.dbAccount;
    }

    public void setDbAccount(String dbAccount) {
        this.dbAccount = dbAccount;
    }

}
