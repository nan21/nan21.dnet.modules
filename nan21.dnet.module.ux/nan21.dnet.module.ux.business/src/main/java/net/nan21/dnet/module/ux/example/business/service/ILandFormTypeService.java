/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ux.example.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ux.example.domain.entity.LandFormType;

public interface ILandFormTypeService extends IEntityService<LandFormType> {

    public LandFormType findByName(Long clientId, String name);

}
