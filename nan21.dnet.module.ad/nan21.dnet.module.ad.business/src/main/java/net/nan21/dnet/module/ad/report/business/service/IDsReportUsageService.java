/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;

import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;

public interface IDsReportUsageService extends IEntityService<DsReportUsage> {

    public List<DsReportUsage> findByDsReport(DsReport dsReport);

    public List<DsReportUsage> findByDsReportId(Long dsReportId);

}
