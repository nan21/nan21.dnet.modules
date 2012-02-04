/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

public interface IReportServerService extends IEntityService<ReportServer> {

    public ReportServer findByName(Long clientId, String name);

}
