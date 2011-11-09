/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.acc.ds.model.AccountGroupLovDs;
import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;

public class AccountGroupLovDsConv extends
        AbstractDsConverter<AccountGroupLovDs, AccountGroup> implements
        IDsConverter<AccountGroupLovDs, AccountGroup> {

    protected void modelToEntityAttributes(AccountGroupLovDs ds, AccountGroup e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AccountGroupLovDs ds, AccountGroup e)
            throws Exception {
    }

    @Override
    public void entityToModel(AccountGroup e, AccountGroupLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
