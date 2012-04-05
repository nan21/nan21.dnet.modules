/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

public interface ISysDsEventService extends IEntityService<SysDsEvent> {

    public SysDsEvent findByName(SysDataSource dataSource, String eventType);

    public SysDsEvent findByName(Long dataSourceId, String eventType);

    public List<SysDsEvent> findByDataSource(SysDataSource dataSource);

    public List<SysDsEvent> findByDataSourceId(Long dataSourceId);

}
