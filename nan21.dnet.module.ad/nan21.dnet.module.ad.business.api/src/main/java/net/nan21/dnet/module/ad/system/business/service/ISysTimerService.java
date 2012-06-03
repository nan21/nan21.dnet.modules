/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

public interface ISysTimerService extends IEntityService<SysTimer> {

    public SysTimer findByName(SysJobCtx jobCtx, String name);

    public SysTimer findByName(Long jobCtxId, String name);

    public List<SysTimer> findByJobCtx(SysJobCtx jobCtx);

    public List<SysTimer> findByJobCtxId(Long jobCtxId);

}
