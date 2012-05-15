/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

public interface IExportMapItemService extends IEntityService<ExportMapItem> {

    public List<ExportMapItem> findByExportMap(ExportMap exportMap);

    public List<ExportMapItem> findByExportMapId(Long exportMapId);

    public List<ExportMapItem> findByCsvExport(CsvExport csvExport);

    public List<ExportMapItem> findByCsvExportId(Long csvExportId);

}
