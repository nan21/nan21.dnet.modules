/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

public interface IOrganizationTypeService extends
        IEntityService<OrganizationType> {

    public OrganizationType findByName(String name);

}
