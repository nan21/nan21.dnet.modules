/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ReportParam.class, jpqlWhere = "  e.active = true  ", sort = {
        @SortField(field = ReportParamRtDs.fSEQUENCENO),
        @SortField(field = ReportParamRtDs.fNAME) })
public class ReportParamRtDs extends AbstractTypeWithCodeDs<ReportParam> {

    public static final String fREPORTID = "reportId";
    public static final String fREPORTCODE = "reportCode";
    public static final String fVALUE = "value";
    public static final String fDATATYPE = "dataType";
    public static final String fPARAMETERNAME = "parameterName";
    public static final String fLISTOFVALUES = "listOfValues";
    public static final String fNOEDIT = "noEdit";
    public static final String fMANDATORY = "mandatory";
    public static final String fSEQUENCENO = "sequenceNo";

    @DsField(join = "left", path = "report.id")
    private Long reportId;

    @DsField(join = "left", path = "report.code")
    private String reportCode;

    @DsField(path = "defaultValue")
    private String value;

    @DsField()
    private String dataType;

    @DsField(path = "name")
    private String parameterName;

    @DsField()
    private String listOfValues;

    @DsField()
    private Boolean noEdit;

    @DsField()
    private Boolean mandatory;

    @DsField()
    private Integer sequenceNo;

    public ReportParamRtDs() {
        super();
    }

    public ReportParamRtDs(ReportParam e) {
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

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

}
