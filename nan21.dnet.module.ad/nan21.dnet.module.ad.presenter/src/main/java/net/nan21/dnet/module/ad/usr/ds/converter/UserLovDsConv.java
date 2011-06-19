/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserLovDsConv extends AbstractDsConverter<UserLovDs, User>
        implements IDsConverter<UserLovDs, User> {

    protected void modelToEntityAttributes(UserLovDs ds, User e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UserLovDs ds, User e)
            throws Exception {
    }

    @Override
    public void entityToModel(User e, UserLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
