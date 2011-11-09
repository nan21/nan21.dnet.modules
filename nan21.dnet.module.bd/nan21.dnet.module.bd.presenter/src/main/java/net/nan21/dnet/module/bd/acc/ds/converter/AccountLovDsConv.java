/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.acc.ds.model.AccountLovDs;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;

public class AccountLovDsConv extends
        AbstractDsConverter<AccountLovDs, Account> implements
        IDsConverter<AccountLovDs, Account> {

    protected void modelToEntityAttributes(AccountLovDs ds, Account e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AccountLovDs ds, Account e)
            throws Exception {
    }

    @Override
    public void entityToModel(Account e, AccountLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
