/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

import net.nan21.dnet.module.bd.org.domain.entity.Organization;

public interface IOrganizationService extends IEntityService<Organization> {

    public Organization findByCode(String code);

    public Organization findByName(String name);

    public List<Organization> findByType(OrganizationType type);

    public List<Organization> findByTypeId(Long typeId);

}
