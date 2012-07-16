/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

@Ds(entity = Report.class, sort = { @SortField(field = ReportDs.fNAME) })
public class ReportDs extends AbstractTypeWithCodeDs<Report> {

    public static final String fREPORTSERVERID = "reportServerId";
    public static final String fREPORTSERVER = "reportServer";
    public static final String fSERVERURL = "serverUrl";
    public static final String fCONTEXTPATH = "contextPath";

    @DsField(join = "left", path = "reportServer.id")
    private Long reportServerId;

    @DsField(join = "left", path = "reportServer.name")
    private String reportServer;

    @DsField(join = "left", path = "reportServer.url")
    private String serverUrl;

    @DsField()
    private String contextPath;

    public ReportDs() {
        super();
    }

    public ReportDs(Report e) {
        super(e);
    }

    public Long getReportServerId() {
        return this.reportServerId;
    }

    public void setReportServerId(Long reportServerId) {
        this.reportServerId = reportServerId;
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
