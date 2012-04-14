/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccountGroup.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AccountGroupLovDs.fCODE) })
public class AccountGroupLovDs extends AbstractTypeWithCodeLov<AccountGroup> {

    public AccountGroupLovDs() {
        super();
    }

    public AccountGroupLovDs(AccountGroup e) {
        super(e);
    }

}
