/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.report.ds.model.DsReportUsageDs;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;

public class DsReportUsageDsConv extends
        AbstractDsConverter<DsReportUsageDs, DsReportUsage> implements
        IDsConverter<DsReportUsageDs, DsReportUsage> {

    @Override
    protected void modelToEntityReferences(DsReportUsageDs ds, DsReportUsage e,
            boolean isInsert) throws Exception {

        if (ds.getDsReportId() != null) {
            if (e.getDsReport() == null
                    || !e.getDsReport().getId().equals(ds.getDsReportId())) {
                e.setDsReport((DsReport) this.em.find(DsReport.class,
                        ds.getDsReportId()));
            }
        }

    }

}
