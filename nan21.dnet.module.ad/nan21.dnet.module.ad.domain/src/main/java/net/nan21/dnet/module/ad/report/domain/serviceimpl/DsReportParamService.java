/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import net.nan21.dnet.module.ad.report.domain.service.IDsReportParamService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;

public class DsReportParamService extends AbstractEntityService<DsReportParam>
        implements IDsReportParamService {

    public DsReportParamService() {
        super();
    }

    public DsReportParamService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<DsReportParam> getEntityClass() {
        return DsReportParam.class;
    }

    public List<DsReportParam> findByDsReport(DsReport dsReport) {
        return this.findByDsReportId(dsReport.getId());
    }

    public List<DsReportParam> findByDsReportId(Long dsReportId) {
        return (List<DsReportParam>) this.em
                .createQuery(
                        "select e from DsReportParam where e.dsReport.id = :pDsReportId",
                        DsReportParam.class)
                .setParameter("pDsReportId", dsReportId).getResultList();
    }

    public List<DsReportParam> findByReportParam(ReportParam reportParam) {
        return this.findByReportParamId(reportParam.getId());
    }

    public List<DsReportParam> findByReportParamId(Long reportParamId) {
        return (List<DsReportParam>) this.em
                .createQuery(
                        "select e from DsReportParam where e.reportParam.id = :pReportParamId",
                        DsReportParam.class)
                .setParameter("pReportParamId", reportParamId).getResultList();
    }

}
