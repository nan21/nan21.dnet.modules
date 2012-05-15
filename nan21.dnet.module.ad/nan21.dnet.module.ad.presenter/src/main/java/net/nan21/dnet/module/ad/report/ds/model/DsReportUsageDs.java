/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = DsReportUsage.class)
public class DsReportUsageDs extends AbstractAuditableDs<DsReportUsage> {

    public static final String fDSREPORTID = "dsReportId";
    public static final String fREPORTID = "reportId";
    public static final String fREPORTCODE = "reportCode";
    public static final String fFRAMENAME = "frameName";
    public static final String fTOOLBARKEY = "toolbarKey";
    public static final String fDCKEY = "dcKey";

    @DsField(join = "left", path = "dsReport.id")
    private Long dsReportId;

    @DsField(join = "left", path = "dsReport.report.id")
    private Long reportId;

    @DsField(join = "left", path = "dsReport.report.code")
    private String reportCode;

    @DsField()
    private String frameName;

    @DsField()
    private String toolbarKey;

    @DsField()
    private String dcKey;

    public DsReportUsageDs() {
        super();
    }

    public DsReportUsageDs(DsReportUsage e) {
        super(e);
    }

    public Long getDsReportId() {
        return this.dsReportId;
    }

    public void setDsReportId(Long dsReportId) {
        this.dsReportId = dsReportId;
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

    public String getFrameName() {
        return this.frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    public String getToolbarKey() {
        return this.toolbarKey;
    }

    public void setToolbarKey(String toolbarKey) {
        this.toolbarKey = toolbarKey;
    }

    public String getDcKey() {
        return this.dcKey;
    }

    public void setDcKey(String dcKey) {
        this.dcKey = dcKey;
    }

}
