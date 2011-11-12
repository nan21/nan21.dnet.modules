/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;

public interface IIssueLinkTypeService extends IEntityService<IssueLinkType> {

    public IssueLinkType findByName(Long clientId, String name);

}
