/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.report.business.service.IReportService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportParamDs;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

public class ReportParamDsConv extends
        AbstractDsConverter<ReportParamDs, ReportParam> implements
        IDsConverter<ReportParamDs, ReportParam> {

    @Override
    protected void modelToEntityReferences(ReportParamDs ds, ReportParam e,
            boolean isInsert) throws Exception {

        if (ds.getReportId() != null) {
            if (e.getReport() == null
                    || !e.getReport().getId().equals(ds.getReportId())) {
                e.setReport((Report) this.em.find(Report.class,
                        ds.getReportId()));
            }
        } else {
            this.lookup_report_Report(ds, e);
        }

    }

    protected void lookup_report_Report(ReportParamDs ds, ReportParam e)
            throws Exception {
        if (ds.getReportCode() != null && !ds.getReportCode().equals("")) {
            Report x = null;
            try {
                x = ((IReportService) findEntityService(Report.class))
                        .findByCode(ds.getReportCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Report` reference:  `reportCode` = "
                                + ds.getReportCode() + "  ");
            }
            e.setReport(x);

        } else {
            e.setReport(null);
        }
    }

}
