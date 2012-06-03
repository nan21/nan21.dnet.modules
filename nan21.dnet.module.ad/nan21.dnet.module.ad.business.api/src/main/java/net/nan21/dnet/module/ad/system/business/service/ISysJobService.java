/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

public interface ISysJobService extends IEntityService<SysJob> {

    public SysJob findByName(String name);

    public SysJob findByJclass(String javaClass);

}
