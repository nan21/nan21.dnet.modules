/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public interface ISysDataSourceService extends IEntityService<SysDataSource> {

    public SysDataSource findByName(String name);

    public SysDataSource findByModel(String model);

    public List<SysDataSource> findByFields(SysDsField fields);

    public List<SysDataSource> findByFieldsId(Long fieldsId);

    public List<SysDataSource> findByServiceMethods(SysDsService serviceMethods);

    public List<SysDataSource> findByServiceMethodsId(Long serviceMethodsId);

}
