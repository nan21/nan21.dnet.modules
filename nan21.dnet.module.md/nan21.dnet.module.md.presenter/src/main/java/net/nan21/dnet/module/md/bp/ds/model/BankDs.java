/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.md.bp.domain.entity.Bank;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Bank.class, sort = { @SortField(field = BankDs.fNAME) })
public class BankDs extends AbstractTypeWithCodeDs<Bank> {

    public static final String fSWIFTCODE = "swiftCode";

    @DsField()
    private String swiftCode;

    public BankDs() {
        super();
    }

    public BankDs(Bank e) {
        super(e);
    }

    public String getSwiftCode() {
        return this.swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

}
