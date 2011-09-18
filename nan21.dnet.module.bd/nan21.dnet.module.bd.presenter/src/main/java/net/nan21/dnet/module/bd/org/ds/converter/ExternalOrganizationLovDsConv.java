/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.ds.model.ExternalOrganizationLovDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

public class ExternalOrganizationLovDsConv extends
        AbstractDsConverter<ExternalOrganizationLovDs, Organization> implements
        IDsConverter<ExternalOrganizationLovDs, Organization> {

    protected void modelToEntityAttributes(ExternalOrganizationLovDs ds,
            Organization e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ExternalOrganizationLovDs ds,
            Organization e) throws Exception {
    }

    @Override
    public void entityToModel(Organization e, ExternalOrganizationLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setExternal(((e.getType() != null)) ? e.getType().getExternal()
                : null);
    }

}
