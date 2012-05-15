/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CustomerGroupAcct.class)
public class CustomerGroupAcctDs extends AbstractAuditableDs<CustomerGroupAcct> {

    public static final String fCUSTGROUPID = "custGroupId";
    public static final String fCUSTGROUP = "custGroup";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fSALESACCOUNTID = "salesAccountId";
    public static final String fSALESACCOUNT = "salesAccount";
    public static final String fPREPAYACCOUNTID = "prepayAccountId";
    public static final String fPREPAYACCOUNT = "prepayAccount";

    @DsField(join = "left", path = "custGroup.id")
    private Long custGroupId;

    @DsField(join = "left", path = "custGroup.code")
    private String custGroup;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "salesAccount.id")
    private Long salesAccountId;

    @DsField(join = "left", path = "salesAccount.code")
    private String salesAccount;

    @DsField(join = "left", path = "prepayAccount.id")
    private Long prepayAccountId;

    @DsField(join = "left", path = "prepayAccount.code")
    private String prepayAccount;

    public CustomerGroupAcctDs() {
        super();
    }

    public CustomerGroupAcctDs(CustomerGroupAcct e) {
        super(e);
    }

    public Long getCustGroupId() {
        return this.custGroupId;
    }

    public void setCustGroupId(Long custGroupId) {
        this.custGroupId = custGroupId;
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

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
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

    public void setSalesAccountId(Long salesAccountId) {
        this.salesAccountId = salesAccountId;
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

    public void setPrepayAccountId(Long prepayAccountId) {
        this.prepayAccountId = prepayAccountId;
    }

    public String getPrepayAccount() {
        return this.prepayAccount;
    }

    public void setPrepayAccount(String prepayAccount) {
        this.prepayAccount = prepayAccount;
    }

}
