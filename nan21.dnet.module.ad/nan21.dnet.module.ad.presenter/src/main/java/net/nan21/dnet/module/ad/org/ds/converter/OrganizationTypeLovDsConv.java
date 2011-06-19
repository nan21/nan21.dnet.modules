/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.org.ds.model.OrganizationTypeLovDs;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationType;

public class OrganizationTypeLovDsConv extends
        AbstractDsConverter<OrganizationTypeLovDs, OrganizationType> implements
        IDsConverter<OrganizationTypeLovDs, OrganizationType> {

    protected void modelToEntityAttributes(OrganizationTypeLovDs ds,
            OrganizationType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OrganizationTypeLovDs ds,
            OrganizationType e) throws Exception {
    }

    @Override
    public void entityToModel(OrganizationType e, OrganizationTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
