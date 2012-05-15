/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class DsReportUsageRtDsFilter extends AbstractAuditableDsFilter {

    private Long dsReportId;

    private Long dsReportId_From;
    private Long dsReportId_To;

    private Long reportId;

    private Long reportId_From;
    private Long reportId_To;

    private String reportCode;

    private String reportTitle;

    private String reportContextPath;

    private String serverUrl;

    private String frameName;

    private String toolbarKey;

    private String dcKey;

    public Long getDsReportId() {
        return this.dsReportId;
    }

    public Long getDsReportId_From() {
        return this.dsReportId_From;
    }

    public Long getDsReportId_To() {
        return this.dsReportId_To;
    }

    public void setDsReportId(Long dsReportId) {
        this.dsReportId = dsReportId;
    }

    public void setDsReportId_From(Long dsReportId_From) {
        this.dsReportId_From = dsReportId_From;
    }

    public void setDsReportId_To(Long dsReportId_To) {
        this.dsReportId_To = dsReportId_To;
    }

    public Long getReportId() {
        return this.reportId;
    }

    public Long getReportId_From() {
        return this.reportId_From;
    }

    public Long getReportId_To() {
        return this.reportId_To;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public void setReportId_From(Long reportId_From) {
        this.reportId_From = reportId_From;
    }

    public void setReportId_To(Long reportId_To) {
        this.reportId_To = reportId_To;
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
