/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccBalance;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccBalance.class)
public class AccBalanceDs extends AbstractAuditableDs<AccBalance> {

    public static final String fACCOUNT = "account";
    public static final String fAMOUNT = "amount";

    @DsField()
    private String account;

    @DsField()
    private Float amount;

    public AccBalanceDs() {
        super();
    }

    public AccBalanceDs(AccBalance e) {
        super(e);
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

}
