/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.org.ds.model.LegalEntityOrganizationLovDs;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;

public class LegalEntityOrganizationLovDsConv extends
        AbstractDsConverter<LegalEntityOrganizationLovDs, Organization>
        implements IDsConverter<LegalEntityOrganizationLovDs, Organization> {

    protected void modelToEntityAttributes(LegalEntityOrganizationLovDs ds,
            Organization e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(LegalEntityOrganizationLovDs ds,
            Organization e) throws Exception {
    }

    @Override
    public void entityToModel(Organization e, LegalEntityOrganizationLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setLegalEntity(((e.getType() != null)) ? e.getType()
                .getLegalEntity() : null);
    }

}
