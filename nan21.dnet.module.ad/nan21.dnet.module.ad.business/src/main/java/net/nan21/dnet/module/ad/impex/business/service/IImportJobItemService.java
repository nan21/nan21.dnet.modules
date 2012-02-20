/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

public interface IImportJobItemService extends IEntityService<ImportJobItem> {

    public ImportJobItem findByJob_map(ImportJob job, ImportMap map);

    public ImportJobItem findByJob_map(Long jobId, Long mapId);

    public List<ImportJobItem> findByJob(ImportJob job);

    public List<ImportJobItem> findByJobId(Long jobId);

    public List<ImportJobItem> findByMap(ImportMap map);

    public List<ImportJobItem> findByMapId(Long mapId);

}
