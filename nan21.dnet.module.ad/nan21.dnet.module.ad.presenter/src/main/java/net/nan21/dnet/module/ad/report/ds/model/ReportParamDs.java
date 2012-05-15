/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ReportParam.class, sort = { @SortField(field = ReportParamDs.fNAME) })
public class ReportParamDs extends AbstractTypeWithCodeDs<ReportParam> {

    public static final String fREPORTID = "reportId";
    public static final String fREPORTCODE = "reportCode";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDEFAULTVALUE = "defaultValue";
    public static final String fDATATYPE = "dataType";
    public static final String fLISTOFVALUES = "listOfValues";
    public static final String fNOEDIT = "noEdit";
    public static final String fMANDATORY = "mandatory";

    @DsField(join = "left", path = "report.id")
    private Long reportId;

    @DsField(join = "left", path = "report.code")
    private String reportCode;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String defaultValue;

    @DsField()
    private String dataType;

    @DsField()
    private String listOfValues;

    @DsField()
    private Boolean noEdit;

    @DsField()
    private Boolean mandatory;

    public ReportParamDs() {
        super();
    }

    public ReportParamDs(ReportParam e) {
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

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

}
