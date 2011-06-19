/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.org.ds.model.OrganizationHierarchyDs;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationHierarchy;

public class OrganizationHierarchyDsConv extends
        AbstractDsConverter<OrganizationHierarchyDs, OrganizationHierarchy>
        implements IDsConverter<OrganizationHierarchyDs, OrganizationHierarchy> {

    protected void modelToEntityAttributes(OrganizationHierarchyDs ds,
            OrganizationHierarchy e) throws Exception {
        e.setName(ds.getName());
        e.setStartDate(ds.getStartDate());
        e.setEndDate(ds.getEndDate());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(OrganizationHierarchyDs ds,
            OrganizationHierarchy e) throws Exception {
    }

    @Override
    public void entityToModel(OrganizationHierarchy e,
            OrganizationHierarchyDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setStartDate(e.getStartDate());
        ds.setEndDate(e.getEndDate());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
    }

}
