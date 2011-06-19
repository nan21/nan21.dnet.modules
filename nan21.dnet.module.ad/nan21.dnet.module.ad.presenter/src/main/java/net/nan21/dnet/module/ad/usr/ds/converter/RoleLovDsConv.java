/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.RoleLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

public class RoleLovDsConv extends AbstractDsConverter<RoleLovDs, Role>
        implements IDsConverter<RoleLovDs, Role> {

    protected void modelToEntityAttributes(RoleLovDs ds, Role e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(RoleLovDs ds, Role e)
            throws Exception {
    }

    @Override
    public void entityToModel(Role e, RoleLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
