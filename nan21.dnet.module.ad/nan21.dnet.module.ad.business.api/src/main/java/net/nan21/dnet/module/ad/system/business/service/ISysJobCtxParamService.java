/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtxParam;

public interface ISysJobCtxParamService extends IEntityService<SysJobCtxParam> {

    public List<SysJobCtxParam> findByJobCtx(SysJobCtx jobCtx);

    public List<SysJobCtxParam> findByJobCtxId(Long jobCtxId);

    public List<SysJobCtxParam> findByJobParam(SysJobParam jobParam);

    public List<SysJobCtxParam> findByJobParamId(Long jobParamId);

}
