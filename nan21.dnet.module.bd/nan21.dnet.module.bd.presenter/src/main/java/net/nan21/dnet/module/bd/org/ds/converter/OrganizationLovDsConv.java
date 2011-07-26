/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.ds.model.OrganizationLovDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

public class OrganizationLovDsConv extends
        AbstractDsConverter<OrganizationLovDs, Organization> implements
        IDsConverter<OrganizationLovDs, Organization> {

    protected void modelToEntityAttributes(OrganizationLovDs ds, Organization e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OrganizationLovDs ds, Organization e)
            throws Exception {
    }

    @Override
    public void entityToModel(Organization e, OrganizationLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
