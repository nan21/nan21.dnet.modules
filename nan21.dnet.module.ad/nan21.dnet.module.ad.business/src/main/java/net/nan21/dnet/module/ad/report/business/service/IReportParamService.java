/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

public interface IReportParamService extends IEntityService<ReportParam> {

    public ReportParam findByCode(Long clientId, Report report, String code);

    public ReportParam findByCode(Long clientId, Long reportId, String code);

    public ReportParam findByName(Long clientId, Report report, String name);

    public ReportParam findByName(Long clientId, Long reportId, String name);

    public List<ReportParam> findByReport(Report report);

    public List<ReportParam> findByReportId(Long reportId);

}
