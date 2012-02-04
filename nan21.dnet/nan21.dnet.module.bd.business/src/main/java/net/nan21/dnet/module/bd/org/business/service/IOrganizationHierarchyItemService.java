/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

public interface IOrganizationHierarchyItemService extends
        IEntityService<OrganizationHierarchyItem> {

    public List<OrganizationHierarchyItem> findByHierarchy(
            OrganizationHierarchy hierarchy);

    public List<OrganizationHierarchyItem> findByHierarchyId(Long hierarchyId);

    public List<OrganizationHierarchyItem> findByOrganization(
            Organization organization);

    public List<OrganizationHierarchyItem> findByOrganizationId(
            Long organizationId);

    public List<OrganizationHierarchyItem> findByParent(Organization parent);

    public List<OrganizationHierarchyItem> findByParentId(Long parentId);

}
