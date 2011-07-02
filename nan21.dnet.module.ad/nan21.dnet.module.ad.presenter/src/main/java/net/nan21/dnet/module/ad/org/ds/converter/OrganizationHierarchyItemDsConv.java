/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.org.business.service.IOrganizationHierarchyService;
import net.nan21.dnet.module.ad.org.business.service.IOrganizationService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationHierarchy;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.org.ds.model.OrganizationHierarchyItemDs;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationHierarchyItem;

public class OrganizationHierarchyItemDsConv
        extends
        AbstractDsConverter<OrganizationHierarchyItemDs, OrganizationHierarchyItem>
        implements
        IDsConverter<OrganizationHierarchyItemDs, OrganizationHierarchyItem> {

    protected void modelToEntityAttributes(OrganizationHierarchyItemDs ds,
            OrganizationHierarchyItem e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(OrganizationHierarchyItemDs ds,
            OrganizationHierarchyItem e) throws Exception {

        if (ds.getHierarchyId() != null) {
            if (e.getHierarchy() == null
                    || !e.getHierarchy().getId().equals(ds.getHierarchyId())) {
                e.setHierarchy((OrganizationHierarchy) this.em.getReference(
                        OrganizationHierarchy.class, ds.getHierarchyId()));
            }
        } else {
            this.lookup_hierarchy_OrganizationHierarchy(ds, e);
        }
        if (ds.getOrganizationId() != null) {
            if (e.getOrganization() == null
                    || !e.getOrganization().getId()
                            .equals(ds.getOrganizationId())) {
                e.setOrganization((Organization) this.em.getReference(
                        Organization.class, ds.getOrganizationId()));
            }
        } else {
            this.lookup_organization_Organization(ds, e);
        }
        if (ds.getParentId() != null) {
            if (e.getParent() == null
                    || !e.getParent().getId().equals(ds.getParentId())) {
                e.setParent((Organization) this.em.getReference(
                        Organization.class, ds.getParentId()));
            }
        } else {
            this.lookup_parent_Organization(ds, e);
        }
    }

    protected void lookup_hierarchy_OrganizationHierarchy(
            OrganizationHierarchyItemDs ds, OrganizationHierarchyItem e)
            throws Exception {
        OrganizationHierarchy x = null;
        try {
            x = ((IOrganizationHierarchyService) getService(IOrganizationHierarchyService.class))
                    .findByName(ds.getClientId(), ds.getHierarchy());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setHierarchy(x);
    }

    protected void lookup_organization_Organization(
            OrganizationHierarchyItemDs ds, OrganizationHierarchyItem e)
            throws Exception {
        Organization x = null;
        try {
            x = ((IOrganizationService) getService(IOrganizationService.class))
                    .findByCode(ds.getClientId(), ds.getOrganizationCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setOrganization(x);
    }

    protected void lookup_parent_Organization(OrganizationHierarchyItemDs ds,
            OrganizationHierarchyItem e) throws Exception {
        Organization x = null;
        try {
            x = ((IOrganizationService) getService(IOrganizationService.class))
                    .findByCode(ds.getClientId(), ds.getParentCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setParent(x);
    }

    @Override
    public void entityToModel(OrganizationHierarchyItem e,
            OrganizationHierarchyItemDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setHierarchyId(((e.getHierarchy() != null)) ? e.getHierarchy()
                .getId() : null);
        ds.setHierarchy(((e.getHierarchy() != null)) ? e.getHierarchy()
                .getName() : null);
        ds.setOrganizationId(((e.getOrganization() != null)) ? e
                .getOrganization().getId() : null);
        ds.setOrganizationCode(((e.getOrganization() != null)) ? e
                .getOrganization().getCode() : null);
        ds.setParentId(((e.getParent() != null)) ? e.getParent().getId() : null);
        ds.setParentCode(((e.getParent() != null)) ? e.getParent().getCode()
                : null);
    }

}
