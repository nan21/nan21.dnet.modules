/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

public interface ICsvExportService extends IEntityService<CsvExport> {

    public CsvExport findByName(String name);

    public List<CsvExport> findByFields(CsvExportField fields);

    public List<CsvExport> findByFieldsId(Long fieldsId);

}
