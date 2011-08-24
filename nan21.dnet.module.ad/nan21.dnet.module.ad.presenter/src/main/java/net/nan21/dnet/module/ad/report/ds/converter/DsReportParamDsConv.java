/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.report.business.service.IReportParamService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;

public class DsReportParamDsConv extends
        AbstractDsConverter<DsReportParamDs, DsReportParam> implements
        IDsConverter<DsReportParamDs, DsReportParam> {

    protected void modelToEntityAttributes(DsReportParamDs ds, DsReportParam e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDsField(ds.getDsField());
    }

    protected void modelToEntityReferences(DsReportParamDs ds, DsReportParam e)
            throws Exception {

        if (ds.getDsReportId() != null) {
            if (e.getDsReport() == null
                    || !e.getDsReport().getId().equals(ds.getDsReportId())) {
                e.setDsReport((DsReport) this.em.getReference(DsReport.class,
                        ds.getDsReportId()));
            }
        }
        if (ds.getParamId() != null) {
            if (e.getReportParam() == null
                    || !e.getReportParam().getId().equals(ds.getParamId())) {
                e.setReportParam((ReportParam) this.em.getReference(
                        ReportParam.class, ds.getParamId()));
            }
        } else {
            this.lookup_reportParam_ReportParam(ds, e);
        }
    }

    protected void lookup_reportParam_ReportParam(DsReportParamDs ds,
            DsReportParam e) throws Exception {
        if (ds.getReportId() != null && ds.getParamCode() != null) {
            ReportParam x = null;
            try {
                x = ((IReportParamService) getService(IReportParamService.class))
                        .findByCode(ds.getClientId(), ds.getReportId(),
                                ds.getParamCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ReportParam` reference:  `reportId` = "
                                + ds.getReportId() + " , `paramCode` = "
                                + ds.getParamCode() + "  ");
            }
            e.setReportParam(x);
        }
    }

    @Override
    public void entityToModel(DsReportParam e, DsReportParamDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDsField(e.getDsField());
        ds.setDsReportId(((e.getDsReport() != null)) ? e.getDsReport().getId()
                : null);
        ds.setReportId(((e.getDsReport() != null) && (e.getDsReport()
                .getReport() != null)) ? e.getDsReport().getReport().getId()
                : null);
        ds.setReportCode(((e.getDsReport() != null) && (e.getDsReport()
                .getReport() != null)) ? e.getDsReport().getReport().getCode()
                : null);
        ds.setParamId(((e.getReportParam() != null)) ? e.getReportParam()
                .getId() : null);
        ds.setParamCode(((e.getReportParam() != null)) ? e.getReportParam()
                .getCode() : null);
        ds.setParamName(((e.getReportParam() != null)) ? e.getReportParam()
                .getName() : null);
        ds.setDataSource(((e.getDsReport() != null)) ? e.getDsReport()
                .getDataSource() : null);
    }

}
