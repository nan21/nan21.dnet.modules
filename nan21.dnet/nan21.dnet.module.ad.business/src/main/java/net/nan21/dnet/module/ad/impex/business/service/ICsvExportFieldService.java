/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

public interface ICsvExportFieldService extends IEntityService<CsvExportField> {

    public List<CsvExportField> findByCsvExport(CsvExport csvExport);

    public List<CsvExportField> findByCsvExportId(Long csvExportId);

}
