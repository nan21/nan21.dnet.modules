/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

public interface ISysParamService extends IEntityService<SysParam> {

    public SysParam findByCode(Long clientId, String code);

    public SysParam findByName(Long clientId, String name);

}
