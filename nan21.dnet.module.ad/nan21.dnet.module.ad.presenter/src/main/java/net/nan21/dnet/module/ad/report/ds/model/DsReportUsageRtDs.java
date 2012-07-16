/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;

@Ds(entity = DsReportUsage.class, jpqlWhere = " e.dsReport.report.active = true ")
public class DsReportUsageRtDs extends AbstractAuditableDs<DsReportUsage> {

    public static final String fDSREPORTID = "dsReportId";
    public static final String fREPORTID = "reportId";
    public static final String fREPORTCODE = "reportCode";
    public static final String fREPORTTITLE = "reportTitle";
    public static final String fREPORTCONTEXTPATH = "reportContextPath";
    public static final String fSERVERURL = "serverUrl";
    public static final String fFRAMENAME = "frameName";
    public static final String fTOOLBARKEY = "toolbarKey";
    public static final String fDCKEY = "dcKey";

    @DsField(join = "left", path = "dsReport.id")
    private Long dsReportId;

    @DsField(join = "left", path = "dsReport.report.id")
    private Long reportId;

    @DsField(join = "left", path = "dsReport.report.code")
    private String reportCode;

    @DsField(join = "left", path = "dsReport.report.name")
    private String reportTitle;

    @DsField(join = "left", path = "dsReport.report.contextPath")
    private String reportContextPath;

    @DsField(join = "left", path = "dsReport.report.reportServer.url")
    private String serverUrl;

    @DsField()
    private String frameName;

    @DsField()
    private String toolbarKey;

    @DsField()
    private String dcKey;

    public DsReportUsageRtDs() {
        super();
    }

    public DsReportUsageRtDs(DsReportUsage e) {
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

    public String getReportTitle() {
        return this.reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportContextPath() {
        return this.reportContextPath;
    }

    public void setReportContextPath(String reportContextPath) {
        this.reportContextPath = reportContextPath;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
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
