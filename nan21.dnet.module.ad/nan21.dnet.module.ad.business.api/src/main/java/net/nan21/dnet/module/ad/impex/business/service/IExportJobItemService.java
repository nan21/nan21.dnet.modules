/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

public interface IExportJobItemService extends IEntityService<ExportJobItem> {

    public ExportJobItem findByJob_map(ExportJob job, ExportMap map);

    public ExportJobItem findByJob_map(Long jobId, Long mapId);

    public List<ExportJobItem> findByJob(ExportJob job);

    public List<ExportJobItem> findByJobId(Long jobId);

    public List<ExportJobItem> findByMap(ExportMap map);

    public List<ExportJobItem> findByMapId(Long mapId);

}
