/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IReportService;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

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

    public Report findByCode(String code) {
        return (Report) this.em.createNamedQuery(Report.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Report findByName(String name) {
        return (Report) this.em.createNamedQuery(Report.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Report> findByReportServer(ReportServer reportServer) {
        return this.findByReportServerId(reportServer.getId());
    }

    public List<Report> findByReportServerId(Long reportServerId) {
        return (List<Report>) this.em
                .createQuery(
                        "select e from Report e where e.clientId = :pClientId and e.reportServer.id = :pReportServerId",
                        Report.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pReportServerId", reportServerId)
                .getResultList();
    }

}
