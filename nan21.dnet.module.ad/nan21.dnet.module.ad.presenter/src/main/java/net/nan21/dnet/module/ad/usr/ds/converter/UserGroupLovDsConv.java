/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserGroupLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

public class UserGroupLovDsConv extends
        AbstractDsConverter<UserGroupLovDs, UserGroup> implements
        IDsConverter<UserGroupLovDs, UserGroup> {

    protected void modelToEntityAttributes(UserGroupLovDs ds, UserGroup e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UserGroupLovDs ds, UserGroup e)
            throws Exception {
    }

    @Override
    public void entityToModel(UserGroup e, UserGroupLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
