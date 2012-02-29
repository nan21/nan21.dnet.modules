/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IDsReportUsageService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;

public class DsReportUsageService extends AbstractEntityService<DsReportUsage>
        implements IDsReportUsageService {

    public DsReportUsageService() {
        super();
    }

    public DsReportUsageService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<DsReportUsage> getEntityClass() {
        return DsReportUsage.class;
    }

    public List<DsReportUsage> findByDsReport(DsReport dsReport) {
        return this.findByDsReportId(dsReport.getId());
    }

    public List<DsReportUsage> findByDsReportId(Long dsReportId) {
        return (List<DsReportUsage>) this.em
                .createQuery(
                        "select e from DsReportUsage e where e.clientId = :pClientId and e.dsReport.id = :pDsReportId",
                        DsReportUsage.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDsReportId", dsReportId).getResultList();
    }

}
