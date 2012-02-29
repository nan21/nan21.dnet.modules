/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class DsReportParamRtDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    private String paramDataType;

    private Boolean paramMandatory;

    private String paramDefaultValue;

    private String paramListOfValues;

    private Boolean paramNoEdit;

    private String dataSource;

    private String dsField;

    private String staticValue;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

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

    public String getParamDataType() {
        return this.paramDataType;
    }

    public void setParamDataType(String paramDataType) {
        this.paramDataType = paramDataType;
    }

    public Boolean getParamMandatory() {
        return this.paramMandatory;
    }

    public void setParamMandatory(Boolean paramMandatory) {
        this.paramMandatory = paramMandatory;
    }

    public String getParamDefaultValue() {
        return this.paramDefaultValue;
    }

    public void setParamDefaultValue(String paramDefaultValue) {
        this.paramDefaultValue = paramDefaultValue;
    }

    public String getParamListOfValues() {
        return this.paramListOfValues;
    }

    public void setParamListOfValues(String paramListOfValues) {
        this.paramListOfValues = paramListOfValues;
    }

    public Boolean getParamNoEdit() {
        return this.paramNoEdit;
    }

    public void setParamNoEdit(Boolean paramNoEdit) {
        this.paramNoEdit = paramNoEdit;
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
