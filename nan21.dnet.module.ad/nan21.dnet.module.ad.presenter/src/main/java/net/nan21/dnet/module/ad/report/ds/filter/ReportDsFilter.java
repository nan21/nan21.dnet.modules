/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class ReportDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long reportServerId;

    private Long reportServerId_From;
    private Long reportServerId_To;

    private String reportServer;

    private String serverUrl;

    private String contextPath;

    public Long getReportServerId() {
        return this.reportServerId;
    }

    public Long getReportServerId_From() {
        return this.reportServerId_From;
    }

    public Long getReportServerId_To() {
        return this.reportServerId_To;
    }

    public void setReportServerId(Long reportServerId) {
        this.reportServerId = reportServerId;
    }

    public void setReportServerId_From(Long reportServerId_From) {
        this.reportServerId_From = reportServerId_From;
    }

    public void setReportServerId_To(Long reportServerId_To) {
        this.reportServerId_To = reportServerId_To;
    }

    public String getReportServer() {
        return this.reportServer;
    }

    public void setReportServer(String reportServer) {
        this.reportServer = reportServer;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getContextPath() {
        return this.contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

}
