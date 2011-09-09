/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.AccessControlLovDs;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

public class AccessControlLovDsConv extends
        AbstractDsConverter<AccessControlLovDs, AccessControl> implements
        IDsConverter<AccessControlLovDs, AccessControl> {

    protected void modelToEntityAttributes(AccessControlLovDs ds,
            AccessControl e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(AccessControlLovDs ds,
            AccessControl e) throws Exception {
    }

    @Override
    public void entityToModel(AccessControl e, AccessControlLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
