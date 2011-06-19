/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.service.IDsReportService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;

public class DsReportService extends AbstractEntityService<DsReport> implements
        IDsReportService {

    public DsReportService() {
        super();
    }

    public DsReportService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<DsReport> getEntityClass() {
        return DsReport.class;
    }

    public List<DsReport> findByReport(Report report) {
        return this.findByReportId(report.getId());
    }

    public List<DsReport> findByReportId(Long reportId) {
        return (List<DsReport>) this.em
                .createQuery(
                        "select e from DsReport where e.report.id = :pReportId",
                        DsReport.class).setParameter("pReportId", reportId)
                .getResultList();
    }

}
