/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

public interface ISysJobParamService extends IEntityService<SysJobParam> {

    public SysJobParam findByName(SysJob job, String name);

    public SysJobParam findByName(Long jobId, String name);

    public List<SysJobParam> findByJob(SysJob job);

    public List<SysJobParam> findByJobId(Long jobId);

}
