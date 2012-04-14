/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Account.class, sort = { @SortField(field = AccountDs.fNAME) })
public class AccountDs extends AbstractTypeWithCodeDs<Account> {

    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fACCGROUPID = "accGroupId";
    public static final String fACCGROUP = "accGroup";
    public static final String fSIGN = "sign";
    public static final String fSUMMARY = "summary";

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "accGroup.id")
    private Long accGroupId;

    @DsField(join = "left", path = "accGroup.code")
    private String accGroup;

    @DsField()
    private String sign;

    @DsField()
    private Boolean summary;

    public AccountDs() {
        super();
    }

    public AccountDs(Account e) {
        super(e);
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

    public Long getAccGroupId() {
        return this.accGroupId;
    }

    public void setAccGroupId(Long accGroupId) {
        this.accGroupId = accGroupId;
    }

    public String getAccGroup() {
        return this.accGroup;
    }

    public void setAccGroup(String accGroup) {
        this.accGroup = accGroup;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

}
