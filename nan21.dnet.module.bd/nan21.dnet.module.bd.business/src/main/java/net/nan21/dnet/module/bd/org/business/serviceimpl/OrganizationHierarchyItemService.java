/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.serviceimpl;

import java.util.List;
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
                        "select e from OrganizationHierarchyItem e where e.hierarchy.id = :pHierarchyId",
                        OrganizationHierarchyItem.class)
                .setParameter("pHierarchyId", hierarchyId).getResultList();
    }

    public List<OrganizationHierarchyItem> findByOrganization(
            Organization organization) {
        return this.findByOrganizationId(organization.getId());
    }

    public List<OrganizationHierarchyItem> findByOrganizationId(
            Long organizationId) {
        return (List<OrganizationHierarchyItem>) this.em
                .createQuery(
                        "select e from OrganizationHierarchyItem e where e.organization.id = :pOrganizationId",
                        OrganizationHierarchyItem.class)
                .setParameter("pOrganizationId", organizationId)
                .getResultList();
    }

    public List<OrganizationHierarchyItem> findByParent(Organization parent) {
        return this.findByParentId(parent.getId());
    }

    public List<OrganizationHierarchyItem> findByParentId(Long parentId) {
        return (List<OrganizationHierarchyItem>) this.em
                .createQuery(
                        "select e from OrganizationHierarchyItem e where e.parent.id = :pParentId",
                        OrganizationHierarchyItem.class)
                .setParameter("pParentId", parentId).getResultList();
    }

}
