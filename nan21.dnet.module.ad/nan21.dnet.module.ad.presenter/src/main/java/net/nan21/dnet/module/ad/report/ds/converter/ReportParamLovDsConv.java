/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportParamLovDs;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

public class ReportParamLovDsConv extends
        AbstractDsConverter<ReportParamLovDs, ReportParam> implements
        IDsConverter<ReportParamLovDs, ReportParam> {

    protected void modelToEntityAttributes(ReportParamLovDs ds, ReportParam e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ReportParamLovDs ds, ReportParam e)
            throws Exception {
    }

    @Override
    public void entityToModel(ReportParam e, ReportParamLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setReportId(((e.getReport() != null)) ? e.getReport().getId() : null);
    }

}
