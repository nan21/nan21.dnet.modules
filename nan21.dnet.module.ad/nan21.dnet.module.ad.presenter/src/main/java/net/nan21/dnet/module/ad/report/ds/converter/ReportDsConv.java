/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.report.business.service.IReportServerService;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportDs;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

public class ReportDsConv extends AbstractDsConverter<ReportDs, Report>
        implements IDsConverter<ReportDs, Report> {

    @Override
    protected void modelToEntityReferences(ReportDs ds, Report e,
            boolean isInsert) throws Exception {

        if (ds.getReportServerId() != null) {
            if (e.getReportServer() == null
                    || !e.getReportServer().getId()
                            .equals(ds.getReportServerId())) {
                e.setReportServer((ReportServer) this.em.find(
                        ReportServer.class, ds.getReportServerId()));
            }
        } else {
            this.lookup_reportServer_ReportServer(ds, e);
        }

    }

    protected void lookup_reportServer_ReportServer(ReportDs ds, Report e)
            throws Exception {
        if (ds.getReportServer() != null && !ds.getReportServer().equals("")) {
            ReportServer x = null;
            try {
                x = ((IReportServerService) findEntityService(ReportServer.class))
                        .findByName(ds.getReportServer());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ReportServer` reference:  `reportServer` = "
                                + ds.getReportServer() + "  ");
            }
            e.setReportServer(x);

        } else {
            e.setReportServer(null);
        }
    }

}
