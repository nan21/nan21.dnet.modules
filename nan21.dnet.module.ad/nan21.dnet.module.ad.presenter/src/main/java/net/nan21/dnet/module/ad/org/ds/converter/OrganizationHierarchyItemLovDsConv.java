/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.org.ds.model.OrganizationHierarchyItemLovDs;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationHierarchyItem;

public class OrganizationHierarchyItemLovDsConv
        extends
        AbstractDsConverter<OrganizationHierarchyItemLovDs, OrganizationHierarchyItem>
        implements
        IDsConverter<OrganizationHierarchyItemLovDs, OrganizationHierarchyItem> {

    protected void modelToEntityAttributes(OrganizationHierarchyItemLovDs ds,
            OrganizationHierarchyItem e) throws Exception {
        e.setClientId(ds.getClientId());
    }

    protected void modelToEntityReferences(OrganizationHierarchyItemLovDs ds,
            OrganizationHierarchyItem e) throws Exception {
    }

    @Override
    public void entityToModel(OrganizationHierarchyItem e,
            OrganizationHierarchyItemLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setHierarchyId(((e.getHierarchy() != null)) ? e.getHierarchy()
                .getId() : null);
        ds.setOrganizationId(((e.getOrganization() != null)) ? e
                .getOrganization().getId() : null);
        ds.setOrganizationCode(((e.getOrganization() != null)) ? e
                .getOrganization().getCode() : null);
    }

}
