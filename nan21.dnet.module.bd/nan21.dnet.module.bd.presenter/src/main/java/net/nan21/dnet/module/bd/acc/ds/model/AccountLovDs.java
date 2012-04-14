/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Account.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AccountLovDs.fCODE) })
public class AccountLovDs extends AbstractTypeWithCodeLov<Account> {

    public AccountLovDs() {
        super();
    }

    public AccountLovDs(Account e) {
        super(e);
    }

}
