/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class ReportParamRtDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long reportId;

    private Long reportId_From;
    private Long reportId_To;

    private String reportCode;

    private String value;

    private String dataType;

    private String parameterName;

    private String listOfValues;

    private Boolean noEdit;

    private Boolean mandatory;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

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

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getParameterName() {
        return this.parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getListOfValues() {
        return this.listOfValues;
    }

    public void setListOfValues(String listOfValues) {
        this.listOfValues = listOfValues;
    }

    public Boolean getNoEdit() {
        return this.noEdit;
    }

    public void setNoEdit(Boolean noEdit) {
        this.noEdit = noEdit;
    }

    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
    }

}
