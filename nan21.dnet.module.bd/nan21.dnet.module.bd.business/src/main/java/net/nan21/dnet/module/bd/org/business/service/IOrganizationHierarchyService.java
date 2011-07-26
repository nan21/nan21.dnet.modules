/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;

public interface IOrganizationHierarchyService extends
        IEntityService<OrganizationHierarchy> {

    public OrganizationHierarchy findByName(Long clientId, String name);

}
