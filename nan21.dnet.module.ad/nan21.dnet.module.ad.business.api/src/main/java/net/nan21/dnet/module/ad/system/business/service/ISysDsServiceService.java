/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

public interface ISysDsServiceService extends IEntityService<SysDsService> {

    public SysDsService findByName(SysDataSource dataSource, String name);

    public SysDsService findByName(Long dataSourceId, String name);

    public List<SysDsService> findByDataSource(SysDataSource dataSource);

    public List<SysDsService> findByDataSourceId(Long dataSourceId);

}
