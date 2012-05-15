/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

public interface ICsvExportSortService extends IEntityService<CsvExportSort> {

    public List<CsvExportSort> findByCsvExport(CsvExport csvExport);

    public List<CsvExportSort> findByCsvExportId(Long csvExportId);

}
