/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.ReportLovDs;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

public class ReportLovDsConv extends AbstractDsConverter<ReportLovDs, Report>
        implements IDsConverter<ReportLovDs, Report> {

    protected void modelToEntityAttributes(ReportLovDs ds, Report e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ReportLovDs ds, Report e)
            throws Exception {
    }

    @Override
    public void entityToModel(Report e, ReportLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
