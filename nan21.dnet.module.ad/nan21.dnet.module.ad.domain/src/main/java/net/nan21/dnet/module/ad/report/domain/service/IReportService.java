/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

import net.nan21.dnet.module.ad.report.domain.entity.Report;

public interface IReportService extends IEntityService<Report> {

    public Report findByCode(Long clientId, String code);

    public Report findByName(Long clientId, String name);

    public List<Report> findByReportServer(ReportServer reportServer);

    public List<Report> findByReportServerId(Long reportServerId);

}
