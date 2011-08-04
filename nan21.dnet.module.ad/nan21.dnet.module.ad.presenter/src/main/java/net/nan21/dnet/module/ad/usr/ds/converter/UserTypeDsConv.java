/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.UserTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

public class UserTypeDsConv extends AbstractDsConverter<UserTypeDs, UserType>
        implements IDsConverter<UserTypeDs, UserType> {

    protected void modelToEntityAttributes(UserTypeDs ds, UserType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setEmployeeAccount(ds.getEmployeeAccount());
        e.setBpAccount(ds.getBpAccount());
    }

    protected void modelToEntityReferences(UserTypeDs ds, UserType e)
            throws Exception {
    }

    @Override
    public void entityToModel(UserType e, UserTypeDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setEmployeeAccount(e.getEmployeeAccount());
        ds.setBpAccount(e.getBpAccount());
    }

}
