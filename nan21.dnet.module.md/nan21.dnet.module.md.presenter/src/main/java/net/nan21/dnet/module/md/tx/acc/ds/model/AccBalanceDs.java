/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.acc.domain.entity.AccBalance;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccBalance.class)
public class AccBalanceDs extends AbstractAuditableDs<AccBalance> {

    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fPERIODID = "periodId";
    public static final String fPERIOD = "period";
    public static final String fACCOUNT = "account";
    public static final String fAMOUNT = "amount";
    public static final String fINITIALAMOUNT = "initialAmount";

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "period.id")
    private Long periodId;

    @DsField(join = "left", path = "period.code")
    private String period;

    @DsField()
    private String account;

    @DsField()
    private Float amount;

    @DsField()
    private Float initialAmount;

    public AccBalanceDs() {
        super();
    }

    public AccBalanceDs(AccBalance e) {
        super(e);
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
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

    public Long getPeriodId() {
        return this.periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getInitialAmount() {
        return this.initialAmount;
    }

    public void setInitialAmount(Float initialAmount) {
        this.initialAmount = initialAmount;
    }

}
