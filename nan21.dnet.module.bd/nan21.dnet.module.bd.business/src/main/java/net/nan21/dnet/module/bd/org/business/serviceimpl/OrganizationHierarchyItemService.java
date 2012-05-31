/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationHierarchyItemService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

public class OrganizationHierarchyItemService extends
        AbstractEntityService<OrganizationHierarchyItem> implements
        IOrganizationHierarchyItemService {

    public OrganizationHierarchyItemService() {
        super();
    }

    public OrganizationHierarchyItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OrganizationHierarchyItem> getEntityClass() {
        return OrganizationHierarchyItem.class;
    }

    public List<OrganizationHierarchyItem> findByHierarchy(
            OrganizationHierarchy hierarchy) {
        return this.findByHierarchyId(hierarchy.getId());
    }

    public List<OrganizationHierarchyItem> findByHierarchyId(Long hierarchyId) {
        return (List<OrganizationHierarchyItem>) this.em
                .createQuery(
                        "select e from OrganizationHierarchyItem e where e.clientId = :pClientId and e.hierarchy.id = :pHierarchyId",
                        OrganizationHierarchyItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pHierarchyId", hierarchyId).getResultList();
    }

    public List<OrganizationHierarchyItem> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<OrganizationHierarchyItem> findByOrgId(Long orgId) {
        return (List<OrganizationHierarchyItem>) this.em
                .createQuery(
                        "select e from OrganizationHierarchyItem e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        OrganizationHierarchyItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<OrganizationHierarchyItem> findByParent(Organization parent) {
        return this.findByParentId(parent.getId());
    }

    public List<OrganizationHierarchyItem> findByParentId(Long parentId) {
        return (List<OrganizationHierarchyItem>) this.em
                .createQuery(
                        "select e from OrganizationHierarchyItem e where e.clientId = :pClientId and e.parent.id = :pParentId",
                        OrganizationHierarchyItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pParentId", parentId).getResultList();
    }

}
