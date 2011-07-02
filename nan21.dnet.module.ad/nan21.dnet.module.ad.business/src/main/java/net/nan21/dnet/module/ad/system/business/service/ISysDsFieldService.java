/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;

public interface ISysDsFieldService extends IEntityService<SysDsField> {

    public SysDsField findByName(Long clientId, SysDataSource dataSource,
            String name);

    public SysDsField findByName(Long clientId, Long dataSourceId, String name);

    public List<SysDsField> findByDataSource(SysDataSource dataSource);

    public List<SysDsField> findByDataSourceId(Long dataSourceId);

}
