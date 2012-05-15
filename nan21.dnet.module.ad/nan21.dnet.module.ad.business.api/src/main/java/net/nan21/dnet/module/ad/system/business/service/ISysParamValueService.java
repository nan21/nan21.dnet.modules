/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

public interface ISysParamValueService extends IEntityService<SysParamValue> {

    public List<SysParamValue> findBySysParam(SysParam sysParam);

    public List<SysParamValue> findBySysParamId(Long sysParamId);

}
