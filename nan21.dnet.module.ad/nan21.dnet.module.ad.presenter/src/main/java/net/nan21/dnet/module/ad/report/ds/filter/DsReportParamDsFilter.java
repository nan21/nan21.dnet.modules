/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class DsReportParamDsFilter extends AbstractAuditableDsFilter {

    private Long dsReportId;

    private Long dsReportId_From;
    private Long dsReportId_To;

    private Long reportId;

    private Long reportId_From;
    private Long reportId_To;

    private String reportCode;

    private Long paramId;

    private Long paramId_From;
    private Long paramId_To;

    private String paramCode;

    private String paramName;

    private String dataSource;

    private String dsField;

    private String staticValue;

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

    public Long getParamId() {
        return this.paramId;
    }

    public Long getParamId_From() {
        return this.paramId_From;
    }

    public Long getParamId_To() {
        return this.paramId_To;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public void setParamId_From(Long paramId_From) {
        this.paramId_From = paramId_From;
    }

    public void setParamId_To(Long paramId_To) {
        this.paramId_To = paramId_To;
    }

    public String getParamCode() {
        return this.paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return this.paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDsField() {
        return this.dsField;
    }

    public void setDsField(String dsField) {
        this.dsField = dsField;
    }

    public String getStaticValue() {
        return this.staticValue;
    }

    public void setStaticValue(String staticValue) {
        this.staticValue = staticValue;
    }

}
