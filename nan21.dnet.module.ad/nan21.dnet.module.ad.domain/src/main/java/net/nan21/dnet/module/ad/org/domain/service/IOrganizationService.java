/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.org.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationType;

import net.nan21.dnet.module.ad.org.domain.entity.Organization;

public interface IOrganizationService extends IEntityService<Organization> {

    public Organization findByCode(Long clientId, String code);

    public Organization findByName(Long clientId, String name);

    public List<Organization> findByType(OrganizationType type);

    public List<Organization> findByTypeId(Long typeId);

}
