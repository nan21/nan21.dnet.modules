/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserTypeLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

public class UserTypeLovDsConv extends
        AbstractDsConverter<UserTypeLovDs, UserType> implements
        IDsConverter<UserTypeLovDs, UserType> {

    protected void modelToEntityAttributes(UserTypeLovDs ds, UserType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UserTypeLovDs ds, UserType e)
            throws Exception {
    }

    @Override
    public void entityToModel(UserType e, UserTypeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
