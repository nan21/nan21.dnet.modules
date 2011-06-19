/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.org.ds.model.OrganizationHierarchyLovDs;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationHierarchy;

public class OrganizationHierarchyLovDsConv extends
        AbstractDsConverter<OrganizationHierarchyLovDs, OrganizationHierarchy>
        implements
        IDsConverter<OrganizationHierarchyLovDs, OrganizationHierarchy> {

    protected void modelToEntityAttributes(OrganizationHierarchyLovDs ds,
            OrganizationHierarchy e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setStartDate(ds.getStartDate());
        e.setEndDate(ds.getEndDate());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(OrganizationHierarchyLovDs ds,
            OrganizationHierarchy e) throws Exception {
    }

    @Override
    public void entityToModel(OrganizationHierarchy e,
            OrganizationHierarchyLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setStartDate(e.getStartDate());
        ds.setEndDate(e.getEndDate());
        ds.setActive(e.getActive());
    }

}
