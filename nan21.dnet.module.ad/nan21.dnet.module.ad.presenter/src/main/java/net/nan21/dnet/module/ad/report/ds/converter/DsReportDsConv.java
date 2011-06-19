/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.service.IReportService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.DsReportDs;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;

public class DsReportDsConv extends AbstractDsConverter<DsReportDs, DsReport>
        implements IDsConverter<DsReportDs, DsReport> {

    protected void modelToEntityAttributes(DsReportDs ds, DsReport e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDataSource(ds.getDataSource());
    }

    protected void modelToEntityReferences(DsReportDs ds, DsReport e)
            throws Exception {

        if (ds.getReportId() != null) {
            if (e.getReport() == null
                    || !e.getReport().getId().equals(ds.getReportId())) {
                e.setReport((Report) this.em.getReference(Report.class,
                        ds.getReportId()));
            }
        } else {
            this.lookup_report_Report(ds, e);
        }
    }

    protected void lookup_report_Report(DsReportDs ds, DsReport e)
            throws Exception {
        Report x = null;
        try {
            x = ((IReportService) getService(IReportService.class)).findByCode(
                    ds.getClientId(), ds.getReportCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setReport(x);
    }

    @Override
    public void entityToModel(DsReport e, DsReportDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDataSource(e.getDataSource());
        ds.setReportId(((e.getReport() != null)) ? e.getReport().getId() : null);
        ds.setReportCode(((e.getReport() != null)) ? e.getReport().getCode()
                : null);
    }

}
