/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

public interface IAssignableTypeService extends IEntityService<AssignableType> {

    public AssignableType findByName(String name);

}
