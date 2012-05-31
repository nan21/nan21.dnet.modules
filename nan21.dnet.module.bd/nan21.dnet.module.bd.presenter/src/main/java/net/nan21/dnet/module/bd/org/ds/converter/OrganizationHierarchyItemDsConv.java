/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationHierarchyService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

public class OrganizationHierarchyItemDsConv
        extends
        AbstractDsConverter<OrganizationHierarchyItemDs, OrganizationHierarchyItem>
        implements
        IDsConverter<OrganizationHierarchyItemDs, OrganizationHierarchyItem> {

    @Override
    protected void modelToEntityReferences(OrganizationHierarchyItemDs ds,
            OrganizationHierarchyItem e, boolean isInsert) throws Exception {

        if (ds.getHierarchyId() != null) {
            if (e.getHierarchy() == null
                    || !e.getHierarchy().getId().equals(ds.getHierarchyId())) {
                e.setHierarchy((OrganizationHierarchy) this.em.find(
                        OrganizationHierarchy.class, ds.getHierarchyId()));
            }
        } else {
            this.lookup_hierarchy_OrganizationHierarchy(ds, e);
        }

        if (ds.getOrgId() != null) {
            if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
                e.setOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_org_Organization(ds, e);
        }

        if (ds.getParentId() != null) {
            if (e.getParent() == null
                    || !e.getParent().getId().equals(ds.getParentId())) {
                e.setParent((Organization) this.em.find(Organization.class,
                        ds.getParentId()));
            }
        } else {
            this.lookup_parent_Organization(ds, e);
        }

    }

    protected void lookup_hierarchy_OrganizationHierarchy(
            OrganizationHierarchyItemDs ds, OrganizationHierarchyItem e)
            throws Exception {
        if (ds.getHierarchy() != null && !ds.getHierarchy().equals("")) {
            OrganizationHierarchy x = null;
            try {
                x = ((IOrganizationHierarchyService) findEntityService(OrganizationHierarchy.class))
                        .findByName(ds.getHierarchy());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `OrganizationHierarchy` reference:  `hierarchy` = "
                                + ds.getHierarchy() + "  ");
            }
            e.setHierarchy(x);

        } else {
            e.setHierarchy(null);
        }
    }

    protected void lookup_org_Organization(OrganizationHierarchyItemDs ds,
            OrganizationHierarchyItem e) throws Exception {
        if (ds.getOrg() != null && !ds.getOrg().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getOrg());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `org` = "
                                + ds.getOrg() + "  ");
            }
            e.setOrg(x);

        } else {
            e.setOrg(null);
        }
    }

    protected void lookup_parent_Organization(OrganizationHierarchyItemDs ds,
            OrganizationHierarchyItem e) throws Exception {
        if (ds.getParentCode() != null && !ds.getParentCode().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getParentCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `parentCode` = "
                                + ds.getParentCode() + "  ");
            }
            e.setParent(x);

        } else {
            e.setParent(null);
        }
    }

}
