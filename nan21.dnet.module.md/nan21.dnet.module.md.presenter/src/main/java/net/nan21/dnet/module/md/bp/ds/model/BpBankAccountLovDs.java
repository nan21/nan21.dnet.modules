/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;

import net.nan21.dnet.module.md.bp.domain.entity.BpBankAccount;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = BpBankAccount.class)
public class BpBankAccountLovDs extends AbstractAuditableLov<BpBankAccount> {

    public static final String fACCOUNTNO = "accountNo";

    @DsField()
    private String accountNo;

    public BpBankAccountLovDs() {
        super();
    }

    public BpBankAccountLovDs(BpBankAccount e) {
        super(e);
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

}
