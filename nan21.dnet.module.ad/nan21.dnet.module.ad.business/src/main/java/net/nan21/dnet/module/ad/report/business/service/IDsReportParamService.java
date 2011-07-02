/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;

public interface IDsReportParamService extends IEntityService<DsReportParam> {

    public List<DsReportParam> findByDsReport(DsReport dsReport);

    public List<DsReportParam> findByDsReportId(Long dsReportId);

    public List<DsReportParam> findByReportParam(ReportParam reportParam);

    public List<DsReportParam> findByReportParamId(Long reportParamId);

}
