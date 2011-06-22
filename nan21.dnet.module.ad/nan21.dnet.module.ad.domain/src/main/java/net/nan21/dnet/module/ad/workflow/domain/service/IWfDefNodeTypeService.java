/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeType;

public interface IWfDefNodeTypeService extends IEntityService<WfDefNodeType> {

    public WfDefNodeType findByName(Long clientId, String name);

}
