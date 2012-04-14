/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = DsReport.class)
public class DsReportDs extends AbstractAuditableDs<DsReport> {

    public static final String fREPORTID = "reportId";
    public static final String fREPORTCODE = "reportCode";
    public static final String fDATASOURCE = "dataSource";

    @DsField(join = "left", path = "report.id")
    private Long reportId;

    @DsField(join = "left", path = "report.code")
    private String reportCode;

    @DsField()
    private String dataSource;

    public DsReportDs() {
        super();
    }

    public DsReportDs(DsReport e) {
        super(e);
    }

    public Long getReportId() {
        return this.reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportCode() {
        return this.reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

}
