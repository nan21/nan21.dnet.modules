/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(ReportParamDs ds, ReportParam e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDefaultValue(ds.getDefaultValue());
        e.setDataType(ds.getDataType());
    }

    protected void modelToEntityReferences(ReportParamDs ds, ReportParam e)
            throws Exception {

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
                x = ((IReportService) getService(IReportService.class))
                        .findByCode(ds.getClientId(), ds.getReportCode());
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

    @Override
    public void entityToModel(ReportParam e, ReportParamDs ds) throws Exception {
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
        ds.setDefaultValue(e.getDefaultValue());
        ds.setDataType(e.getDataType());
        ds.setReportId(((e.getReport() != null)) ? e.getReport().getId() : null);
        ds.setReportCode(((e.getReport() != null)) ? e.getReport().getCode()
                : null);
    }

}
