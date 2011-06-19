/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;
import net.nan21.dnet.module.ad.report.domain.service.IReportServerService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportDs;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

public class ReportDsConv extends AbstractDsConverter<ReportDs, Report>
        implements IDsConverter<ReportDs, Report> {

    protected void modelToEntityAttributes(ReportDs ds, Report e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ReportDs ds, Report e)
            throws Exception {

        if (ds.getReportServerId() != null) {
            if (e.getReportServer() == null
                    || !e.getReportServer().getId()
                            .equals(ds.getReportServerId())) {
                e.setReportServer((ReportServer) this.em.getReference(
                        ReportServer.class, ds.getReportServerId()));
            }
        } else {
            this.lookup_reportServer_ReportServer(ds, e);
        }
    }

    protected void lookup_reportServer_ReportServer(ReportDs ds, Report e)
            throws Exception {
        ReportServer x = null;
        try {
            x = ((IReportServerService) getService(IReportServerService.class))
                    .findByName(ds.getClientId(), ds.getReportServerName());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setReportServer(x);
    }

    @Override
    public void entityToModel(Report e, ReportDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setReportServerId(((e.getReportServer() != null)) ? e
                .getReportServer().getId() : null);
        ds.setReportServerName(((e.getReportServer() != null)) ? e
                .getReportServer().getName() : null);
    }

}
