/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;
import net.nan21.dnet.module.ad.report.domain.service.IReportService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

public class ReportService extends AbstractEntityService<Report> implements
        IReportService {

    public ReportService() {
        super();
    }

    public ReportService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Report> getEntityClass() {
        return Report.class;
    }

    public Report findByCode(Long clientId, String code) {
        return (Report) this.em.createNamedQuery(Report.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Report findByName(Long clientId, String name) {
        return (Report) this.em.createNamedQuery(Report.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Report> findByReportServer(ReportServer reportServer) {
        return this.findByReportServerId(reportServer.getId());
    }

    public List<Report> findByReportServerId(Long reportServerId) {
        return (List<Report>) this.em
                .createQuery(
                        "select e from Report where e.reportServer.id = :pReportServerId",
                        Report.class)
                .setParameter("pReportServerId", reportServerId)
                .getResultList();
    }

}
