/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ReportParam.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ReportParamLovDs.fCODE) })
public class ReportParamLovDs extends AbstractTypeWithCodeLov<ReportParam> {

    public static final String fREPORTID = "reportId";

    @DsField(join = "left", path = "report.id")
    private Long reportId;

    public ReportParamLovDs() {
        super();
    }

    public ReportParamLovDs(ReportParam e) {
        super(e);
    }

    public Long getReportId() {
        return this.reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

}
