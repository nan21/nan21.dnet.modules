/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IReportParamService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

public class ReportParamService extends AbstractEntityService<ReportParam>
        implements IReportParamService {

    public ReportParamService() {
        super();
    }

    public ReportParamService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ReportParam> getEntityClass() {
        return ReportParam.class;
    }

    public ReportParam findByCode(Long clientId, Report report, String code) {
        return (ReportParam) this.em
                .createNamedQuery(ReportParam.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pReport", report).setParameter("pCode", code)
                .getSingleResult();
    }

    public ReportParam findByCode(Long clientId, Long reportId, String code) {
        return (ReportParam) this.em
                .createNamedQuery(ReportParam.NQ_FIND_BY_CODE_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pReportId", reportId)
                .setParameter("pCode", code).getSingleResult();
    }

    public ReportParam findByName(Long clientId, Report report, String name) {
        return (ReportParam) this.em
                .createNamedQuery(ReportParam.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pReport", report).setParameter("pName", name)
                .getSingleResult();
    }

    public ReportParam findByName(Long clientId, Long reportId, String name) {
        return (ReportParam) this.em
                .createNamedQuery(ReportParam.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pReportId", reportId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ReportParam> findByReport(Report report) {
        return this.findByReportId(report.getId());
    }

    public List<ReportParam> findByReportId(Long reportId) {
        return (List<ReportParam>) this.em
                .createQuery(
                        "select e from ReportParam e where e.report.id = :pReportId",
                        ReportParam.class).setParameter("pReportId", reportId)
                .getResultList();
    }

}
