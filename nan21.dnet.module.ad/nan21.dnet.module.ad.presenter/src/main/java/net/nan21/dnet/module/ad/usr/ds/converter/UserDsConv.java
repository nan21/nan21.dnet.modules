/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserDs;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserDsConv extends AbstractDsConverter<UserDs, User> implements
        IDsConverter<UserDs, User> {

    protected void modelToEntityAttributes(UserDs ds, User e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setLocked(ds.getLocked());
        e.setAccountType(ds.getAccountType());
    }

    protected void modelToEntityReferences(UserDs ds, User e) throws Exception {
    }

    @Override
    public void entityToModel(User e, UserDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setLocked(e.getLocked());
        ds.setAccountType(e.getAccountType());
    }

}
